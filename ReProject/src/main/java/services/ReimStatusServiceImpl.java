package services;

import java.util.List;
import dao.ReimStatusDao;
import dao.ReimStatusDaoImpl;
import model.ReimStatus;

public class ReimStatusServiceImpl implements ReimStatusService
{
	private ReimStatusDao reimstatusDao = new ReimStatusDaoImpl();

	@Override
	public List<ReimStatus> getAll() 
	{
		return reimstatusDao.getAll();
	}

	@Override
	public Boolean deleteReimStatus(Integer id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addReimStatus(ReimStatus reimstatus) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
