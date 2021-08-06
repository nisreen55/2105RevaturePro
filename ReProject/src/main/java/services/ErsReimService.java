package services;

import java.util.List;

import model.ErsReim;
import model.TicketView;

public interface ErsReimService 
{
	public List<ErsReim> getAll();
	public List<ErsReim> getTickets(String uname);
	public List<TicketView> getTicketsManager();
	public List<TicketView> getETicketManager(int reim);
	public Boolean appTicket(int reim);
	public Boolean denTicket(int reim);

	public List<TicketView> getTicketView(String uname);
	public Boolean deleteErsReim(Integer id);
	public Boolean addErsReim(ErsReim ersreim, String cUser);
	public Boolean deleteUName();
}
