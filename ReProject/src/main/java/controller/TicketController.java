package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.ErsReim;
import model.ErsUsers;
import model.TicketView;
import model.UName;
import services.ErsReimService;
import services.ErsReimServiceImpl;

public class TicketController 
{
	private static ErsReimService empdService = new ErsReimServiceImpl();

	public static void viewTicketUser(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException 
	{
		res.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		UName str = mapper.readValue(req.getInputStream(), UName.class);
		String sn = str.getName();
		System.out.println(sn);

		res.setStatus(HttpServletResponse.SC_CREATED);
				
		List<ErsReim> ersReim = empdService.getTickets(sn);
		System.out.println(ersReim);
		PrintWriter printer = res.getWriter();
    	printer.write(new ObjectMapper().writeValueAsString(ersReim));
	}
	
	public static void addTicket(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException 
	{
		res.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		ErsReim myErsReim = mapper.readValue(req.getInputStream(), ErsReim.class);

		res.setStatus(HttpServletResponse.SC_CREATED);
		System.out.println("new ticket "+myErsReim);
		String curUser= (String)req.getSession().getAttribute("loggedInUsername");
		empdService.addErsReim(myErsReim, curUser);

		
		//List<ErsReim> ersReim = empdService.getTickets(sn);
		//System.out.println(ersReim);
		//PrintWriter printer = res.getWriter();
    	//printer.write(new ObjectMapper().writeValueAsString(ersReim));
	}
	
	public static void viewAllTicket(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException 
	{
		res.setContentType("application/json");
		String currUser= (String)req.getSession().getAttribute("loggedInUsername");
		System.out.println("logged user :" + currUser);
		//List<ErsReim> ersReim = empdService.getTickets(currUser);
		List<TicketView> myTickList = empdService.getTicketView(currUser);
		System.out.println("printing myTIC K");
		System.out.println(myTickList);
		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myTickList));
	}
}


