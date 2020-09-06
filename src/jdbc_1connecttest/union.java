package jdbc_1connecttest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.mConnection;

/**
* @author 刘春阳
* @version 创建时间：2020年9月5日 下午6:48:12
* @Description 类描述
*/
public class union {
	private Connection con;
	private PreparedStatement prea;
	
	public void update(String sql , Object...data){
		try {
			con = mConnection.mconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prea = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=1;i<=data.length;i++){
			try {
				prea.setObject(i, data[i-1]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			prea.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mConnection.closeConnection(con, prea);
		
	}
}