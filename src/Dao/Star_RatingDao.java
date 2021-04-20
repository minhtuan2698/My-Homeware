package Dao;

import java.util.ArrayList;

import Model.Star_Rating;

public interface Star_RatingDao {
	
	public boolean insert(Star_Rating rate);
	public ArrayList<Star_Rating> GetListRate(int ID_Product);
	public int Count_Full(int ID_Product);
	public int Sum_Full(int ID_Product);
	public float Avg_Full(int ID_Product);
	public int Count_Distinct(int ID_Product);
	public int Count_Star(int star,int ID_Product);
	
	public boolean Checkrate(String ID_InvoiceDetail);

}
