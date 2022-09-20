package org.ar.genericUtility;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import com.mysql.cj.jdbc.Driver;

	public class DataBaseUtility {
		private Connection connection;
		/**
		 * this method is used to get connection to the database 
		 * @param url
		 * @param Db_un
		 * @param Db_pwd
		 * @return
		 */
		public Connection getConnection(String url,String Db_un,String Db_pwd )
		{
			Driver dbdriver=null;
			try {
				dbdriver = new Driver();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//step2--> register the driver instance to the jdbc
			try {
				DriverManager.registerDriver(dbdriver);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//step3--> get/establish the database connection
			try {
				connection = DriverManager.getConnection(url, Db_un, Db_pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		
		/**
		 * this method is used to get data from database
		 * @param query
		 * @param colname
		 * @return
		 */
		public List<String> getDataFromDb(String query, String colname)
		{
			Statement statement=null;
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//step5--> execute the query 
			ResultSet result=null;
			try {
				result = statement.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			List<String> arr = new ArrayList<String>();
		    //step6-->verify or iterate or fetch the data
			try {
				while(result.next()) {
				arr.add(result.getString(colname));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return arr;
		}
		
		/**
		 * this method is used to close the connection of database
		 */
		public void closeConnection()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * this method is used to validate the database data with expected value
		 * @param query1
		 * @param colname1
		 * @param expectedvalue
		 * @return
		 */
		public boolean verifyDataInsideDatabase(String query1, String colname1, String expectedvalue)
		{
			List<String> arr = getDataFromDb(query1, colname1);
			boolean flag=false;
			for(String s:arr)
			{
				if(s.equalsIgnoreCase(expectedvalue))
				{
					flag=true;
					break;
				}
			}
			return flag;
			
		}
		
		public void setDataToDataBase(String query1)
		{
			Statement statement=null;
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			int result=0;
			try {
				result = statement.executeUpdate(query1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(result==1) {
				System.out.println(result+"dataupdated succesfully");
			}
		}
		
	}



