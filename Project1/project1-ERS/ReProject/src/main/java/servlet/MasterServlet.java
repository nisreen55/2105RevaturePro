package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.UName;


@WebServlet(name="MasterServlet", urlPatterns= {"/master/*", "/forwarding/*", "/json/*"})
public class MasterServlet extends HttpServlet {

	//private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		System.out.println("MASTER SERVLET: In the doGet method!!!");
		

		Dispatcher.myVirtualRouter(req, resp); 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		System.out.println("MASTER SERVLET: In the doPost method!!!");
		
		doGet(req, resp);
		
		

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		System.out.println("MASTER SERVLET: In the doPost method!!!");
		
		doGet(req, resp);
		
	}
}
