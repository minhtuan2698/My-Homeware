package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Connection.DBConnection;
import Model.Account;
import Model.Invoice;

public class InvoiceDao_Impl implements InvoiceDao {

	@Override
	public boolean InsertInvoice(Invoice invoice) {
		try {
			
			
			Connection conn = DBConnection.getconnection();
			String query = "INSERT INTO Invoice(ID_Invoice,ID_Account,Shipping_Address,Payment_Methods,Purchase_Date,Status_Order,Total_Invoice,Time_Limit) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, invoice.getID_Invoice());
			ps.setString(2, invoice.getAccount().getId_account());
			ps.setString(3, invoice.getShipping_Address());
			ps.setString(4, invoice.getPayment_Method());
			ps.setString(5, invoice.getTime_Dathang());
			ps.setInt(6, invoice.getStatus());
			ps.setInt(7, invoice.getTotal());
			ps.setString(8, invoice.getTime_Giaohang_Dukien());
			ps.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public static void main(String[] args) {
		SimpleDateFormat formatDay = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat afterFormat = new SimpleDateFormat("E, dd/MM/yyyy");
		Date afterCreatedDate = new Date();
		try {
			afterCreatedDate = (Date)afterFormat.parse("Tue, 16/04/2021");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String Time_Limit1 = formatDay.format(afterCreatedDate);
		
		InvoiceDao dao = new InvoiceDao_Impl();
	
		ArrayList<Invoice> arr = new ArrayList<Invoice>();
		arr = dao.GetListInvoice2("KH102");
		for(Invoice i:arr) {
			System.out.println(i.getID_Invoice());
			
		}
		
		
	}

	@Override
	public ArrayList<Invoice> GetListInvoice1(String Id_Account) {
		ArrayList<Invoice> arr = new ArrayList<Invoice>();
		try {
			
			String query = "SELECT * FROM Invoice WHERE ID_Account = ? AND (Status_Order=1 OR Status_Order=2)";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);	
			ps.setString(1, Id_Account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account acc = new Account(rs.getString(2),null,null,null,null,null,null,0,0);
				Invoice invoice = new Invoice();
				invoice.setID_Invoice(rs.getString(1));
				invoice.setAccount(acc);
				invoice.setShipping_Address(rs.getString(3));
				invoice.setPayment_Method(rs.getString(4));
				invoice.setTime_Dathang(rs.getString(5));
				invoice.setStatus(rs.getInt(6));
				invoice.setTotal(rs.getInt(7));
				invoice.setTime_Giaohang_Dukien(rs.getString(10));
				arr.add(invoice);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return arr;
	}

	@Override
	public ArrayList<Invoice> GetListInvoice2(String Id_Account) {
		ArrayList<Invoice> arr = new ArrayList<Invoice>();
		try {
			
			String query = "SELECT * FROM Invoice WHERE ID_Account = ? AND (Status_Order=3 OR Status_Order=4)";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);	
			ps.setString(1, Id_Account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account acc = new Account(rs.getString(2),null,null,null,null,null,null,0,0);
				Invoice invoice = new Invoice();
				invoice.setID_Invoice(rs.getString(1));
				invoice.setAccount(acc);
				invoice.setShipping_Address(rs.getString(3));
				invoice.setPayment_Method(rs.getString(4));
				invoice.setTime_Dathang(rs.getString(5));
				invoice.setStatus(rs.getInt(6));
				invoice.setTotal(rs.getInt(7));
				invoice.setTime_Giaohang(rs.getString(11));
				arr.add(invoice);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return arr;
	}

	@Override
	public boolean UpdateInvoice(String Id_Invoice, int Status) {
		try {
			String query = "UPDATE Invoice SET Status_Order=? WHERE ID_Invoice=?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Status);
			ps.setString(2, Id_Invoice);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	

}
