package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
* @author 刘春阳
* @version 创建时间：2020年9月5日 下午6:48:12
* @Description 类描述
*/
public class union {
	public static void update(String sql , Object...data){
		Connection con = null;
		PreparedStatement prea = null;
		try {
			con = mConnection.mconnection();
			prea = con.prepareStatement(sql);
			
			for(int i=1;i<=data.length;i++){
				prea.setObject(i, data[i-1]);	
			}
			
			prea.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			mConnection.closeConnection(con, prea);
			System.out.println("over");
		}
	}
}