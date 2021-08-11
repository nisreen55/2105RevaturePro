package services;

import java.util.List;

import model.ErsUsers;

public interface ErsUserService 
{
	public List<ErsUsers> getAll();
	public boolean login(String username, String password);
	public Boolean deleteErsUsers(Integer id);
	public Boolean addErsUser(ErsUsers ersusers);
	public ErsUsers getUserByCredentials(String username, String password) ;
	public ErsUsers addUser(ErsUsers newUser);
	public ErsUsers getUserById(int userId);
	public ErsUsers getUserByUsername(String username);
	
}
