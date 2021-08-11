package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class HomeController 
{
	public static Logger loggy = Logger.getLogger(HomeController.class);

	public static void home(HttpServletRequest req, HttpServletResponse res)   	throws ServletException, IOException 
	{
		String myPath = "/resources/html/empForm.html";
		req.getRequestDispatcher(myPath).forward(req, res);
	}
	
	
	
}
