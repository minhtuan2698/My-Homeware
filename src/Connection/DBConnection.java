package Connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-HHKGK1R\\SQLEXPRESS01;databasename=tshomeware";
			String user = "admin";
			String pass = "admin";
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Kết nối DB thành công !");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Kết nối DB thất bại !");
		}
		return conn;
	}
	
	public static void main(String[] args) {
		DBConnection connect = new DBConnection();
		connect.getconnection();
	}
}
