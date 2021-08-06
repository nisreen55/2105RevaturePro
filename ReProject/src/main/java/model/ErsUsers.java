package model;

public class ErsUsers 
{
	private Integer ersUsersId;
	private String ersUserName;
	private String ersPassword ;
	private String userFirst_name;
	private String userLastName ;
	private String userEmail ;
	private Integer userRoleId ;
	
	public ErsUsers() 
	{
	}

	public ErsUsers(Integer ersUsersId, String ersUserName, String ersPassword, String userFirst_name,
			String userLastName, String userEmail, Integer userRoleId) 
	{
		super();
		this.ersUsersId = ersUsersId;
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.userFirst_name = userFirst_name;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}

	public ErsUsers(String ersUserName, String ersPassword, String userFirst_name, String userLastName,
			String userEmail, Integer userRoleId) 
	{
		super();
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.userFirst_name = userFirst_name;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}

	public Integer getErsUsersId() {
		return ersUsersId;
	}

	public void setErsUsersId(Integer ersUsersId) {
		this.ersUsersId = ersUsersId;
	}

	public String getErsUserName() {
		return ersUserName;
	}

	public void setErsUserName(String ersUserName) {
		this.ersUserName = ersUserName;
	}

	public String getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getUserFirst_name() {
		return userFirst_name;
	}

	public void setUserFirst_name(String userFirst_name) {
		this.userFirst_name = userFirst_name;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "ErsUsers [ersUsersId=" + ersUsersId + ", ersUserName=" + ersUserName + ", ersPassword=" + ersPassword
				+ ", userFirst_name=" + userFirst_name + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRoleId=" + userRoleId + "]";
	}
	
	
	
	
}
