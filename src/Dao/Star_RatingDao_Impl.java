package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Connection.DBConnection;
import Model.Account;
import Model.InvoiceDetail;
import Model.Product;
import Model.Star_Rating;

public class Star_RatingDao_Impl implements Star_RatingDao {

	@Override
	public boolean insert(Star_Rating rate) {
		try {
			
			String query = "INSERT INTO Star_Rating VALUES(?,?,?,?,?,?)";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, rate.getID_Rate() );
			ps.setString(2, rate.getProduct().getId_product());
			ps.setString(3, rate.getAccount().getId_account());
			ps.setFloat(4, rate.getStar());
			ps.setString(5, rate.getComment());
			ps.setString(6, rate.getInvoiceDetail().getID_InvoiceDetail());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}


	
	public static void main(String[] args) {
		Account acc = new Account("KH1618636511216");
		Product pr = new Product("101");
		
		Star_RatingDao dao = new Star_RatingDao_Impl();
		
		
		ArrayList<Star_Rating> arr = dao.GetListRate(101);
		for(Star_Rating a : arr) {
			System.out.println(a.getID_Rate());
		}
	}

	@Override
	public int Count_Full(int ID_Product) {
		try {
			String query = "SELECT COUNT(Star) From Star_Rating WHERE ID_Product = ?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID_Product);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int Sum_Full(int ID_Product) {
		try {
			String query = "SELECT Sum(Star) From Star_Rating  WHERE ID_Product = ?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID_Product);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int Count_Distinct(int ID_Product) {
		try {
			String query = "SELECT COUNT(DISTINCT ID_Account) From Star_Rating  WHERE ID_Product = ?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID_Product);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int Count_Star(int star,int ID_Product) {
		try {
			String query = "SELECT COUNT(Star) From Star_Rating WHERE Star=? AND ID_Product = ?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, star);
			ps.setInt(2, ID_Product);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public float Avg_Full(int ID_Product) {
		try {
			String query = "SELECT AVG(Star) From Star_Rating  WHERE ID_Product = ?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID_Product);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getFloat(1);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}



	@Override
	public ArrayList<Star_Rating> GetListRate(int ID_Product) {
		ArrayList<Star_Rating> arr = new ArrayList<Star_Rating>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Star_Rating WHERE ID_Product=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID_Product);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product pr = new Product(rs.getString(2));
				Account acc = new Account(rs.getString(3));
				InvoiceDetail inv = new InvoiceDetail(rs.getString(6));
				Star_Rating rate = new Star_Rating();
				rate.setID_Rate(rs.getString(1));
				rate.setProduct(pr);
				rate.setAccount(acc);
				rate.setStar(rs.getFloat(4));
				rate.setComment(rs.getString(5));
				rate.setInvoiceDetail(inv);
				arr.add(rate);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}



	@Override
	public boolean Checkrate(String ID_InvoiceDetail) {
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Star_Rating WHERE ID_InvoiceDetail=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ID_InvoiceDetail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	

}
