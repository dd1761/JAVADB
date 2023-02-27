package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	
	public MemberDAO() {
		try {
			Class.forName(driver); //Class타입으로 생성
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		//접속은 한번만 하는것이 아니기 때문에 생성자에서 하면 안됨.
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,username,password);/*오라클 드라이버*/
			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void memberWrite() {
		String sql = "insert";
	}

}
