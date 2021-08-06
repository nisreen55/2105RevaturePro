package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Roles;

public class RoleDaoImpl implements RoleDao
{
	public String url = "jdbc:postgresql://myrevdb.cz6n1xji1smg.us-east-2.rds.amazonaws.com/reimbdb";
	public String username = "Nisreen55";
	public String password = "Reema5leena6$";
	
	@Override
	public List<Roles> getAll() 
	{
		List<Roles> roles = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			
			String sql = "SELECT * FROM ers_user_roles ORDER BY ers_user_role_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			//this is iterating through the records
			while(rs.next()) 
			{
				roles.add(new Roles(rs.getInt(1), rs.getString(2)));
			}
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return roles;
	}

	@Override
	public Boolean deleteRole(Integer id) 
	{
		return null;
	}

	@Override
	public Boolean addRole(Roles role) 
	{
		return null;

	}

}
