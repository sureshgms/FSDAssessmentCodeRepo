package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.exception.ConstraintViolationException;

import com.bean.Flights;
import com.service.FlightSetupService;

/**
 * Servlet implementation class FlightSetupController
 */
public class FlightSetupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightSetupController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd1 = request.getRequestDispatcher("Flights.jsp");

		String flightNumber = request.getParameter("flightNumber");
		int sourcePlace = Integer.parseInt(request.getParameter("sourcePlace"));
		int targetPlace = Integer.parseInt(request.getParameter("targetPlace"));
		Integer airline = Integer.parseInt(request.getParameter("airline"));
		String price1 = request.getParameter("price");
		float price = Float.parseFloat(request.getParameter("price"));

		FlightSetupService fss = new FlightSetupService();
		Flights newFlight = new Flights();
		newFlight.setFlightNumber(flightNumber);
		newFlight.setSource(sourcePlace);
		newFlight.setDestination(targetPlace);
		newFlight.setAirlineId(airline);
		newFlight.setPrice(price);

		String flightSetupRetVal;
		HttpSession session = request.getSession();
		String opString = "Init";

		try {
			// Pre validations
			// Check if source and destination are same
			if (sourcePlace == targetPlace) {
				opString = "Source and Destination Places cannot be same";
			} else {

				flightSetupRetVal = fss.newFlightSetup(newFlight);

				if (flightSetupRetVal.equals("FlightSavedSuccessfully")) {
					opString = "Flight Saved Successfully";

					pw.println("Flight Saved Successfully");
					FlightSetupService fss1 = new FlightSetupService();
					List<Flights> listOfFlights = fss1.getAllFlightsService();
					session.setAttribute("allFlights", listOfFlights);

				} else if (flightSetupRetVal.equals("uniqueConstraintException")) {
					opString = "Flight Saved Successfully";
					pw.println("Flight could not be saved !");
				}
			}
		} catch (ConstraintViolationException cve) {
			// TODO Auto-generated catch block
			opString = "Flight already Exists";
		}
		pw.println(opString);
		rd1.include(request, response);

	}

}
