package dao;

import java.util.List;

import model.ReimTypes;

public interface ReimTypeDao 
{
	public List<ReimTypes> getAll();
	public Boolean deleteReimType(Integer id);
	public Boolean addReimType(ReimTypes reimtypes);
}
