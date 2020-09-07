package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.lang.reflect.Field;

import jdbc_1connecttest.Customer;

/**
* @author 刘春阳
* @version 创建时间：2020年9月6日 上午11:27:54
* @Description 类描述
*/
public class SelectAl {
	public Customer selecttest(String sql,Object...data){
		Connection con =null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			con = mConnection.mconnection();
			pre = con.prepareStatement(sql);
			for(int i=0;i<data.length;i++) {
				pre.setObject(i+1, data[i]);
			}
			
			res = pre.executeQuery();
			ResultSetMetaData rsmd = res.getMetaData();
			int length = rsmd.getColumnCount();
			if(res.next()) {
				Customer com = new Customer();
				for(int i=0;i<length;i++) {
					Object columValue = res.getObject(i+1);
					String columName = rsmd.getColumnName(i+1);
					
					Field field = Customer.class.getDeclaredField(columName);
					field.setAccessible(true);
					field.set(com, columValue);
				}
				return com;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			mConnection.closeConnection(con, pre, res);
		}
		return null;
	}
}
