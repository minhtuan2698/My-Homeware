package Dao;

import Model.Account;

public interface AccountDao {
	
	public Account CheckLogin(String username, String password);
	public boolean Check(String username, String password);
	public boolean InsertAcount(Account acc);
	public boolean CheckPhone(String phone);
	public boolean CheckEmail(String email);
	public boolean CheckUsername(String username);
	public boolean CheckUserEmail(String username, String email);
	
	
	public boolean EditPassword(String username, String password);


	public Account GetAccount(String ID_Account);
	

	
	public static void main(String[] args) {
		AccountDao dao = new AccountDao_Impl();
		System.out.print(dao.Check("tuan26", "1234"));
		
	}
}
