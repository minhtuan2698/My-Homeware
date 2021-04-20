package Dao;

import java.util.ArrayList;

import Model.Product;

public interface ProductDao {
	public ArrayList<Product> GetAllProduct();
	public Product GetProduct(int id_product);
	
	
	public int GetTotalProduct();
	public int GetTotalProduct_Sale();
	public int GetTotalProduct_Hot();
	
	public int GetTotalProduct_ByCategory(String id_category); 
	public int GetTotalProduct_ByCategory_Sale(String id_category); 
	public int GetTotalProduct_ByCategory_Hot(String id_category); 
	
	public int GetTotalProduct_ByBrand(String id_brand); 
	public int GetTotalProduct_ByBrand_Sale(String id_brand); 
	public int GetTotalProduct_ByBrand_Hot(String id_brand); 
	
	public int GetTotalProduct_BySeason(int id_season);
	public int GetTotalProduct_BySeason_Sale(int id_season); 
	public int GetTotalProduct_BySeason_Hot(int id_season);
	
	 
	
	
	
	
	
	public ArrayList<Product> GetListProduct_ByCategoty(String id_category);
	public ArrayList<Product> GetListProduct_ByBrand(String id_brand);
	
	
	
	
	public ArrayList<Product> PagingProduct(int index);
	public ArrayList<Product> PagingProduct_Sale(int index);
	public ArrayList<Product> PagingProduct_Hot(int index);
	
	public ArrayList<Product> PagingProduct_ByCategory(String id_category,int index);
	public ArrayList<Product> PagingProduct_ByCategory_Sale(String id_category,int index);
	public ArrayList<Product> PagingProduct_ByCategory_Hot(String id_category,int index);
	
	public ArrayList<Product> PagingProduct_ByBrand(String id_brand,int index);
	public ArrayList<Product> PagingProduct_ByBrand_Sale(String id_brand,int index);
	public ArrayList<Product> PagingProduct_ByBrand_Hot(String id_brand,int index);
	
	public ArrayList<Product> PagingProduct_BySeason(int id_season, int index);
	public ArrayList<Product> PagingProduct_BySeason_Sale(int id_season, int index);
	public ArrayList<Product> PagingProduct_BySeason_Hot(int id_season, int index);
	
	public ArrayList<Product> GetListProduct_ByPromotion();
	
	
	public boolean UpdateQuantity(int ID_Product, int Quantity);
	
		
	
			
			
			
			
			
}
