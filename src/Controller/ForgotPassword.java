package Controller;

import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AccountDao;
import Dao.AccountDao_Impl;
import Model.UserCode;
import Other.SendEmail;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");

		HttpSession session = request.getSession();
		UserCode usercode = (UserCode) session.getAttribute("usercode");
		if (code.equals(usercode.getCode())) {
			RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
			rq.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AccountDao accdao = new AccountDao_Impl();

		String username = request.getParameter("username");
		String email = request.getParameter("email");

		String eUsername = "", eEmail = "";

		String emailPattern = "^[\\w!#$%&�*+/=?`{|}~^-]+(?:\\.[\\w!#$%&�*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern regex = Pattern.compile(emailPattern);
		Matcher matcherEmail = regex.matcher(email);

		Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9-]*$");
		Matcher matcherUsername = pattern1.matcher(username);

		if (username.equals(""))
			eUsername = "Vui lòng nhập tên tài khoản của bạn !";
		else {
			if (!accdao.CheckUsername(username))
				eUsername = "Tài khoản chưa tồn tại !";
			else if (!matcherUsername.matches())
				eUsername = "Tên tài khoản không đúng định dạng";
		}

		if(email.equals("")) eEmail = "Vui lòng nhập email của bạn !";
		else {
			if(!accdao.CheckUserEmail(username, email)) eEmail = "Email không đúng !";
			else if(!matcherEmail.matches()) eEmail = "Email không đúng định dạng !";
		}
		if (eUsername.length() > 0)
			request.setAttribute("eUsername", eUsername);

		if (eEmail.length() > 0)
			request.setAttribute("eEmail", eEmail);

		String url = "ForgotPassword.jsp";

		System.out.print(username + "-" + email);

		if (eUsername.length() == 0 && eEmail.length() == 0) {
			SendEmail sendemail = new SendEmail();
			int code = sendemail.GetRandom();

			System.out.print(code);

			UserCode usercode = new UserCode();
			usercode.setUsername(username);
			usercode.setEmail(email);
			usercode.setCode(code);

			if (sendemail.Email(usercode)) {

				HttpSession session = request.getSession();
				session.setAttribute("usercode", usercode);

				url = "VerifyCode.jsp";
			}

		}

		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);

	}

}
