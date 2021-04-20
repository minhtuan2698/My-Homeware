package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDao;
import Dao.ProductDao_Impl;
import Model.Account;
import Model.Cart;
import Model.Item;
import Model.Product;

/**
 * Servlet implementation class Cart_Controller
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {

	Cart cart = new Cart();
	
	Account acc = new Account();

	ProductDao prdao = new ProductDao_Impl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Checkout() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = "",url="";
		HttpSession session = request.getSession();
		
		if(session.getAttribute("cart")!=null)
			cart = (Cart) session.getAttribute("cart");
		
		HashMap<Integer, Item> map = cart.getCart();
		

		if(session.getAttribute("SessionUsername")!=null) 
			acc = (Account) session.getAttribute("SessionUsername");
		
		
		if(session.getAttribute("cart")==null||cart.total(map)==0)  {
			error = "Giỏ hàng chưa có gì để thanh toán ! Vui lòng thêm sản phẩm vào giỏ hàng !";
			url = "cart.jsp";
		}
		else {
			if(session.getAttribute("SessionUsername")==null) {
				url = "account.jsp"; 
			}
			else url = "checkout.jsp";
			
		}
		
		if(error.length()>0) request.setAttribute("error", error);
		request.getRequestDispatcher(url).forward(request, response);
		System.out.print("Loi: "+error);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
