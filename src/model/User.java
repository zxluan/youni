package model;

<<<<<<< HEAD
import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -7060210544600464481L;   
=======
public class User {
>>>>>>> 064793302faf8e6eda077b63484d3b2cf6ee8a4b
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPassword;
    private String userAddress;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
    
   
}
