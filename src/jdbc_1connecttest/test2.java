package jdbc_1connecttest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import util.mConnection;

/**
* 
*/
public class test2 {
	public static void main(String[] args) throws Exception{
		
		Connection con = mConnection.mconnection();
		
		String sql = "insert into customers(name,email,birth) values(?,?,?)";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(sql);
			
			pre.setString(1, "qwe");
			pre.setString(2, "hu");
			
			SimpleDateFormat sim = new SimpleDateFormat("yy-MM-dd");
			Date date = sim.parse("78-04-30");
			
			pre.setDate(3, new java.sql.Date(date.getTime()));
			
			pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		
		mConnection.closeConnection(con, pre);
	}
}
