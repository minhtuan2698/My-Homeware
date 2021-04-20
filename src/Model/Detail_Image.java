package Model;

public class Detail_Image {
	
	private int id_Detail_Image;
	private Product product;
	private String image1;
	private String image2;
	private String image3;
	public Detail_Image() {
		super();
	}
	public Detail_Image(int id_Detail_Image, Product product, String image1, String image2, String image3) {
		super();
		this.id_Detail_Image = id_Detail_Image;
		this.product = product;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
	}
	public int getId_Detail_Image() {
		return id_Detail_Image;
	}
	public void setId_Detail_Image(int id_Detail_Image) {
		this.id_Detail_Image = id_Detail_Image;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	
	

}
