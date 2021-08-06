package dao;

import java.util.List;

import model.ReimStatus;

public interface ReimStatusDao 
{
	public List<ReimStatus> getAll();
	public Boolean deleteReimStatus(Integer id);
	public Boolean addReimStatus(ReimStatus reimstatus);
}
