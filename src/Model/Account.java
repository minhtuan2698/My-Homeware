package Model;

public class Account {
	private String id_account;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String address;
	private String phone;
	private int access;
	private int status;
	public Account() {
		super();
	}
	public Account(String id_account, String username, String password, String fullname, String email, String address,
			String phone, int access, int status) {
		super();
		this.id_account = id_account;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.access = access;
		this.status = status;
	}
	
	public Account(String id_account) {
		super();
		this.id_account = id_account;
		
	}
	
	public String getId_account() {
		return id_account;
	}
	public void setId_account(String id_account) {
		this.id_account = id_account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
