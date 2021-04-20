package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AccountDao;
import Dao.AccountDao_Impl;
import Model.Account;
import Other.MD5;

/**
 * Servlet implementation class Login_Controller
 */
@WebServlet("/Login_Controller")
public class Login_Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("enter").equals("logout")) {

			Cookie cUsername = new Cookie("cookuser", null);
			Cookie cPassword = new Cookie("cookpass", null);
			Cookie cRemember = new Cookie("cookrem", null);

			cUsername.setMaxAge(0);
			cPassword.setMaxAge(0);
			cRemember.setMaxAge(0);

			response.addCookie(cUsername);
			response.addCookie(cPassword);
			response.addCookie(cRemember);

			HttpSession httpSession = request.getSession();
			httpSession.invalidate();

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("account.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MD5 md5 = new MD5();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AccountDao dao = new AccountDao_Impl();
		
		Account acc = dao.CheckLogin(username, md5.md5(password));
		String error = "";
		
		
		if(username.equals("")||password.equals("")) error = "Vui lòng nhập đầy đủ thông tin !";
		else if(!dao.Check(username, password)) error = "Sai tài khoản hoặc mật khẩu !"; 
		
		if(error.length()>0) request.setAttribute("error", error);
		RequestDispatcher rqq = request.getRequestDispatcher("account.jsp");
		String url = "account.jsp";
		
		if (username != null && username.length() != 0 && password != null && password.length() != 0 && acc != null
				&& dao.Check(username, md5.md5(password))) {
			if (request.getParameter("rememberme") != null) {
				String remember = request.getParameter("rememberme");
				Cookie cUsername = new Cookie("cookuser", username);
				Cookie cPassword = new Cookie("cookpass", password);
				Cookie cRemember = new Cookie("cookrem", remember);

				cUsername.setMaxAge(60 * 60 * 24 * 15);
				cPassword.setMaxAge(60 * 60 * 24 * 15);
				cRemember.setMaxAge(60 * 60 * 24 * 15);

				response.addCookie(cUsername);
				response.addCookie(cPassword);
				response.addCookie(cRemember);
			}

			if(acc.getAccess()==2) url = "index.jsp";
			else if(acc.getAccess()==1 || acc.getAccess()==3 || acc.getAccess()==4) url = "Admin/product.jsp";
			
			HttpSession session = request.getSession();
			session.setAttribute("SessionUsername", acc);
			

		}
		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);
			


	}

}
