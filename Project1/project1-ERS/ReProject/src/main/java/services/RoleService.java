package services;

import java.util.List;

import model.Roles;

public interface RoleService 
{
	public List<Roles> getAll();
	public Boolean deleteRole(Integer id);
	public Boolean addUseRole(Roles userrole);
}

