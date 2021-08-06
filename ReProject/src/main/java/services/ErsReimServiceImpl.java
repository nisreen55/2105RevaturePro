package services;

import java.util.List;

import dao.ErsReimDao;
import dao.ErsReimDaoImpl;
import dao.ReimStatusDao;
import dao.ReimStatusDaoImpl;
import model.ErsReim;
import model.TicketView;

public class ErsReimServiceImpl implements  ErsReimService
{
	private ErsReimDao ersreimdao = new ErsReimDaoImpl();

	@Override
	public List<ErsReim> getAll() 
	{
		return ersreimdao.getAll();
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
		return ersreimdao.addErsReim(ersreim, cUser);
	}

	@Override
	public Boolean deleteUName() 
	{
		return ersreimdao.deleteUName();
	}



	@Override
	public List<ErsReim> getTickets(String uname) 
	{		
		return ersreimdao.getTickets(uname);

	}

	@Override
	public List<TicketView> getTicketView(String uname) 
	{
		return ersreimdao.getTicketView(uname);
	}

	@Override
	public List<TicketView> getTicketsManager() 
	{
		return ersreimdao.getTicketsManager();
	}

	@Override
	public List<TicketView> getETicketManager(int reim) 
	{
		return ersreimdao.getETicketManager(reim);
	}

	@Override
	public Boolean appTicket(int reim) 
	{
		return(ersreimdao.appTicket(reim));
	}

	@Override
	public Boolean denTicket(int reim) 
	{
		return(ersreimdao.denTicket(reim));
	}

	

	
}
