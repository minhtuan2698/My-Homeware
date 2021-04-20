package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Connection.DBConnection;
import Model.Brand;
import Model.Category;
import Model.Product;
import Model.Season;

public class ProductDao_Impl implements ProductDao {

	@Override
	public ArrayList<Product> GetAllProduct() {

		ArrayList<Product> arr = new ArrayList<Product>();
		String query = "SELECT * FROM Product";
		try {
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);

				arr.add(pr);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arr;
	}

	@Override
	public int GetTotalProduct() {
		try {
			String query = "SELECT COUNT(*) FROM Product";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int GetTotalProduct_Hot() {
		try {
			String query = " SELECT COUNT(*) FROM (SELECT i.ID_Product\r\n" + "	FROM Product p\r\n"
					+ "					INNER JOIN InvoiceDetail i on p.ID_Product = i.ID_Product \r\n"
					+ "					 group by i.ID_Product,p.Name_Product, p.ID_Category, p.Image,  p.ID_Brand, p.Quantity, p.Describe,p.Price,p.Sale, p.ID_Brand,p.Warranty_Period \r\n"
					+ "					 having Sum(i.Quantity)>=2) t";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int GetTotalProduct_BySeason(int id_season) {
		try {
			String query = "SELECT COUNT(*) FROM Product WHERE ID_Season=?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_season);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int GetTotalProduct_BySeason_Hot(int id_season) {
		try {
			String query = " SELECT COUNT(*) FROM (SELECT i.ID_Product\r\n" + "	FROM Product p\r\n"
					+ "					INNER JOIN InvoiceDetail i on p.ID_Product = i.ID_Product where p.ID_Season = ?\r\n"
					+ "					 group by i.ID_Product,p.Name_Product, p.ID_Category, p.Image,  p.ID_Brand, p.Quantity, p.Describe,p.Price,p.Sale, p.ID_Brand,p.Warranty_Period \r\n"
					+ "					 having Sum(i.Quantity)>=2) t";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_season);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public ArrayList<Product> GetListProduct_ByCategoty(String id_category) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {

			String query = "SELECT * FROM Product WHERE ID_Category = ?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_category);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);
				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> GetListProduct_ByBrand(String id_brand) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			String query = "SELECT * FROM Product WHERE ID_Brand = ? ";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);
				arr.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct(int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);
				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct_ByCategory(String id_category, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product WHERE ID_Category = ? ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_category);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");
				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);

				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public int GetTotalProduct_ByCategory(String id_category) {

		try {
			String query = "SELECT COUNT(*) FROM Product WHERE ID_Category=?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_category);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	@Override
	public int GetTotalProduct_ByBrand(String id_brand) {

		try {
			String query = "SELECT COUNT(*) FROM Product WHERE ID_Brand=?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public ArrayList<Product> PagingProduct_ByBrand(String id_brand, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product WHERE ID_Brand = ? ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");
				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);

				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> GetListProduct_ByPromotion() {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			Date d = new Date();
			SimpleDateFormat sdm = new SimpleDateFormat("yyyy/MM/dd");
			String date = sdm.format(d);
			String query = "SELECT P.ID_Product,P.ID_Category, P.Name_Product, P.Image, P.Quantity, P.Describe, P.Price, P.Sale, P.ID_Brand, P.Warranty_Period, S.ID_Season, S.Name_Season FROM Product P INNER JOIN Season S on P.Id_Season = S.ID_Season WHERE DateStart >= ? AND DateEnd <= ? GROUP BY P.ID_Product,P.ID_Category, P.Name_Product, P.Image, P.Quantity, P.Describe, P.Price, P.Sale, P.ID_Brand, P.Warranty_Period, S.ID_Season, S.Name_Season";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, date);
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");
				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);

				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct_BySeason(int id_season, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product WHERE ID_Season = ? ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_season);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");
				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);

				arr.add(pr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public int GetTotalProduct_ByCategory_Sale(String id_category) {
		try {
			String query = "SELECT COUNT(*) FROM Product WHERE Sale>0 AND ID_Category=?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_category);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int GetTotalProduct_ByBrand_Sale(String id_brand) {
		try {
			String query = "SELECT COUNT(*) FROM Product WHERE Sale>0 AND ID_Brand=?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int GetTotalProduct_BySeason_Sale(int id_season) {
		try {
			String query = "SELECT COUNT(*) FROM Product WHERE Sale>0 AND ID_Season=?";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_season);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public ArrayList<Product> PagingProduct_Sale(int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product WHERE Sale>0 ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);
				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct_ByCategory_Sale(String id_category, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product WHERE Sale>0 AND ID_Category = ? ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_category);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");
				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);

				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct_ByBrand_Sale(String id_brand, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product WHERE Sale>0 AND ID_Brand = ? ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");
				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);

				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct_BySeason_Sale(int id_season, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product WHERE Sale>0 AND ID_Season = ? ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_season);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");
				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);

				arr.add(pr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public int GetTotalProduct_Sale() {
		try {
			String query = "SELECT COUNT(*) FROM Product WHERE Sale>0";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int GetTotalProduct_ByCategory_Hot(String id_category) {
		try {
			String query = " SELECT COUNT(*) FROM (SELECT i.ID_Product\r\n" + "	FROM Product p\r\n"
					+ "					INNER JOIN InvoiceDetail i on p.ID_Product = i.ID_Product where p.ID_Category = ?\r\n"
					+ "					 group by i.ID_Product,p.Name_Product, p.ID_Category, p.Image,  p.ID_Brand, p.Quantity, p.Describe,p.Price,p.Sale, p.ID_Brand,p.Warranty_Period \r\n"
					+ "					 having Sum(i.Quantity)>=2) t";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_category);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int GetTotalProduct_ByBrand_Hot(String id_brand) {
		try {
			String query = " SELECT COUNT(*) FROM (SELECT i.ID_Product\r\n" + "					FROM Product p\r\n"
					+ "					INNER JOIN InvoiceDetail i on p.ID_Product = i.ID_Product where p.ID_Brand = ?\r\n"
					+ "					 group by i.ID_Product,p.Name_Product, p.ID_Category, p.Image,  p.ID_Brand, p.Quantity, p.Describe,p.Price,p.Sale, p.ID_Brand,p.Warranty_Period \r\n"
					+ "					 having Sum(i.Quantity)>=2) t";
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public ArrayList<Product> PagingProduct_Hot(int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT i.ID_Product,p.Name_Product, p.ID_Category, p.ID_Brand,p.ID_Season,  p.Image,p.Quantity, p.Describe,p.Price,p.Sale\r\n"
					+ "										FROM Product p\r\n"
					+ "										INNER JOIN InvoiceDetail i on p.ID_Product = i.ID_Product \r\n"
					+ "										 group by i.ID_Product,p.Name_Product, p.ID_Category, p.ID_Brand,p.ID_Season,  p.Image,p.Quantity, p.Describe,p.Price,p.Sale\r\n"
					+ "							 having Sum(i.Quantity)>=2\r\n"
					+ "							 ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();

				Category cate = new Category(rs.getString(3), "", "");
				Brand brand = new Brand(rs.getString(4), "", "", "");
				Season season = new Season(rs.getInt(5), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(2));
				pr.setImage(rs.getString(6));
				pr.setQuantity(rs.getInt(7));
				pr.setDescribe(rs.getString(8));
				pr.setPrice(rs.getInt(9));
				pr.setSale(rs.getInt(10));
				pr.setBrand(brand);
				pr.setSeason(season);
				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct_ByCategory_Hot(String id_category, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = " SELECT i.ID_Product,p.Name_Product, p.ID_Category, p.ID_Brand,p.ID_Season,  p.Image,p.Quantity, p.Describe,p.Price,p.Sale\r\n"
					+ "										FROM Product p\r\n"
					+ "										INNER JOIN InvoiceDetail i on p.ID_Product = i.ID_Product WHERE ID_Category=?\r\n"
					+ "										 group by i.ID_Product,p.Name_Product, p.ID_Category, p.ID_Brand,p.ID_Season,  p.Image,p.Quantity, p.Describe,p.Price,p.Sale\r\n"
					+ "							 having Sum(i.Quantity)>=2\r\n"
					+ "							 ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_category);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();

				Category cate = new Category(rs.getString(3), "", "");
				Brand brand = new Brand(rs.getString(4), "", "", "");
				Season season = new Season(rs.getInt(5), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(2));
				pr.setImage(rs.getString(6));
				pr.setQuantity(rs.getInt(7));
				pr.setDescribe(rs.getString(8));
				pr.setPrice(rs.getInt(9));
				pr.setSale(rs.getInt(10));
				pr.setBrand(brand);
				pr.setSeason(season);
				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct_ByBrand_Hot(String id_brand, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = " SELECT i.ID_Product,p.Name_Product, p.ID_Category, p.ID_Brand,p.ID_Season,  p.Image,p.Quantity, p.Describe,p.Price,p.Sale\r\n"
					+ "										FROM Product p\r\n"
					+ "										INNER JOIN InvoiceDetail i on p.ID_Product = i.ID_Product WHERE ID_Brand=?\r\n"
					+ "										 group by i.ID_Product,p.Name_Product, p.ID_Category, p.ID_Brand,p.ID_Season,  p.Image,p.Quantity, p.Describe,p.Price,p.Sale\r\n"
					+ "							 having Sum(i.Quantity)>=2\r\n"
					+ "							 ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id_brand);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();

				Category cate = new Category(rs.getString(3), "", "");
				Brand brand = new Brand(rs.getString(4), "", "", "");
				Season season = new Season(rs.getInt(5), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(2));
				pr.setImage(rs.getString(6));
				pr.setQuantity(rs.getInt(7));
				pr.setDescribe(rs.getString(8));
				pr.setPrice(rs.getInt(9));
				pr.setSale(rs.getInt(10));
				pr.setBrand(brand);
				pr.setSeason(season);
				arr.add(pr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<Product> PagingProduct_BySeason_Hot(int id_season, int index) {
		ArrayList<Product> arr = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.getconnection();
			String query = " SELECT i.ID_Product,p.Name_Product, p.ID_Category, p.ID_Brand,p.ID_Season,  p.Image,p.Quantity, p.Describe,p.Price,p.Sale\r\n"
					+ "										FROM Product p\r\n"
					+ "										INNER JOIN InvoiceDetail i on p.ID_Product = i.ID_Product WHERE ID_Season=?\r\n"
					+ "										 group by i.ID_Product,p.Name_Product, p.ID_Category, p.ID_Brand,p.ID_Season,  p.Image,p.Quantity, p.Describe,p.Price,p.Sale\r\n"
					+ "							 having Sum(i.Quantity)>=2\r\n"
					+ "							 ORDER BY ID_Product OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_season);
			ps.setInt(2, (index - 1) * 8);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pr = new Product();

				Category cate = new Category(rs.getString(3), "", "");
				Brand brand = new Brand(rs.getString(4), "", "", "");
				Season season = new Season(rs.getInt(5), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(2));
				pr.setImage(rs.getString(6));
				pr.setQuantity(rs.getInt(7));
				pr.setDescribe(rs.getString(8));
				pr.setPrice(rs.getInt(9));
				pr.setSale(rs.getInt(10));
				pr.setBrand(brand);
				pr.setSeason(season);
				arr.add(pr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static void main(String[] args) {
		ProductDao dao = new ProductDao_Impl();
		Product pr = dao.GetProduct(101);
		System.out.print(pr.getName_product());
	}

	@Override
	public Product GetProduct(int id_product) {
		Product pr = new Product();
		try {
			Connection conn = DBConnection.getconnection();
			String query = "SELECT * FROM Product WHERE ID_Product = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id_product);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Category cate = new Category(rs.getString(2), "", "");
				Brand brand = new Brand(rs.getString(9), "", "", "");
				Season season = new Season(rs.getInt(11), "", "", "");

				pr.setId_product(rs.getString(1));
				pr.setCategory(cate);
				pr.setName_product(rs.getString(3));
				pr.setImage(rs.getString(4));
				pr.setQuantity(rs.getInt(5));
				pr.setDescribe(rs.getString(6));
				pr.setPrice(rs.getInt(7));
				pr.setSale(rs.getInt(8));
				pr.setBrand(brand);
				pr.setSeason(season);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pr;
	}

	@Override
	public boolean UpdateQuantity(int ID_Product, int Quantity) {
		try {
			Connection conn = DBConnection.getconnection();
			String query = "UPDATE Product SET Quantity=Quantity + ? WHERE ID_Product = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Quantity);
			ps.setInt(2, ID_Product);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}


}
