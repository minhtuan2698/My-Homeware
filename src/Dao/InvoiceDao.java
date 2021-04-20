package Dao;

import java.util.ArrayList;

import Model.Invoice;

public interface InvoiceDao {
	
	public boolean InsertInvoice(Invoice invoice);
	public ArrayList<Invoice> GetListInvoice1(String Id_Account);
	public ArrayList<Invoice> GetListInvoice2(String Id_Account);
	public boolean UpdateInvoice(String Id_Invoice, int Status);
	

}
