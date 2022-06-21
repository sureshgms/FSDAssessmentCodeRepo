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

import org.hibernate.exception.ConstraintViolationException;

import com.bean.Places;
import com.service.PlaceSetupService;

/**
 * Servlet implementation class PlaceSetupController
 */
public class PlaceSetupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceSetupController() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	PlaceSetupService ps = new PlaceSetupService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		List<Places> listOfPlaces = ps.getAllPlacesService();
		hs.setAttribute("allPlaces", listOfPlaces);
		RequestDispatcher rd1 = request.getRequestDispatcher("Places.jsp");
		String placeName = request.getParameter("placename");
		PlaceSetupService pss = new PlaceSetupService();
		Places newPlace = new Places();
		newPlace.setPlacesName(placeName);
		String placeSetupReturnVal;

		try {
			placeSetupReturnVal = pss.newPlaceSetup(newPlace);
			if (placeSetupReturnVal.equals("placeSavedSuccessfully")) {
				// Code to pre-populate table data for Flights setup LOV fields
				HttpSession session = request.getSession();
				PlaceSetupService ps = new PlaceSetupService();
				List<Places> listOfPlaces1 = ps.getAllPlacesService();
				session.setAttribute("allPlaces", listOfPlaces1);
				pw.println("Place Saved Successfully");
				rd1.include(request, response);
			} else if (placeSetupReturnVal.equals("uniqueConstraintException")) {
				pw.println("Place could not be saved !");
			}
		} catch (ConstraintViolationException cve) {
			// TODO Auto-generated catch block
			pw.println("Place already Exists");
		}

	}

}
