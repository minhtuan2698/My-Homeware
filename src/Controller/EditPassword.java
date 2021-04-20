package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AccountDao;
import Dao.AccountDao_Impl;

/**
 * Servlet implementation class EditPassword
 */
@WebServlet("/EditPassword")
public class EditPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String Password1 = request.getParameter("password1");
		String Password2 = request.getParameter("password2");
		
		String ePassword1 = "", ePassword2 = "";
		
		if(Password1.equals("")) ePassword1 = "Vui lòng nhập mật khẩu của bạn!";
		
		
		if(Password2.equals("")) ePassword2 = "Vui lòng nhập mật khẩu của bạn !";
		else if(!Password2.equals(Password1)) ePassword2 = "Mật khẩu không khớp";
		
		if(ePassword1.length()>0)
			request.setAttribute("ePassword1", ePassword1);
		
		if(ePassword2.length()>0)
			request.setAttribute("ePassword2", ePassword2);
		
		String url = "EditPassword.jsp";
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(ePassword1.length()==0 && ePassword2.length()==0) {
			AccountDao accdao = new AccountDao_Impl();
			
			if(accdao.EditPassword(username, Password1)) {
				String a = "Đổi mât khẩu thành công !";
				url = "Success.jsp";
				
			}
		}
		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);
		
	}

}
