package Model;

import java.sql.Timestamp;

public class Invoice {
	private String ID_Invoice;
	private Account account;
	private String Shipping_Address;
	private String Payment_Method;
	private String Time_Dathang;
	private int Status;
	private int Total;
	private String Time_Giaohang_Dukien;
	private String Time_Giaohang;
	public String getID_Invoice() {
		return ID_Invoice;
	}
	public void setID_Invoice(String iD_Invoice) {
		ID_Invoice = iD_Invoice;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getShipping_Address() {
		return Shipping_Address;
	}
	public void setShipping_Address(String shipping_Address) {
		Shipping_Address = shipping_Address;
	}
	public String getPayment_Method() {
		return Payment_Method;
	}
	public void setPayment_Method(String payment_Method) {
		Payment_Method = payment_Method;
	}
	public String getTime_Dathang() {
		return Time_Dathang;
	}
	public void setTime_Dathang(String time_Dathang) {
		Time_Dathang = time_Dathang;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public String getTime_Giaohang_Dukien() {
		return Time_Giaohang_Dukien;
	}
	public void setTime_Giaohang_Dukien(String time_Giaohang_Dukien) {
		Time_Giaohang_Dukien = time_Giaohang_Dukien;
	}
	public String getTime_Giaohang() {
		return Time_Giaohang;
	}
	public void setTime_Giaohang(String time_Giaohang) {
		Time_Giaohang = time_Giaohang;
	}
	public Invoice(String iD_Invoice, Account account, String shipping_Address, String payment_Method,
			String time_Dathang, int status, int total, String time_Giaohang_Dukien, String time_Giaohang) {
		super();
		ID_Invoice = iD_Invoice;
		this.account = account;
		Shipping_Address = shipping_Address;
		Payment_Method = payment_Method;
		Time_Dathang = time_Dathang;
		Status = status;
		Total = total;
		Time_Giaohang_Dukien = time_Giaohang_Dukien;
		Time_Giaohang = time_Giaohang;
	}
	
	public Invoice(String iD_Invoice
			) {
		super();
		this.ID_Invoice = iD_Invoice;
		
	}
	
	public Invoice() {
		super();
	}
	
	
	
	

}
