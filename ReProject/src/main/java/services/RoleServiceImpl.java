package services;

import java.util.List;

import dao.RoleDao;
import dao.RoleDaoImpl;
import model.Roles;

public class RoleServiceImpl implements RoleService
{

	private RoleDao roleDao = new RoleDaoImpl();
	
	
	@Override
	public List<Roles> getAll() 
	{
		return roleDao.getAll();

	}

	@Override
	public Boolean deleteRole(Integer id) 
	{
		return null;

	}

	@Override
	public Boolean addUseRole(Roles userrole) 
	{
		return null;

	}
	
}
