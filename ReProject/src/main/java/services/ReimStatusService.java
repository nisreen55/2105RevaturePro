package services;

import java.util.List;

import model.ReimStatus;

public interface ReimStatusService 
{
	public List<ReimStatus> getAll();
	public Boolean deleteReimStatus(Integer id);
	public Boolean addReimStatus(ReimStatus reimstatus);
}
