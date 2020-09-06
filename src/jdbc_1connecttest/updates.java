package jdbc_1connecttest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.mConnection;

/**
* @author 刘春阳
* @version 创建时间：2020年9月3日 上午11:26:13
* @Description 类描述
*/

public class updates {
	public static void main(String[] args){
		Connection con = null;
		PreparedStatement pew = null;
		try {
			con = mConnection.mconnection();
			String sql = "delete from customers where id = ?";
			PreparedStatement prs = con.prepareStatement(sql);
			prs.setInt(1, 2);
			prs.execute();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			mConnection.closeConnection(con, pew);
		}
	}
}
