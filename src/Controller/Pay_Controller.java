package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.InvoiceDao;
import Dao.InvoiceDao_Impl;
import Dao.InvoiceDetailDao;
import Dao.InvoiceDetailDao_Impl;
import Dao.ProductDao;
import Dao.ProductDao_Impl;
import Model.Account;
import Model.Cart;
import Model.Invoice;
import Model.InvoiceDetail;
import Model.Item;
import Model.Product;
import Other.SendEmail;

/**
 * Servlet implementation class Pay_Controller
 */
@WebServlet("/Pay_Controller")
public class Pay_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay_Controller() {
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
		InvoiceDao invoicedao = new InvoiceDao_Impl();
		Cart cart = new Cart();
		if(session.getAttribute("cart")!=null)
			cart = (Cart) session.getAttribute("cart"); 
		HashMap<Integer,Item> map = cart.getCart();
		int Total = cart.total(map);

		
		String Fullname = request.getParameter("Fullname");
		String Shipping_Address = request.getParameter("Shipping_Address");
		String Phone = request.getParameter("Phone");
		String Time_Giaohang_Dukien = request.getParameter("Time_Giaohang");
		String Payment_Method = request.getParameter("Payment_Method");
	
		String eFullname = "",eShipping_Address="", ePhone="";
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss, dd/MM/yyyy");
		Date date = new Date();
		String Time_Dathang = formatter.format(date);
		
		System.out.println("Thoi gian dat hang: "+ Time_Dathang);
		
		Pattern pattern = Pattern.compile("^(0)+[0-9]*$");
		Matcher matcherPhone = pattern.matcher(Phone);
		
		if(Fullname.equals("")) eFullname = "Vui lòng nhập họ và tên người nhận !";
		
		if(Phone.equals("")) ePhone = "Vui lòng nhập số điện thoại người nhận !";
		else {
			if(!matcherPhone.matches()) ePhone = "Số điện thoại không đúng định dạng !";
		}
		
		if(Shipping_Address.equals("")) eShipping_Address = "Vui lòng nhập địa chỉ nhận hàng !";
		
		if(eFullname.length()>0) request.setAttribute("eFullname", eFullname);
		if(ePhone.length()>0) request.setAttribute("ePhone", ePhone);
		if(eShipping_Address.length()>0) request.setAttribute("eShipping_Address", eShipping_Address);
		
		String url = "checkout.jsp";
		
		if(eFullname.length()==0&&ePhone.length()==0&&eShipping_Address.length()==0) {
			String ID_Invoice = "INV" + date.getTime();
			
			Account acc = (Account) session.getAttribute("SessionUsername");
			Invoice invoice = new Invoice();
			invoice.setID_Invoice(ID_Invoice);
			invoice.setAccount(acc);
			invoice.setShipping_Address(Shipping_Address);
			invoice.setPayment_Method(Payment_Method);
			invoice.setTime_Dathang(Time_Dathang);
			invoice.setStatus(1);
			invoice.setTotal(Total);
			invoice.setTime_Giaohang_Dukien(Time_Giaohang_Dukien);
	
			
			invoicedao.InsertInvoice(invoice);
			
			
			
			InvoiceDetail invoiceDetail = new InvoiceDetail();
			Set<Map.Entry<Integer,Item>> set = map.entrySet();
			
			for (Entry<Integer, Item> i : set){
				Random rd = new Random();
				String id = String.valueOf(rd.nextInt(99999999));
				
				String ID_InvoiceDetail = "INVD"+ id;
	
				int Quantity = i.getValue().getQuantity();
				int Price = i.getValue().getProduct().getPrice();
				int Sale = i.getValue().getProduct().getSale();
				int gia = Price - Sale;
				
				invoiceDetail.setID_InvoiceDetail(ID_InvoiceDetail);
				invoiceDetail.setInvoice(invoice);
				invoiceDetail.setProduct(i.getValue().getProduct());
				invoiceDetail.setQuantity(Quantity);
				invoiceDetail.setPrice(Price);
				invoiceDetail.setSale(Sale);
				invoiceDetail.setTotal(gia);
				
				InvoiceDetailDao INVD_Dao = new InvoiceDetailDao_Impl();
				
				System.out.println("Trạng thái: "+ INVD_Dao.insert(invoiceDetail));
				
				ProductDao pr = new ProductDao_Impl();
				System.out.println("Update: "+ pr.UpdateQuantity(i.getKey(), -Quantity));
				
			}
			
			map.clear();
			session.removeAttribute("cart");
			
			String Email = acc.getEmail();
			SendEmail mail = new SendEmail();
			mail.Sendmail(Email,"Success","Bạn đã đặt hàng thành công tại Shop T - Homeware ! Thankyou very much <3");
			url = "BuySuccess.jsp";
			
			
			
			
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	
	}

}
