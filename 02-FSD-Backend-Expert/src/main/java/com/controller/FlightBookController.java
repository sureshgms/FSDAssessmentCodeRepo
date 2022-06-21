package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FlightBookController
 */
@WebServlet("/FlightBookController")
public class FlightBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightBookController() {
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
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		//String selectFlight = request.getParameter("selectedFlight");
		//pw.println(request.getParameter("selectedFlight"));
		
		String[] flightDtlsArray = request.getParameter("selectedFlight").split("\\|");
		Object obj2 = session.getAttribute("passengerCount");
		String passCountStr = (String) obj2;
		int passCount = Integer.parseInt(passCountStr);
		

		flightDtlsArray[flightDtlsArray.length-1] = String.valueOf(passCount * Float.parseFloat(flightDtlsArray[flightDtlsArray.length-1]));
		
		session.setAttribute("flightDtlsArray", flightDtlsArray);
		session.setAttribute("passFirstName", request.getParameter("passFirstName"));
		session.setAttribute("passLastName", request.getParameter("passLastName"));
		session.setAttribute("passGender", request.getParameter("passGender"));
		session.setAttribute("passAge", request.getParameter("passAge"));
		session.setAttribute("passMobileNumber", request.getParameter("passMobileNumber"));
		session.setAttribute("ccNumber", request.getParameter("ccNumber"));
		session.setAttribute("ccName", request.getParameter("ccName"));
		session.setAttribute("ccExpiry", request.getParameter("ccExpiry"));
		session.setAttribute("ccCvv", request.getParameter("ccCvv"));
		
		
		RequestDispatcher rd1 = request.getRequestDispatcher("FinalConfirmation.jsp");
		rd1.forward(request, response);
	}

}
