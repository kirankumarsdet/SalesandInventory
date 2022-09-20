
package org.altairretro.accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateNewUserAccount {

	public static void main(String[] args) throws SQLException {
		//reate object for driver
		Driver dbdriver = new Driver();
		// register the driver instance to jdbc
		DriverManager.registerDriver(dbdriver);
		//establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		try {
			// create the statement
			Statement statement = connection.createStatement();
			//executethe query
			ResultSet result = statement.executeQuery("select * from sdet40;");
			while (result.next()) {
				System.out.println(result.getString("emp_name"));
			}
		} finally {
			connection.close();

		}
	}

}
