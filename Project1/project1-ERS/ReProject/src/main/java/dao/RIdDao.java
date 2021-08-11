package dao;

import java.util.List;

import model.ReimID;
import model.Roles;

public interface RIdDao 
{
	public Boolean deleteRId();
	public Boolean addRId(Integer reimId);
	public Integer getRId();
}
