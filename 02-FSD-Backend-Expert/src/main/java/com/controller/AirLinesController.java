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

import com.bean.Airlines;
import com.bean.Places;
import com.service.AirlineSetupService;
import com.service.PlaceSetupService;

/**
 * Servlet implementation class AirLinesController
 */
public class AirLinesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirLinesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd1 = request.getRequestDispatcher("Airlines.jsp");
		
		String airlineName = request.getParameter("airlineName");
		AirlineSetupService ass = new AirlineSetupService();
		Airlines newAirline = new Airlines();
		newAirline.setAirlineName(airlineName);
		String airlineSetupReturnVal;
		HttpSession session = request.getSession();
		try {
			airlineSetupReturnVal = ass.newAirlineSetup(newAirline);
		
			if (airlineSetupReturnVal.equals("AirlineSavedSuccessfully")) {
				AirlineSetupService ass1 = new AirlineSetupService();
				List<Airlines> listOfAirlines = ass1.getAllAirlinesService();
				session.setAttribute("allAirlines", listOfAirlines);
				pw.println("Airline Saved Successfully");
				rd1.include(request, response);
			} else if (airlineSetupReturnVal.equals("uniqueConstraintException")) {
				pw.println("Airline could not be saved !");
			}
		} catch (ConstraintViolationException cve) {
			// TODO Auto-generated catch block
			pw.println("Airline already Exists");
		}
	}

}
