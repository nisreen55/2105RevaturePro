package model;

public class Roles 
{
	private Integer roleId;
	private String roleName;
	
	public Roles() 
	{
	}

	public Roles(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Roles(Integer roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	
}
