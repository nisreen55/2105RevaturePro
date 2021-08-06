package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReimTypes;

public class ReimTypeDaoImp implements ReimTypeDao
{
	public String url = "jdbc:postgresql://myrevdb.cz6n1xji1smg.us-east-2.rds.amazonaws.com/reimbdb";
	public String username = "Nisreen55";
	public String password = "Reema5leena6$";
	
	@Override
	public List<ReimTypes> getAll() 
	{
		List<ReimTypes> reimtypes = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			
			String sql = "SELECT * FROM ers_reimbursement_type ORDER BY reimb_type_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			//this is iterating through the records
			while(rs.next()) 
			{
				reimtypes.add(new ReimTypes(rs.getInt(1), rs.getString(2)));
			}
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return reimtypes;
	}


	@Override
	public Boolean deleteReimType(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addReimType(ReimTypes reimtypes) {
		// TODO Auto-generated method stub
		return null;
	}

}
