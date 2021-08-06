package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReimID;
import model.Roles;

public class RidDaoImp implements RIdDao
{
	public String url = "jdbc:postgresql://myrevdb.cz6n1xji1smg.us-east-2.rds.amazonaws.com/reimbdb";
	public String username = "Nisreen55";
	public String password = "Reema5leena6$";
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
	public Boolean deleteRId() 
	{
				try(Connection conn = DriverManager.getConnection(url,username,password))
				{
					
					String sql = "DELETE FROM ReimId";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.executeUpdate();
					
					
				}
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
		return true;		
			
	}
	@Override
	public Boolean addRId(Integer reimId) 
	{
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			
			String sql = "INSERT INTO ReimId VALUES (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimId);
			ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return true;	
	}
	@Override
	public Integer getRId() 
	{
		Integer rid=0;
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			
			String sql = "SELECT * FROM ReimID";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			//this is iterating through the records
			while(rs.next()) 
			{
				rid = rs.getInt(1);
			}
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return rid;
	}	

}
