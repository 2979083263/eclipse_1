package jdbc_1connecttest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.mConnection;
import util.union;

/**
* @author 刘春阳
* @version 创建时间：2020年9月3日 上午11:26:13
* @Description 类描述
*/

public class updates {
	public static void main(String[] args) throws Exception{
		String sql = "insert into customers(name,email,birth) values(?,?,?)";
		String name = "pig";
		String email = "qwert.com";
//		SimpleDateFormat sim = new SimpleDateFormat("yy-MM-dd");
//		Date da = sim.parse("20-09-06");
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		
		union.update(sql, name,email,date);
		
	}
}
