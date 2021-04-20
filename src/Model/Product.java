package Model;

public class Product {
	private String id_product;
	private Category category;
	private String name_product;
	private String image;
	private int quantity;
	private String describe;
	private int price;
	private int sale;
	private Brand brand;
	private Season season;
	public Product() {
		super();
	}
	public Product(String id_product, Category category, String name_product, String image, int quantity,
			String describe, int price, int sale, Brand brand, Season season) {
		super();
		this.id_product = id_product;
		this.category = category;
		this.name_product = name_product;
		this.image = image;
		this.quantity = quantity;
		this.describe = describe;
		this.price = price;
		this.sale = sale;
		this.brand = brand;
		this.season = season;
	}
	
	public Product(String id_product, String name_product,
		 int price, int sale) {
		super();
		this.id_product = id_product;
		this.name_product = name_product;
		this.price = price;
		this.sale = sale;
		
	}
	public Product(String id_product) {
			super();
			this.id_product = id_product;
	
	
		}
	
	
	
	
	
	public String getId_product() {
		return id_product;
	}
	public void setId_product(String id_product) {
		this.id_product = id_product;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName_product() {
		return name_product;
	}
	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	
	
	
	
	
	

}
