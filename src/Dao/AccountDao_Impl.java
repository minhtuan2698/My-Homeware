package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import Model.Account;

public class AccountDao_Impl implements AccountDao {

	@Override
	public Account CheckLogin(String username, String password) {
		Account acc = new Account();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Account WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				acc.setId_account(rs.getString(1));
				acc.setUsername(rs.getString(2));
				acc.setPassword(rs.getString(3));
				acc.setEmail(rs.getString(4));
				acc.setFullname(rs.getString(5));
				acc.setAddress(rs.getString(6));
				acc.setPhone(rs.getString(7));
				acc.setAccess(rs.getInt(8));
				acc.setStatus(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	

	@Override
	public boolean Check(String username, String password) {
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Account WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean InsertAcount(Account acc) {
		try {
			String query = "INSERT INTO Account VALUES(?,?,?,?,?,?,?,?,?)";
			String id = "KH"+acc.getId_account();
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, acc.getId_account());
			ps.setString(2, acc.getUsername());
			ps.setString(3, acc.getPassword());
			ps.setString(4, acc.getEmail());
			ps.setString(5, acc.getFullname());
			ps.setString(6, acc.getAddress());
			ps.setString(7, acc.getPhone());
			ps.setInt(8, acc.getAccess());
			ps.setInt(9, acc.getStatus());
			ps.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	

	public static void main(String[] args) {
		AccountDao_Impl dao = new AccountDao_Impl();
		Account acc = new Account("KH12xxxxxxx2343","2","3","4","5","6","7",5,6);
		
		
		System.out.print(dao.CheckPhone("0386300021"));
		
	
	}


	@Override
	public boolean CheckPhone(String phone) {
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Account WHERE SDT=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean CheckEmail(String email) {
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Account WHERE Email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean CheckUsername(String username) {
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Account WHERE Username=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean CheckUserEmail(String username, String email) {
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Account WHERE Username=? AND Email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean EditPassword(String username, String password) {
		try {
			Connection conn = DBConnection.getconnection();
			String query = "UPDATE Account SET Password=? WHERE Username=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,password);
			ps.setString(2, username);
			ps.executeUpdate();
			return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Account GetAccount(String ID_Account) {
		Account acc = new Account();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Account WHERE ID_Account=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ID_Account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				acc.setId_account(rs.getString(1));
				acc.setUsername(rs.getString(2));
				acc.setPassword(rs.getString(3));
				acc.setEmail(rs.getString(4));
				acc.setFullname(rs.getString(5));
				acc.setAddress(rs.getString(6));
				acc.setPhone(rs.getString(7));
				acc.setAccess(rs.getInt(8));
				acc.setStatus(rs.getInt(9));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return acc;
	}
}
