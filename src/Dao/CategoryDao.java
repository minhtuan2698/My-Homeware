package Dao;

import java.util.ArrayList;

import Model.Category;

public interface CategoryDao {
	
	public ArrayList<Category> Getlist_ParentCategory();
		
	public ArrayList<Category> GetList_ChildCategory(String id_Category);
	
	public Category GetName_CateGory(String id_Category);

}
