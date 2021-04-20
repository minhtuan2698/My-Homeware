package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AccountDao;
import Dao.AccountDao_Impl;
import Model.Account;
import Other.MD5;
import Other.SendEmail;

/**
 * Servlet implementation class Register_Controller
 */
@WebServlet("/Register_Controller")
public class Register_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountDao accdao = new AccountDao_Impl();
		
		MD5 md5 = new MD5();
		
		
		String Username = request.getParameter("username");
		String Password1 = request.getParameter("password1");
		String Password2 = request.getParameter("password2");
		String Email = request.getParameter("email");
		String Fullname = request.getParameter("fullname");
		String Phone = request.getParameter("phone");
		String Address = request.getParameter("address");
		String eUsername = "", ePassword1 = "", ePassword2 = "", eEmail = "", eFullname = "", ePhone = "", eAddress = "";

		String emailPattern = "^[\\w!#$%&�*+/=?`{|}~^-]+(?:\\.[\\w!#$%&�*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern regex = Pattern.compile(emailPattern);
		Matcher matcherEmail = regex.matcher(Email);

		Pattern pattern = Pattern.compile("^(0)+[0-9]*$");
		Matcher matcherPhone = pattern.matcher(Phone);

		Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9-]*$");
		Matcher matcherUsername = pattern1.matcher(Username);
		
		if(Username.equals("")) eUsername = "Vui lòng nhập tên tài khoản của bạn !";
		else {
			if(accdao.CheckUsername(Username)) eUsername = "Tên tài khoản đã tồn tại !";
			else if(!matcherUsername.matches()) eUsername = "Tên tài khoản không đúng định dạng";
		}
		if(Password1.equals("")) ePassword1 = "Vui lòng nhập mật khẩu của bạn!";
		
		
		if(Password2.equals("")) ePassword2 = "Vui lòng nhập mật khẩu của bạn !";
		else if(!Password2.equals(Password1)) ePassword2 = "Mật khẩu không khớp";
		
		if(Email.equals("")) eEmail = "Vui lòng nhập email của bạn !";
		else {
			if(accdao.CheckEmail(Email)) eEmail = "Email đã tồn tại !";
			else if(!matcherEmail.matches()) eEmail = "Email không đúng định dạng !";
		}
		
		if(Fullname.equals("")) eFullname = "Vui lòng nhâp tên đầy đủ của bạn !";
		
		
		if(Phone.equals("")) ePhone = "Vui lòng nhập só điện thoại của bạn !";
		else {
			if(accdao.CheckPhone(Phone)) ePhone = "Số điện thoại đã tồn tại";
			else if(!matcherPhone.matches()) ePhone = "Số điện thoại không đúng định dạng !";
		}
		
		if(Address.equals("")) eAddress = "Vui lòng nhập địa chỉ của bạn !";
		
		if(eUsername.length()>0)
		request.setAttribute("eUsername", eUsername);
		
		if(ePassword1.length()>0)
			request.setAttribute("ePassword1", ePassword1);
		
		if(ePassword2.length()>0)
			request.setAttribute("ePassword2", ePassword2);
		
		if(eEmail.length()>0)
			request.setAttribute("eEmail", eEmail);
		
		if(eFullname.length()>0)
			request.setAttribute("eFullname", eFullname);
		
		if(ePhone.length()>0)
			request.setAttribute("ePhone", ePhone);
		
		if(eAddress.length()>0)
			request.setAttribute("eAddress", eAddress);
		
		String url = "register.jsp";
		
		if(eUsername.length()==0 && ePassword1.length()== 0 && ePassword2.length()==0 && eEmail.length() == 0 && eFullname.length() == 0 && ePhone.length() == 0 && eAddress.length()==0)
		{
			Date date = new Date();
			String id_account = "KH" + date.getTime();
			Account acc = new Account();
			acc.setId_account(id_account);
			acc.setUsername(Username);
			acc.setPassword(md5.md5(Password1));
			acc.setEmail(Email);
			acc.setFullname(Fullname);
			acc.setAddress(Address);
			acc.setPhone(Phone);
			acc.setAccess(2);
			acc.setStatus(1);
			accdao.InsertAcount(acc);
			
			
			url = "Success.jsp";
			
			SendEmail mail = new SendEmail();
			mail.Sendmail(Email,"Wellcome !","Chúc mừng bạn đã đăng ký thành công tài khoản tại T-Homeware ! ");

		}
		
		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);
		
		
		
				

	}

}
