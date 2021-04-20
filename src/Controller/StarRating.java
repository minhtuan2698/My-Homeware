package Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Star_RatingDao;
import Dao.Star_RatingDao_Impl;
import Model.Account;
import Model.InvoiceDetail;
import Model.Product;
import Model.Star_Rating;

/**
 * Servlet implementation class StarRating
 */
@WebServlet("/StarRating")
public class StarRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StarRating() {
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
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("SessionUsername");
		String ID_Product = request.getParameter("idpr");
		String ID_Invoice = request.getParameter("idinv");
		String ID_InvoiceDetail = request.getParameter("idinvoicedetail");
		
		System.out.print("IDPR: " + ID_Product);
		System.out.print("ID INVOICEDETAIL: " + ID_InvoiceDetail);
		
		String rate = request.getParameter("rate");
		int star = Integer.parseInt(rate);
		String comment = request.getParameter("comment");
		
		Date date = new Date();
		String ID_Rate = "SR"+date.getTime();
		Product pr = new Product(ID_Product);
		InvoiceDetail invoicedetail = new InvoiceDetail(ID_InvoiceDetail);
		
		
		
		Star_RatingDao ratedao = new Star_RatingDao_Impl();
		Star_Rating star_rating = new Star_Rating();
		star_rating.setID_Rate(ID_Rate);
		star_rating.setAccount(acc);
		star_rating.setProduct(pr);
		star_rating.setStar(star);
		star_rating.setComment(comment);
		star_rating.setInvoiceDetail(invoicedetail);
		
		System.out.print("ID INVOICE: " + ID_Invoice);
		
		System.out.println("Trang thai insert: "+ratedao.insert(star_rating));
		
		String success = "Cảm ơn bạn đã đánh giá sản phẩm ! Thank U very much <3";
		request.setAttribute("success", success);
				
		
		String url = "InvoiceHistory?action=View&ID_Invoice=" + ID_Invoice;
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
