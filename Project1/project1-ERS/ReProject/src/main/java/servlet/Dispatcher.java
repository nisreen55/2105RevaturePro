package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

import controller.AllTicketController;
import controller.AppleController;
import controller.HomeController;
import controller.LoginController;
import controller.ManagerController;
import controller.PepperController;
import controller.TicketController;

public class Dispatcher {

	public static void myVirtualRouter(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException, ServletException {
		
		System.out.println("\n\n\t\tIn MyDispatcher (myVirtualRouter())");
		System.out.println("Current URL: "+req.getRequestURL());
		System.out.println("Current URI: "+req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ReProject/forwarding/login":
			System.out.println("case 1");
			LoginController.login(req, res);
			break;
		//case "/ReProject/forwarding/webapp/resources/home.html":
		case "/ReProject/forwarding/webapp/resources/empForm.html":
			System.out.println("employee");
			HomeController.home(req, res);
			break;
		case "/ReProject/forwarding/webapp/resources/managerForm.html":
			System.out.println("manager");
			ManagerController.home(req, res);

			break;
		/*case "/ReProject/forwarding/employee":
			System.out.println("employee");
			HomeController.home(req, res);
			break;*/
		case "/ReProject/json/viewAllTicket":
			System.out.println("case 3");
			TicketController.viewAllTicket(req, res);
			break;
		// manager	
		case "/ReProject/json/viewTicket":
			System.out.println("case 4");
			AllTicketController.viewTicket(req, res);
			break;
		//case "/ReProject/json/viewETicket":
		case "/ReProject/json/managerAD":

			System.out.println("case 5");
			AllTicketController.getReimbId(req, res);
			break;
		case "/ReProject/json/appEmployeeTicket":
			System.out.println("case 6");
			AllTicketController.appTicket(req, res);
			break;
		case "/ReProject/json/denEmployeeTicket":
			System.out.println("case 7");
			AllTicketController.denTicket(req, res);
			break;
			
			
		
		case "/ReProject/json/adTicket":
			System.out.println("case 7");
			TicketController.addTicket(req, res);
			break;
		case "/ReProject/json/getCurrentUserObject":
			
			break;
		default:
			System.out.println("Dude, you gave me a bad URI.");
			req.getRequestDispatcher("/resources/html/badlogin.html").forward(req, res);
			return;
			
		}
	}
}
