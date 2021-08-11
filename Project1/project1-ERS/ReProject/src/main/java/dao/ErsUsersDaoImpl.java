package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import model.ErsUsers;
import model.ReimStatus;

public class ErsUsersDaoImpl implements ErsUsersDao
{
	public String url = "jdbc:postgresql://myrevdb.cz6n1xji1smg.us-east-2.rds.amazonaws.com/reimbdb";

	public String username1 = "Nisreen55";
	public String password1 = "Reema5leena6$";
	
	static 
	{ 
	      try 
	      {
	          Class.forName("org.postgresql.Driver");
	      }
	      catch(ClassNotFoundException e) 
	      {
	          e.printStackTrace();
	          System.out.println("Static block has failed me");
	      }
	}


	@Override
	public List<ErsUsers> getAll() 
	{
		List<ErsUsers> allusers = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username1,password1))
		{
			
			String sql = "SELECT * FROM ers_users ORDER BY ers_users_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			//this is iterating through the records
			while(rs.next()) 
			{
				allusers.add(new ErsUsers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
										 rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return allusers;
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
	public ErsUsers getByCredentials(String username, String password) 
	{
		ErsUsers user = new ErsUsers();

		try(Connection conn = DriverManager.getConnection(url,username1,password1))
		{

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?");

			pstmt.setString(1, username);
			pstmt.setString(2, password); // does this value correctly hold the encrypted password?

			ResultSet rs = pstmt.executeQuery();
			List<ErsUsers> ersusers = this.mapResultSet(rs);
			
			if (ersusers.isEmpty()) user = null;
			else user = ersusers.get(0);

		} catch (SQLException e) {
			//log.error(e.getMessage());
		}

		//return user;
		return user;

	}

	@Override
	public ErsUsers add(ErsUsers newUser) 
	{
		try(Connection conn = DriverManager.getConnection(url,username1,password1))
		{
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ERS_users VALUES (0, ?, ?, ?, ?, ?, 1)", new String[] {"ers_users_id"});
			pstmt.setString(1, newUser.getErsUserName());
			pstmt.setString(2, newUser.getErsPassword());
			pstmt.setString(3, newUser.getUserFirst_name());
			pstmt.setString(4, newUser.getErsPassword());
			pstmt.setString(5, newUser.getUserEmail());

			if(pstmt.executeUpdate() != 0) {

				ResultSet rs = pstmt.getGeneratedKeys();

				while(rs.next()) {
					newUser.setErsUsersId(rs.getInt(1));
				}

				conn.commit();
			}

		} catch (SQLIntegrityConstraintViolationException sicve) { 
			sicve.printStackTrace();
			//log.warn("Username already taken.");
		} catch (SQLException e) {
			//log.error(e.getMessage());
		}

		if(newUser.getErsUsersId() == 0) return null;
		return newUser;
	}

	@Override
	public ErsUsers getByUsername(String username) 
	{
		ErsUsers user = null;

		try(Connection conn = DriverManager.getConnection(url,username1,password1))
		{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ers_users JOIN ers_user_roles USING (user_role_id) WHERE username = ?");
			pstmt.setString(1, username);

			List<ErsUsers> ersusers = this.mapResultSet(pstmt.executeQuery());
			if (!ersusers.isEmpty()) user = ersusers.get(0);

		} catch (SQLException e) {
			//log.error(e.getMessage());
		}

		return user;
	}

	@Override
	public ErsUsers getById(int id) 
	{
		ErsUsers user = new ErsUsers();

		try(Connection conn = DriverManager.getConnection(url,username1,password1))
		{
			// Joining to user roles to grab role as a String
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ers_users JOIN ers_user_roles USING (user_role_id) WHERE ers_users_id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			List<ErsUsers> ersusers = this.mapResultSet(rs);
			if (ersusers.isEmpty()) user = null;
			else user = ersusers.get(0);

		} catch (SQLException e) {
			//log.error(e.getMessage());
		}

		return user;
	}

	@Override
	public List<ErsUsers> mapResultSet(ResultSet rs) throws SQLException 
	{
		List<ErsUsers> ersusers = new ArrayList<>();

		while(rs.next()) {
			ErsUsers user = new ErsUsers();
			user.setErsUsersId(rs.getInt("ers_users_id"));
			user.setErsUserName(rs.getString("ers_username"));
			user.setErsPassword(rs.getString("ers_password"));
			user.setUserFirst_name(rs.getString("user_first_name"));
			user.setUserLastName(rs.getString("user_last_name"));
			user.setUserEmail(rs.getString("user_email"));
			user.setUserRoleId(rs.getInt("user_role_id"));

			ersusers.add(user);
		}
		return ersusers;
	}
	
	@Override
	public boolean login(String userName, String password) 
	{
				boolean login = false;
				try(Connection conn = DriverManager.getConnection(url,username1,password1))
				{
					String sql = "SELECT ers_username, ers_password FROM ers_users WHERE ers_username = ? AND ers_password =?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, userName);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						login = true;
					}
					else
						login = false;
				}
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
				return login;
	}
}
