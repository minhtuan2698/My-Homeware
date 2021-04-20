package Model;

public class UserCode {
	
	public String username;
	public String email;
	public int code;
	public UserCode() {
		super();
	}

	public UserCode(String username, String email, int code) {
		super();
		this.username = username;
		this.email = email;
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	

}
