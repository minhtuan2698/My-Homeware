package Model;

public class InvoiceDetail {
	private String ID_InvoiceDetail;
	private Invoice invoice;
	private Product product;
	private int Quantity;
	private int Price;
	private int Sale;
	private int Total;
	public InvoiceDetail() {
		super();
	}
	public InvoiceDetail(String iD_InvoiceDetail, Invoice invoice, Product product, int quantity, int price, int sale,
			int total) {
		super();
		ID_InvoiceDetail = iD_InvoiceDetail;
		this.invoice = invoice;
		this.product = product;
		Quantity = quantity;
		Price = price;
		Sale = sale;
		Total = total;
	}
	public String getID_InvoiceDetail() {
		return ID_InvoiceDetail;
	}
	public void setID_InvoiceDetail(String iD_InvoiceDetail) {
		ID_InvoiceDetail = iD_InvoiceDetail;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getSale() {
		return Sale;
	}
	public void setSale(int sale) {
		Sale = sale;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public InvoiceDetail(String iD_InvoiceDetail) {
		super();
		ID_InvoiceDetail = iD_InvoiceDetail;
	}
	
	
	
	
	

}
