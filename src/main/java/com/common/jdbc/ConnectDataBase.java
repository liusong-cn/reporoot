package com.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDataBase {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.43.95:1521:orcl", "ids", "glaway123");
		Statement st = c.createStatement();
		ResultSet rt = st.executeQuery("select * from t_s_base_user ");
		while (rt.next()) {
			System.out.println(rt.getString("userName") + rt.getString("id"));
		}
	}
}
