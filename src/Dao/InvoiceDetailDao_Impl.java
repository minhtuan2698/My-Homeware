package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Connection.DBConnection;
import Model.Invoice;
import Model.InvoiceDetail;
import Model.Product;

public class InvoiceDetailDao_Impl implements InvoiceDetailDao{

	@Override
	public ArrayList<InvoiceDetail> GetList_InvoiceDetail(String ID_Invoice) {
		ArrayList<InvoiceDetail> arr = new ArrayList<InvoiceDetail>();
		try {
			String query="SELECT * FROM Invoice_Detail WHERE ID_Invoice=?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,ID_Invoice);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Invoice invoice = new Invoice(rs.getString(2));
				Product pr = new Product(rs.getString(3));
				InvoiceDetail invoiceDetail = new InvoiceDetail();
				invoiceDetail.setID_InvoiceDetail(rs.getString(1));
				invoiceDetail.setInvoice(invoice);
				invoiceDetail.setProduct(pr);
				invoiceDetail.setQuantity(rs.getInt(4));
				invoiceDetail.setPrice(rs.getInt(5));
				invoiceDetail.setSale(rs.getInt(6));
				invoiceDetail.setTotal(rs.getInt(7));
				
				arr.add(invoiceDetail);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return arr;
		
	}
	


	@Override
	public boolean insert(InvoiceDetail invoicedetail) {
		try {
			String query = "INSERT INTO Invoice_Detail VALUES(?,?,?,?,?,?,?)";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, invoicedetail.getID_InvoiceDetail());
			ps.setString(2, invoicedetail.getInvoice().getID_Invoice());
			ps.setString(3, invoicedetail.getProduct().getId_product());
			ps.setInt(4, invoicedetail.getQuantity());
			ps.setInt(5, invoicedetail.getPrice());
			ps.setInt(6, invoicedetail.getSale());
			ps.setInt(7, invoicedetail.getTotal());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public static void main(String[] args) {
		Invoice invoice = new Invoice("INV1618643574981");
		Product pr = new Product("116");
		InvoiceDetail inv = new InvoiceDetail("inv12122ssas1",invoice,pr,4,5,6,7);
		InvoiceDetailDao dao = new InvoiceDetailDao_Impl();
		System.out.println(dao.insert(inv));
		System.out.println("hello");
		
		ArrayList<InvoiceDetail> arr = new ArrayList<InvoiceDetail>();
		arr = dao.GetList_InvoiceDetail("INV1618602267482");
		for(InvoiceDetail a: arr) {
			System.out.println("HellO: " + a.getID_InvoiceDetail());
		}
		
		
	}





}
