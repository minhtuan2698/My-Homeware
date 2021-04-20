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
@WebServlet("/Cart_Controller")
public class Cart_Controller extends HttpServlet {

	Cart cart = new Cart();

	ProductDao prdao = new ProductDao_Impl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		
		
		int ID_Product = 0;
		if(request.getParameter("ID_Product")!=null)
			ID_Product = Integer.parseInt(request.getParameter("ID_Product"));
			
		String action = "";
		if(request.getParameter("action")!=null)
			action = request.getParameter("action");

	
		try {
			Product pr = prdao.GetProduct(ID_Product);

			switch (action) {
			
			case "insert":{
				if(cart.getCart().containsKey(ID_Product)) {
					HashMap<Integer, Item> map = cart.getCart();
					if(map.get(ID_Product).getQuantity()<pr.getQuantity()) {
						cart.AddProduct(ID_Product, pr);
						System.out.println("Thanh cong");
					}
					
				}
				else cart.AddProduct(ID_Product, pr);

			}
				
				break;
				
			case "sub":{
				cart.SubProduct(ID_Product);
			}
				
				break;
				
			case "remove":{
				cart.RemoveProduct(ID_Product);
			}
				
				break;
				

			default:
				break;
			}
			
			if(cart.getCart()!=null) {
				session.setAttribute("cart", cart);
			}

			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
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
