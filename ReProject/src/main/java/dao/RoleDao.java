package dao;

import java.util.List;

import model.Roles;

public interface RoleDao 
{
	public List<Roles> getAll();
	public Boolean deleteRole(Integer id);
	public Boolean addRole(Roles role);
}
