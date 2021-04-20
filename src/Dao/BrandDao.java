package Dao;

import java.util.ArrayList;

import Model.Brand;
import Model.Category;

public interface BrandDao {

	public ArrayList<Brand> getlist_ParentBrand();
	public ArrayList<Brand> getlist_ChildBrand(String id_brand);
	public Brand GetName_Brand(String id_brand);
}
