package org.company.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.company.model.ServletDbModel;
public class ServletDbDao {

	private String url;
	private String user;
	private String password;
	private Connection connection;

	public ServletDbDao(String url,String user,String password){
		this.url = url;
		this.user = user;
		this.password = password;
	}

	protected void connect()throws SQLException {
		if(connection == null || connection.isClosed()) {
			//open connection
			try {
				Class.forName("org.postgresql.Driver");

			}catch(ClassNotFoundException e) {
				throw new SQLException(e);
			}
			connection = DriverManager.getConnection(url, user, password);
		}
	}

	/**
	 * Insert
	 */
	public void ServletDbDaos(ServletDbModel model)throws SQLException {
		connect();	 	
		PreparedStatement statement = null;
		try {

			String sql = "INSERT INTO issue_tracker(issue_id,issue_title,assignee,priority) VALUES(?,?,?,?);"; 		      
			statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getIssueId());
			statement.setString(2, model.getIssueTitle());
			statement.setString(3, model.getAssignee());
			statement.setString(4, model.getPriority());
			statement.executeUpdate();
			System.out.println("insert success");
		}catch (SQLException e) {

		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if(statement!=null) {
					statement.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	/**
	 * Fetch
	 */	
	public List<ServletDbModel> listIssues() throws SQLException {
		List<ServletDbModel> listModel = new ArrayList<>();
		connect();	 	
		Statement statement = null;
		try {
			String sql = "SELECT * FROM issue_tracker;";	
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				Integer issueId = resultSet.getInt("issue_id");
				String issueTitle = resultSet.getString("issue_title");
				String assignee = resultSet.getString("assignee");
				String priority = resultSet.getString("priority");
				ServletDbModel model = new ServletDbModel(issueId, issueTitle, assignee, priority);
				listModel.add(model );                
			}
			System.out.println("fetch success");
		}catch (SQLException e) {

		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if(statement!=null) {
					statement.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return listModel;
	}	
}
