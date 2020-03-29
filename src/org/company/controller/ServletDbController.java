package org.company.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.company.dao.ServletDbDao;
import org.company.model.ServletDbModel;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServletDbController
 */
@WebServlet("/ServletDbController")
public class ServletDbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletDbModel model;
	private ServletDbDao dao;

	public ServletDbController(){

	}

	public void init() {
		String url = getServletContext().getInitParameter("url");
		String user = getServletContext().getInitParameter("user");
		String password = getServletContext().getInitParameter("password");
		dao = new ServletDbDao(url,user,password);		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			//String title = dao.title(issueIdOne);
			response.setContentType("text/plain"); 	
			List<ServletDbModel> list = dao.listIssues();
			Gson gson = new Gson();
			String json = gson.toJson(list);			
			response.getWriter().write(json); 		     
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String issueTitle = request.getParameter("issueInput");
		String assignee = request.getParameter("assigneeInput");
		String priority = request.getParameter("priorityInput");
		String issueIn = request.getParameter("idInput");
		Integer issueId =  Integer.parseInt(issueIn);
		model = new ServletDbModel(issueId, issueTitle,assignee,priority);
		//ServletDbDao dao = new ServletDbDao();
		try {
			dao.ServletDbDaos(model);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
