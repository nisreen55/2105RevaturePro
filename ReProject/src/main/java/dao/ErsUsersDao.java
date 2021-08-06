package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ErsUsers;

public interface ErsUsersDao 
{
	public List<ErsUsers> getAll();
	public boolean login(String username, String password);
	public Boolean deleteErsUsers(Integer id);
	public Boolean addErsUser(ErsUsers ersusers);
	public ErsUsers getByCredentials(String username, String password);
	public ErsUsers add(ErsUsers newUser);
	public ErsUsers getByUsername(String username) ;
	public ErsUsers getById(int id) ;
	public List<ErsUsers> mapResultSet(ResultSet rs) throws SQLException;
	
}