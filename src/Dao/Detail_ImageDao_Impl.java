package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import Model.Detail_Image;
import Model.Product;

public class Detail_ImageDao_Impl implements Detail_ImageDao{

	@Override
	public Detail_Image GetImage(int id_product) {
		Detail_Image detail_image = new Detail_Image();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM ImageDetail WHERE ID_Product=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_product);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product pr = new Product(rs.getString(3),null,"","",0,"",0,0,null,null);
				detail_image.setId_Detail_Image(rs.getInt(1));
				detail_image.setProduct(pr);
				detail_image.setImage1(rs.getString(2));
				detail_image.setImage2(rs.getString(4));
				detail_image.setImage3(rs.getString(5));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detail_image;
	}
	
	public static void main(String[] args) {
		Detail_ImageDao dao = new Detail_ImageDao_Impl();
		Detail_Image model = dao.GetImage(122);
		System.out.println(model.getId_Detail_Image());
	}
	

}
