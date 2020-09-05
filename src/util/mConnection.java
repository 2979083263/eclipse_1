package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
* @author 刘春阳
* @version 创建时间：2020年9月3日 上午10:40:45
* @Description 获取数据库连接
*/

public class mConnection {
	
	public static Connection mconnection() throws Exception{
		InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		Properties pro = new Properties();
		
		pro.load(input);

		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		String driverclass = pro.getProperty("driverclass");
		
		Class.forName(driverclass);
		
		Connection con = DriverManager.getConnection(url,user,password);
		
		return con;
	}
	
	public static void closeConnection(Connection c , Statement s) {
		try {
			if(c != null)
				c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			if(s != null)
				c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
