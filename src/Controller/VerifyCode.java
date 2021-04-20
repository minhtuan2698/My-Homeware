package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UserCode;

/**
 * Servlet implementation class VerifyCode
 */
@WebServlet("/VerifyCode")
public class VerifyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifyCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
	
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		HttpSession session = request.getSession();
		UserCode usercode = (UserCode) session.getAttribute("usercode");
		
		session.setAttribute("username", usercode.getUsername());
		
		System.out.println(usercode.getCode());
		String url = "";
		if (code==(usercode.getCode())) url = "EditPassword.jsp";
		else {
			String error = "Mã code không đúng ! Vui lòng nhập lại ";
			request.setAttribute("error", error);
			url = "VerifyCode.jsp";
		}
		
		
		
		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);
		
			
		
	}

}
