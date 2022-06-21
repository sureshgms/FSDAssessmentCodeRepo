package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Airlines;
import com.bean.Flights;
import com.bean.Places;
import com.bean.Users;
import com.service.AirlineSetupService;
import com.service.FlightSetupService;
import com.service.LoginServiceFlyAway;
import com.service.PlaceSetupService;
import com.bean.FlightsList;

/**
 * Servlet implementation class LoginControllerFlyAway
 */
public class LoginControllerFlyAway extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControllerFlyAway() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		// Places sourceTarget = new Places();
		
		//To Avoid login all the time
		//username = "admin@gmail.com";
		//password = "admin";

		HttpSession session = request.getSession();
		session.setAttribute("currentSessionPassword", password);

		Users adminUser = new Users(1, username, "ADMIN", password);
		session.setAttribute("userObj", adminUser); // Set the User Object in an attribute

		// Code to pre-populate table data for Flights setup LOV fields
		PlaceSetupService ps = new PlaceSetupService();
		List<Places> listOfPlaces = ps.getAllPlacesService();
		session.setAttribute("allPlaces", listOfPlaces);

		AirlineSetupService ass = new AirlineSetupService();
		List<Airlines> listOfAirlines = ass.getAllAirlinesService();
		session.setAttribute("allAirlines", listOfAirlines);
		
		FlightSetupService fss = new FlightSetupService();
		List<Flights> listOfFlights = fss.getAllFlightsService();
		session.setAttribute("allFlights", listOfFlights);

		LoginServiceFlyAway ls = new LoginServiceFlyAway();
		RequestDispatcher rd1 = request.getRequestDispatcher("AdminPage.jsp");
		if (ls.checkAdminLogin(adminUser).equals("AdminLoginSuccess")) {
			rd1.include(request, response);
		} else {
			pw.println("Invalid userName or Password...Try again !!");
		}

	}

}
