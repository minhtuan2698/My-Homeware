package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;
import Dao.ProductDao_Impl;
import Model.Product;

/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao_Impl dao = new ProductDao_Impl();
		int count = dao.GetTotalProduct();
		int EndPage = count/3;
		if(count %3 !=0) EndPage ++;
		System.out.print(EndPage);
		int index = 1;
		if (request.getParameter("index") != null)
			index = Integer.parseInt(request.getParameter("index"));
		ProductDao prdao = new ProductDao_Impl();
		ArrayList<Product> List_AllProduct = prdao.PagingProduct(index);
		request.setAttribute("endpage", EndPage);
		request.setAttribute("list_all", List_AllProduct);
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
