package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class TypesController 
{
	public static Logger loggy = Logger.getLogger(TypesController.class);

	public static void typesForm(HttpServletRequest req, HttpServletResponse res)   	throws ServletException, IOException 
	{
		String myPath = "/resources/html/empForm.html";
		req.getRequestDispatcher(myPath).forward(req, res);
	}
	
	public static void viewTypesForm(HttpServletRequest req, HttpServletResponse res)   	throws ServletException, IOException 
	{
		String myPath = "/resources/html/viewTypes.html";
		req.getRequestDispatcher(myPath).forward(req, res);
	}
}
