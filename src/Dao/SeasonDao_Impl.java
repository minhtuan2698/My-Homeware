package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Connection.DBConnection;
import Model.Season;

public class SeasonDao_Impl implements SeasonDao {

	@Override
	public Season GetNameSeason(int id_season) {
		Season ss = new Season();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Season WHERE ID_Season= ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_season);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ss.setID_Season(rs.getInt(1));
				ss.setName_Season(rs.getString(2));
				ss.setDateStart(rs.getString(3));
				ss.setDateEnd(rs.getString(4));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ss;
	}
	
	public static void main(String[] args) {
		SeasonDao ssdao = new SeasonDao_Impl();
		ArrayList<Season> arr = ssdao.GetSeason();
		
		
		for(Season ss: arr) {
			System.out.print(ss.getID_Season()+"------"+ss.getName_Season());
		}
		
		
	}

	@Override
	public ArrayList<Season> GetSeason() {
		ArrayList<Season> arr = new ArrayList<Season>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Season";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Season ss = new Season();
				ss.setID_Season(rs.getInt(1));
				ss.setName_Season(rs.getString(2));
				ss.setDateStart(rs.getString(3));
				ss.setDateEnd(rs.getString(4));
				arr.add(ss);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	
	


	

}
