package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.ReimID;
import model.TicketView;
import services.ErsReimService;
import services.ErsReimServiceImpl;
import services.RIdService;
import services.RIdServiceImpl;

public class AllTicketController 
{
	private static ErsReimService empdService = new ErsReimServiceImpl();
	private static RIdService reiService = new RIdServiceImpl();

	public static Integer reimInt ;
	
	public static void viewTicket(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException 
	{
		res.setContentType("application/json");
		String currUser= (String)req.getSession().getAttribute("loggedInUsername");
		System.out.println("logged user :" + currUser);
		//List<ErsReim> ersReim = empdService.getTickets(currUser);
		List<TicketView> myTickList1 = empdService.getTicketsManager();
		System.out.println(myTickList1);
		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myTickList1));
	}
	
	public static void getReimbId(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException 
	{
		res.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		ReimID reID = mapper.readValue(req.getInputStream(), ReimID.class);
		String reimStr = reID.getReimbId();
		reimInt = Integer.parseInt(reimStr); 
		reiService.deleteRId();
		reiService.addRId(reimInt);
		System.out.println("reimb id is "+reimInt);
		List<TicketView> myTickList2 = empdService.getETicketManager(reimInt);
		System.out.println(myTickList2);
		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myTickList2));
	}
	
	public static void appTicket(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException 
	{
		res.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		ReimID reID = mapper.readValue(req.getInputStream(), ReimID.class);
		String reimStr = reID.getReimbId();
		reimInt = Integer.parseInt(reimStr); 
		System.out.println(reimInt);
		empdService.appTicket(reimInt);
		System.out.println("status updated");
	}
	public static void denTicket(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException 
	{
		res.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		ReimID reID = mapper.readValue(req.getInputStream(), ReimID.class);
		String reimStr = reID.getReimbId();
		reimInt = Integer.parseInt(reimStr); 
		System.out.println(reimInt);
		empdService.denTicket(reimInt);
		System.out.println("status updated");
	}
}
