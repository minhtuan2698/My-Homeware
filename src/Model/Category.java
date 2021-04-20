package Model;

public class Category {
	private String id_category;
	private String name_category;
	private String parent_category;
	public Category() {
		super();
	}
	public Category(String id_category, String name_category, String parent_category) {
		super();
		this.id_category = id_category;
		this.name_category = name_category;
		this.parent_category = parent_category;
	}
	public String getId_category() {
		return id_category;
	}
	public void setId_category(String id_category) {
		this.id_category = id_category;
	}
	public String getName_category() {
		return name_category;
	}
	public void setName_category(String name_category) {
		this.name_category = name_category;
	}
	public String getParent_category() {
		return parent_category;
	}
	public void setParent_category(String parent_category) {
		this.parent_category = parent_category;
	}
	
	

}
