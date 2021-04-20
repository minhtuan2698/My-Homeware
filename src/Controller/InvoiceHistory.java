package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.InvoiceDao;
import Dao.InvoiceDao_Impl;
import Dao.InvoiceDetailDao;
import Dao.InvoiceDetailDao_Impl;
import Dao.ProductDao;
import Dao.ProductDao_Impl;
import Model.InvoiceDetail;

/**
 * Servlet implementation class InvoiceHistory
 */
@WebServlet("/InvoiceHistory")
public class InvoiceHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String ID_Invoice = request.getParameter("ID_Invoice");
		
		String success = "";
		if(request.getAttribute("success")!=null)
				success = (String) request.getAttribute("success");
		
		switch (action) {
		case "View":{
			
			request.setAttribute("success", success);
			RequestDispatcher rq = request.getRequestDispatcher("historyDetail.jsp");
			rq.forward(request, response);

		}
			
			break;
		case "Cancel":{
			
			InvoiceDetailDao invoicedetaildao = new InvoiceDetailDao_Impl();
			ProductDao prdao = new ProductDao_Impl();
			InvoiceDao invoicedao = new InvoiceDao_Impl();
			invoicedao.UpdateInvoice(ID_Invoice, 4);
			ArrayList<InvoiceDetail> arr = new ArrayList<InvoiceDetail>();
			arr = invoicedetaildao.GetList_InvoiceDetail(ID_Invoice);
			for(InvoiceDetail i : arr) {
				prdao.UpdateQuantity(Integer.parseInt(i.getProduct().getId_product()) , i.getQuantity());
				System.out.println(i.getProduct().getId_product() + i.getQuantity());
	
			}
			
			
			RequestDispatcher rq = request.getRequestDispatcher("InvoiceDetail.jsp");
			rq.forward(request, response);
		
		}
		break;

		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
