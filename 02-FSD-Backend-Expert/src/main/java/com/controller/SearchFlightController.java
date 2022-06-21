package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Airlines;
import com.bean.AvailableFlights;
import com.bean.Flights;
import com.bean.Places;
import com.service.AirlineSetupService;
import com.service.FlightSetupService;
import com.service.PlaceSetupService;

/**
 * Servlet implementation class SearchFlightController
 */
@WebServlet("/SearchFlightController")
public class SearchFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchFlightController() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// Code to pre-populate table data for Flights setup LOV fields
		HttpSession session = request.getSession();
		RequestDispatcher rd1 = request.getRequestDispatcher("SearchFlights.jsp");

		PlaceSetupService ps = new PlaceSetupService();
		List<Places> listOfPlaces = ps.getAllPlacesService();
		session.setAttribute("allPlaces", listOfPlaces);

		AirlineSetupService ass = new AirlineSetupService();
		List<Airlines> listOfAirlines = ass.getAllAirlinesService();
		session.setAttribute("allAirlines", listOfAirlines);

		FlightSetupService fss = new FlightSetupService();
		List<Flights> listOfFlights = fss.getAllFlightsService();
		session.setAttribute("allFlights", listOfFlights);
		rd1.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		List<AvailableFlights> availableFlightList = new ArrayList<AvailableFlights>();

		String sourcePlace = request.getParameter("sourcePlace");
		String destPlace = request.getParameter("targetPlace");
		String travelDate = request.getParameter("travelDate");
		String passengerCount = request.getParameter("passengerCount");
		
		session.setAttribute("passengerCount", passengerCount);

		// pw.println("Source="+sourcePlace+" Target="+destPlace+"
		// travelDate="+travelDate+" PassCount="+passengerCount);
		Object obj = session.getAttribute("allFlights");
		List<Flights> listOfFlights = (List<Flights>) obj;
		Places availableFlightPlace = new Places();
		for (Flights flightlist : listOfFlights) {
			if ((flightlist.getSource() == Integer.parseInt(sourcePlace))
					&& (flightlist.getDestination() == Integer.parseInt(destPlace))) {

				AvailableFlights availableFlight = new AvailableFlights();
				availableFlight.setFlightNumber(flightlist.getFlightNumber());

				availableFlightPlace = flightlist.getSourcePlace();

				availableFlight.setSourcePlace(availableFlightPlace.getPlacesName());
				availableFlightPlace = flightlist.getDestinationPlace();
				availableFlight.setDestinationPlace(availableFlightPlace.getPlacesName());
				availableFlight.setFlightDate(travelDate);
				availableFlight.setPrice(flightlist.getPrice());
				

				availableFlightList.add(availableFlight);

			}

		}
		if (availableFlightList.size() > 0) {
			session.setAttribute("availableFlightList", availableFlightList);
			
			//pw.println("Matching flights found=" + availableFlightList.size());

			RequestDispatcher rd1 = request.getRequestDispatcher("flightSelection.jsp");
			rd1.forward(request, response);
		}

	}

}
