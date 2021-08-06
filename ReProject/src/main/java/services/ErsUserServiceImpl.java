package services;

import java.util.List;

import dao.ErsUsersDao;
import dao.ErsUsersDaoImpl;
import model.ErsUsers;

public class ErsUserServiceImpl implements ErsUserService
{
	private ErsUsersDao ersusersDao = new ErsUsersDaoImpl();

	@Override
	public List<ErsUsers> getAll() 
	{
		return ersusersDao.getAll();
	}

	@Override
	public Boolean deleteErsUsers(Integer id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addErsUser(ErsUsers ersusers) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErsUsers getUserByCredentials(String username, String password) 
	{
		if(!username.equals("") && !password.equals("")) 
		
			//return ersusersDao.getByCredentials(username, AES.encrypt(password));
			return ersusersDao.getByCredentials(username, password);
		else
			return null;
	}

	@Override
	public ErsUsers addUser(ErsUsers newUser) 
	{
		// Verify that there are no empty fields
					if (newUser.getErsUserName().equals("") 
							|| newUser.getErsPassword().equals("") 
							|| newUser.getUserFirst_name().equals("")
							|| newUser.getUserLastName().equals("")
							|| newUser.getUserEmail().equals("")) {
						//log.info("New user object is missing required fields");
						return null;
					}
					// Encrypt the user's password
					newUser.setErsPassword(newUser.getErsPassword());
					newUser = ersusersDao.add(newUser);
					newUser.setErsPassword(newUser.getErsPassword());
					return newUser;
	}

	@Override
	public ErsUsers getUserById(int userId) 
	{
		ErsUsers user = ersusersDao.getById(userId);
		user.setErsPassword(user.getErsPassword());
		return user;
	}

	@Override
	public ErsUsers getUserByUsername(String username) 
	{
		return ersusersDao.getByUsername(username);
	}

	@Override
	public boolean login(String username, String password) 
	{
		return ersusersDao.login(username, password);
	}

}
