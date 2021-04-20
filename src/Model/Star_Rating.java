package Model;

public class Star_Rating {

	private String ID_Rate;
	private Product product;
	private Account account;
	private float star;
	private String comment;
	private InvoiceDetail invoiceDetail;

	public Star_Rating() {
		super();
	}
	public Star_Rating(String iD_Rate, Product product, Account account, float star, String comment,
			InvoiceDetail invoiceDetail) {
		super();
		ID_Rate = iD_Rate;
		this.product = product;
		this.account = account;
		this.star = star;
		this.comment = comment;
		this.invoiceDetail = invoiceDetail;
	}
	public String getID_Rate() {
		return ID_Rate;
	}
	public void setID_Rate(String iD_Rate) {
		ID_Rate = iD_Rate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public InvoiceDetail getInvoiceDetail() {
		return invoiceDetail;
	}
	public void setInvoiceDetail(InvoiceDetail invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}
	
	
	
	
	
	
}
