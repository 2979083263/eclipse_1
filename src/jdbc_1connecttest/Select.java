package jdbc_1connecttest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.SelectAl;
import util.mConnection;

/**
* @author 刘春阳
* @version 创建时间：2020年9月6日 上午9:26:16
* @Description 数据库查询
*/

public class Select {
	public static void main(String[] args) throws Exception{
//		Connection con = mConnection.mconnection();
//		
//		String sql = "select id,name,email,birth from customers where id = ?";
//		PreparedStatement pre = con.prepareStatement(sql);
//		
//		pre.setInt(1, 1);
//		
//		ResultSet res = pre.executeQuery();
//		
//		if(res.next()) {
//			int id = res.getInt(1);
//			String name = res.getString(2);
//			String email = res.getString(3);
//			Date date = res.getDate(4);
//			Customer cus = new Customer(id,name,email,date);
//			System.out.println(cus.toString());
		
		String sql = "select id,name,email,birth from customers where id=?";
		SelectAl sea = new SelectAl();
		Customer cus = sea.selecttest(sql, 13);
		System.out.println(cus);
	}
}