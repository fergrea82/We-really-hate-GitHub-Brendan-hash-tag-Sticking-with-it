package data.dataObjects;

public class UserObject {
	
	private int userID;
	private String userName;
	
	public UserObject(int userID, String userName){
		this.userID=userID;
		this.userName=userName;
	}
	
	public UserObject() {
		//default constructor
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
