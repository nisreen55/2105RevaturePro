package services;

import dao.RIdDao;
import dao.RidDaoImp;
import dao.RoleDao;
import dao.RoleDaoImpl;

public class RIdServiceImpl implements RIdService 
{
	private RIdDao ridDao = new RidDaoImp();



	@Override
	public Boolean deleteRId()
	{
		return ridDao.deleteRId();
	}



	@Override
	public Boolean addRId(Integer reimId)
	{
		return ridDao.addRId(reimId);
	}



	@Override
	public Integer getRId() 
	{
		return ridDao.getRId();
	}

}
