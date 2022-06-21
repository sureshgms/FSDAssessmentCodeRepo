package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Users;
import com.service.ChangePassword;

/**
 * Servlet implementation class ChangePasswordController
 */
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordController() {
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
	//	doGet(request, response);
		HttpSession session = request.getSession();
		String currentSessionPassword = (String)session.getAttribute("currentSessionPassword");
		Users currUser = (Users) session.getAttribute("userObj");
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newpassword");
		String confirmNewPassword = request.getParameter("confirmnewpassword");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		if(!currentSessionPassword.equals(currentPassword)) { // Check if current password is correct
			pw.println("Current password in Incorrect. Try Again");
		} else if ( !newPassword.equals(confirmNewPassword)) { // Check if new and confirm pwd are matching
			pw.println("New Password is not matching. Try Again");
		} else { // If both above checks pass, then
			ChangePassword cp = new ChangePassword();
			
			if (cp.changePwd(currUser, confirmNewPassword).equals("PasswordChangeSuccessfull")) { // Pass the current User object and new Password
				pw.println("Password Changed successfully...");
			} else {
				pw.println("Password Change failed...");
			}
				
		}
		// Go back to home page
		RequestDispatcher rd1 = request.getRequestDispatcher("AdminPage.jsp");
		rd1.include(request, response);
		
	}

}
