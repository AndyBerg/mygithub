/**
 * 
 */
package maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {
	private static Connection conn;
	private static final String DRIVER = "com.mysql.jdbc.Driver"; //定义驱动
	private static final String URL = "jdbc:mysql://localhost:3306/aa"; //定义连接的数据库
	private static final String USERNAME = "root"; //定义用户名
	private static final String PASSWORD = "123456"; //定义密码
	
	static{
		try {
			Class.forName(DRIVER); //加载驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){ //得到数据库连接
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConn(Connection conn){//关闭Connection
		try {
			if(conn !=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closePt(PreparedStatement pt){//关闭PreparedStatement
		try {
			if(pt !=null){
				pt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeRs(ResultSet rs){//关闭ResultSet
		try {
			if(rs !=null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
