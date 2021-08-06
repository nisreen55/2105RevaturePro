package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Roles;

public class AppleController 
{
	public static void appleFinder(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {
		
		/*
		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
		 */
		
		 //Roles  roles = new Roles(22, "ceo");
		
		PrintWriter printer = res.getWriter();
		//printer.write(new ObjectMapper().writeValueAsString(roles));
	}

}
