package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.ErsReim;
import model.ErsUsers;
import model.TicketView;

public class ErsReimDaoImpl implements ErsReimDao
{
	public static Logger loggy = Logger.getLogger(ErsReimDaoImpl.class);
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
	public List<ErsReim> getAll() 
	{
		List<ErsReim> ersreim = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			String sql = "SELECT reimb_id, reimb_amount, reimb_submitted,reimb_description FROM ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			//this is iterating through the records
			while(rs.next()) 
			{
				ersreim.add(new ErsReim(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4)));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return ersreim;
	}
	
	@Override
	public List<ErsReim> getTickets(String uname) 
	{
		List<ErsReim> ersreim = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			String sql1 = "DELETE FROM ticketView";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.executeUpdate();

			String sql ="INSERT INTO ticketView (reimb_id, reimb_amount, reimb_description, reimb_author, reimb_type , reimb_user_name)	"
					+ "(SELECT reimb_id, reimb_amount, reimb_description, ers_users.user_first_name||' '||ers_users.user_last_name,"
					+ "ers_reimbursement_type.reimb_type , ers_users.ers_username FROM ers_reimbursement INNER JOIN ers_reimbursement_type	"
					+ "ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id "
					+ "INNER JOIN ers_users ON (ers_reimbursement.reimb_author = ers_users.ers_users_id	 and ers_users.ers_username = ?))";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				ersreim.add(new ErsReim(rs.getLong(1), rs.getDouble(2), rs.getString(3), rs.getInt(4)));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println(ersreim);
		return ersreim;
	}

	@Override
	public Boolean deleteErsReim(Integer id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addErsReim(ErsReim ersreim, String cUser) 
	{
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			String sql = "INSERT INTO ers_reimbursement (reimb_id, reimb_amount, reimb_description, reimb_type_id, reimb_author)"
					+ "	VALUES (?,?,?,?,(SELECT ers_users_id FROM ers_users WHERE  ers_username = ?))";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ersreim.getReimbId());
			ps.setDouble(2, ersreim.getReimbAmount());
			ps.setString(3, ersreim.getReimbDes());
			ps.setInt(4, ersreim.getReimbType());
			ps.setString(5, cUser);

			ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Boolean deleteUName() 
	{
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			String sql = "delete  from uname";
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<TicketView> getTicketView(String uname) 
	{
		List<TicketView> tick = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			//clear view table
			String sql1 = "DELETE FROM ticketView";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.executeUpdate();
			// fetch data into view table
			String sql2 ="INSERT INTO ticketView (reimb_id, reimb_amount, reimb_submitted,reimb_description, reimb_author, reimb_type , reimb_user_name,  reimb_status)	"
					+ "(SELECT reimb_id, reimb_amount,reimb_submitted, reimb_description, ers_users.user_first_name||' '||ers_users.user_last_name author_name,"
					+ "ers_reimbursement_type.reimb_type , ers_users.ers_username,  ers_reimbursement_status.reimb_status "
					+ "FROM ers_reimbursement INNER JOIN ers_reimbursement_type	"
					+ "ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id "
					+ "INNER JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id "
					+ "INNER JOIN ers_users ON ers_reimbursement.reimb_author = ers_users.ers_users_id	 where ers_users.ers_username = ?"
					+ "order by reimb_submitted DESC)";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, uname);
			ps2.executeUpdate();

			
			// show data from view table
			//String sql = "SELECT reimb_id, reimb_amount, reimb_submitted,reimb_type, reimb_resolver FROM ticketView where reimb_user_name = ?";
			String sql = "SELECT reimb_id, reimb_amount, reimb_submitted,reimb_type, reimb_author, reimb_status FROM ticketView ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			//this is iterating through the records
			while(rs.next()) 
			{
				tick.add(new TicketView(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4) , rs.getString(5) , rs.getString(6)));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return tick;
	}

	@Override
	public List<TicketView> getTicketsManager() 
	{
		List<TicketView> tick = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			//clear view table
			String sql1 = "DELETE FROM ticketView";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.executeUpdate();
           //org.postgresql.util.PSQLException: ERROR: syntax error at or near "INNER"	  Position: 330
			String sql = "INSERT INTO ticketView (reimb_id, reimb_amount, reimb_submitted, reimb_description, reimb_author,reimb_type ,  reimb_status )"
					+ "(SELECT  reimb_id, reimb_amount, reimb_submitted, reimb_description, user_first_name||' '|| user_last_name,ers_reimbursement_type.reimb_type ,  ers_reimbursement_status.reimb_status	"
					+ "FROM ers_reimbursement INNER JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id	"
					+ "INNER JOIN ers_reimbursement_type ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id	"
					+ "INNER JOIN ers_users ON (ers_reimbursement.reimb_author = ers_users.ers_users_id) order by reimb_submitted DESC)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.executeUpdate();
			
			// show data from view table
			//String sql = "SELECT reimb_id, reimb_amount, reimb_submitted,reimb_type, reimb_resolver FROM ticketView where reimb_user_name = ?";
			String sql2 = "SELECT reimb_id, reimb_amount, reimb_submitted,reimb_type, reimb_author, reimb_status FROM ticketView ";

			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ResultSet rs2= ps2.executeQuery();
									
			//this is iterating through the records
			while(rs2.next()) 
			{
				tick.add(new TicketView(rs2.getInt(1), rs2.getDouble(2), rs2.getString(3), rs2.getString(4) , rs2.getString(5),  rs2.getString(6)));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return tick;
	}

	@Override
	public List<TicketView> getETicketManager(int reimId) 
	{
		List<TicketView> tick1 = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			//clear view table
			String sql1 = "DELETE FROM ticketView";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.executeUpdate();

			String sql = "INSERT INTO ticketView (reimb_id, reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_type ,  reimb_status )"
					+ "(SELECT  reimb_id, reimb_amount, reimb_submitted, reimb_description, user_first_name||' '|| user_last_name,ers_reimbursement_type.reimb_type ,  ers_reimbursement_status.reimb_status	"
					+ "FROM ers_reimbursement INNER JOIN ers_reimbursement_status ON ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id	"
					+ "INNER JOIN ers_reimbursement_type ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id	"
					+ "INNER JOIN ers_users ON (ers_reimbursement.reimb_author = ers_users.ers_users_id ) WHERE ers_reimbursement.reimb_id = ? "
					+ "order by reimb_submitted DESC)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimId);

			ps.executeUpdate();
			
			// show data from view table
			//String sql = "SELECT reimb_id, reimb_amount, reimb_submitted,reimb_type, reimb_resolver FROM ticketView where reimb_user_name = ?";
			String sql2 = "SELECT reimb_id, reimb_amount, reimb_submitted,reimb_type, reimb_author, reimb_status FROM ticketView ";

			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ResultSet rs2= ps2.executeQuery();
									
			//this is iterating through the records
			while(rs2.next()) 
			{
				tick1.add(new TicketView(rs2.getInt(1), rs2.getDouble(2), rs2.getString(3), rs2.getString(4) , rs2.getString(5),  rs2.getString(6)));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return tick1;
	}

	@Override
	public Boolean appTicket(int reim) 
	{
	
			try(Connection conn = DriverManager.getConnection(url,username,password))
			{
				String sql = "UPDATE ers_reimbursement SET reimb_status_id = 2 WHERE reimb_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, reim);

				ps.executeUpdate();
				loggy.info("Ticket id " + reim +"  approved");


			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
			return true;
		
	}

	@Override
	public Boolean denTicket(int reim) 
	{

		try(Connection conn = DriverManager.getConnection(url,username,password))
		{
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = 3 WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reim);
			ps.executeUpdate();
			loggy.info("Ticket id " + reim +"  denied");
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	
	}
}
