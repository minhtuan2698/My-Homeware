package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DBConnection;
import Model.Category;

public class CategoryDao_Impl implements CategoryDao {

	@Override
	public ArrayList<Category> Getlist_ParentCategory() {
		ArrayList<Category> arr = new ArrayList<Category>();
		String query = "SELECT * FROM Category WHERE Parent_Category='NULL'";
		try {
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setId_category(rs.getString(1));
				category.setName_category(rs.getString(2));
				category.setParent_category(rs.getString(3));
				arr.add(category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr;
	}

	@Override
	public ArrayList<Category> GetList_ChildCategory(String id_Category) {
		ArrayList<Category> arr = new ArrayList<Category>();
		String query = "SELECT * FROM Category WHERE Parent_Category=?";
		try {
			Connection con = DBConnection.getconnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id_Category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setId_category(rs.getString(1));
				category.setName_category(rs.getString(2));
				category.setParent_category(rs.getString(3));
				arr.add(category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr;
	}
	


	@Override
	public Category GetName_CateGory(String id_Category) {
		Category cate = new Category();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Category WHERE ID_Category = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_Category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cate.setId_category(rs.getString(1));
				cate.setName_category(rs.getString(2));
				cate.setParent_category(rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cate;
	}
	
	public static void main(String[] args) {
		CategoryDao dao = new CategoryDao_Impl();
		Category cate = dao.GetName_CateGory("DCNB");
		System.out.print(cate.getName_category());
	}
	

}
