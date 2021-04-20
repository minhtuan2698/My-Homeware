package Model;

public class Brand {
	private String id_brand;
	private String name_brand;
	private String country;
	private String parent_brand;
	public Brand() {
		super();
	}
	public Brand(String id_brand, String name_brand, String country, String parent_brand) {
		super();
		this.id_brand = id_brand;
		this.name_brand = name_brand;
		this.country = country;
		this.parent_brand = parent_brand;
	}
	public String getId_brand() {
		return id_brand;
	}
	public void setId_brand(String id_brand) {
		this.id_brand = id_brand;
	}
	public String getName_brand() {
		return name_brand;
	}
	public void setName_brand(String name_brand) {
		this.name_brand = name_brand;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getParent_brand() {
		return parent_brand;
	}
	public void setParent_brand(String parent_brand) {
		this.parent_brand = parent_brand;
	}
	
	

	
}
