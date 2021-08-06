package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ErsUsers;
import services.ErsUserService;
import services.ErsUserServiceImpl;

public class LoginController 
{
	private static ErsUserService usersService = new ErsUserServiceImpl();

	
	public static void login(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException 
	{
		String myPath = null;
		if(!req.getMethod().equals("POST"))
		{
			myPath = "/indexx.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = (String)req.getParameter("logform_action");
		System.out.println("logged user is "+ role);

		
		boolean isLoging = usersService.login(username, password);
		System.out.println(isLoging);
		
		if(!isLoging)
		{
			myPath = "/forwarding/incorrectcredentials";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}
		else 
		{
			req.getSession().setAttribute("loggedInUsername", username);
			req.getSession().setAttribute("loggedInPassword", password);
			req.getSession().setAttribute("loggedInRole", role);

			//myPath = "/forwarding/webapp/resources/home.html";
			if(role.equals("Employee"))
				myPath = "/forwarding/webapp/resources/empForm.html";
			else
				myPath = "/forwarding/webapp/resources/managerForm.html";

			System.out.println("from login"+myPath);
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}
			
	}

}


