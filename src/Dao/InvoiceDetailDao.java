package Dao;

import java.util.ArrayList;

import Model.InvoiceDetail;

public interface InvoiceDetailDao {
	public boolean insert(InvoiceDetail invoicedetail);
	public ArrayList<InvoiceDetail> GetList_InvoiceDetail(String ID_Invoice);
	

}
