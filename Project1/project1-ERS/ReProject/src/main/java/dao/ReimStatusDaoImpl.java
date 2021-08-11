package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReimStatus;

public class ReimStatusDaoImpl implements ReimStatusDao
{
	public String url = "jdbc:postgresql://myrevdb.cz6n1xji1smg.us-east-2.rds.amazonaws.com/reimbdb";
	public String username = "Nisreen55";
	public String password = "Reema5leena6$";
	
	@Override
	public List<ReimStatus> getAll() 
	{
		List<ReimStatus> reimstatus = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			
			String sql = "SELECT * FROM ers_reimbursement_status ORDER BY reimb_status_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			//this is iterating through the records
			while(rs.next()) 
			{
				reimstatus.add(new ReimStatus(rs.getInt(1), rs.getString(2)));
			}
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return reimstatus;
	}
	

	@Override
	public Boolean deleteReimStatus(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addReimStatus(ReimStatus reimstatus) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
