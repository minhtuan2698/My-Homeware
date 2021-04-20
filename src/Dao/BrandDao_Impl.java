package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DBConnection;
import Model.Brand;

public class BrandDao_Impl implements BrandDao {

	@Override
	public ArrayList<Brand> getlist_ParentBrand() {
		ArrayList<Brand> arr = new ArrayList<Brand>();
		String query = "SELECT * FROM BRAND WHERE Parent_Brand = 'NULL' ";
		try {
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Brand brand = new Brand();
				brand.setId_brand(rs.getString(1));
				brand.setName_brand(rs.getString(2));
				brand.setCountry(rs.getString(3));
				brand.setCountry(rs.getString(4	));
				arr.add(brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return arr;
	}

	@Override
	public ArrayList<Brand> getlist_ChildBrand(String id_brand) {
		ArrayList<Brand> arr = new ArrayList<Brand>();
		String query = "SELECT * FROM BRAND WHERE Parent_Brand=?";
		try {
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Brand brand = new Brand();
				brand.setId_brand(rs.getString(1));
				brand.setName_brand(rs.getString(2));
				brand.setCountry(rs.getString(3));
				brand.setParent_brand(rs.getString(4));
				arr.add(brand);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		BrandDao_Impl dao = new BrandDao_Impl();
		for(Brand brand_parent : dao.getlist_ParentBrand()) {
			for(Brand brand_child : dao.getlist_ChildBrand(brand_parent.getId_brand())){
				System.out.println(brand_child.getName_brand());
			}
			
		}
	}

	@Override
	public Brand GetName_Brand(String id_brand) {
		Brand brand = new Brand();
		try {
			String query = "SELECT * FROM Brand WHERE ID_Brand = ?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				brand.setId_brand(rs.getString(1));
				brand.setName_brand(rs.getString(2));
				brand.setCountry(rs.getString(3));
				brand.setParent_brand(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brand;
	}

}
