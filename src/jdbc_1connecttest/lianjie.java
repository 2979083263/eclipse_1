package jdbc_1connecttest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import util.mConnection;

/**
* @author 刘春阳
* @version 创建时间：2020年8月4日 下午3:48:54
* @Description 数据库连接
*/
public class lianjie {
	public static void main(String[]args){

//		Driver driver = new com.mysql.jdbc.Driver();
//		//jdbc:mysql://localhost:3306/数据库名
//		String str = "jdbc:mysql://localhost:3306/test";
//		Properties info = new Properties();
//		info.setProperty("user", "root");
//		info.setProperty("password", "123456");
//		Connection connec = driver.connect(str,info);
//		System.out.println(connec);
		
//		//方式二,利用反射获取Driver对象，其他步骤不变
//		Class clasz = Class.forName("com.mysql.jdbc.Driver");
//		Driver driver = (Driver)clasz.newInstance();
//		//jdbc:mysql://localhost:3306/数据库名
//		String str = "jdbc:mysql://localhost:3306/test";
//		Properties info = new Properties();
//		info.setProperty("user", "root");
//		info.setProperty("password", "123456");
//		Connection connec = driver.connect(str,info);
//		System.out.println(connec);
		
//		//方式三，使用DriverManager
//		Class clasz = Class.forName("com.mysql.jdbc.Driver");
//		Driver driver = (Driver)clasz.newInstance();
//		String url = "jdbc:mysql://localhost:3306/test";
//		String user = "root";
//		String password = "123456";
//		//注册驱动
//		DriverManager.registerDriver(driver);
//		//获取链接
//		Connection connec = DriverManager.getConnection(url, user, password);
//		System.out.println("方式三连接:"+connec);

//		//方式四，3基础上做优化
//		String url = "jdbc:mysql://localhost:3306/test";
//		String user = "root";
//		String password = "123456";
//		
//		//这个语句内部有个静态代码块，会自动调用注册驱动，所以说可以删除一些语句
//		Class.forName("com.mysql.jdbc.Driver");
//		//获取链接
//		Connection connec = DriverManager.getConnection(url, user, password);
//		System.out.println("方式三连接:"+connec);
		
		//方式五，最终版，将4个字符串放在配置文件内
		InputStream input = lianjie.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties pro = new Properties();
		
		try {
			pro.load(input);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		String driverclass = pro.getProperty("driverclass");
		
		try {
			Class.forName(driverclass);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "insert into customers(name,email,birth) values(?,?,?)";	//?为占位符
		try(Connection con = mConnection.mconnection();
			PreparedStatement ps = con.prepareStatement(sql);
		){
			//处理占位符,数据库索引是从1开始，下面的1为索引
			//			索引   值
			ps.setString(1, "hpu");			//名字
			ps.setString(2, "www.123.com");	//邮箱
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse("2000-04-17");
			ps.setDate(3, new Date(date.getTime()));	//生日
			
			//执行代码
			ps.execute();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//增删改查

//		ps.close();
//		con.close();

	}
}
