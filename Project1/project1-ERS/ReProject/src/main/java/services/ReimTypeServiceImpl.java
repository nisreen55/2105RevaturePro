package services;

import java.util.List;

import dao.ReimTypeDao;
import dao.ReimTypeDaoImp;
import model.ReimTypes;

public class ReimTypeServiceImpl implements ReimTypeService
{
	private ReimTypeDao reimtypeDao = new ReimTypeDaoImp();
	
	@Override
	public List<ReimTypes> getAll() 
	{
		return reimtypeDao.getAll();
	}

	@Override
	public Boolean deleteReimType(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addReimType(ReimTypes reimtypes) {
		// TODO Auto-generated method stub
		return null;
	}

}
