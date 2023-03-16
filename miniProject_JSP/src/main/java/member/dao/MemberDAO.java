package member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {

	private SqlSessionFactory sqlSessionFactory;	//클래스 안에 있는 모든 객체는 null로 초기화 되어있다.
	private static MemberDAO memberDAO = new MemberDAO();

	public static MemberDAO getInstance() {

		return memberDAO;
	}
	
	

	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("conf/mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public MemberDTO memberLogin(Map map){
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.memberLogin", map);
		sqlSession.close();
		return memberDTO;	
				//여기서 id랑 pwd를 받아와서 select * from member where id=id and pwd=pwd를 거쳐 list에 값을 가지고 오겠지
	}
//	


	public int memberWrite(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		
		int su = sqlSession.insert("memberSQL.memberWrite", memberDTO); //넘길 데이터
		sqlSession.commit();
		sqlSession.close();
		
		
		return su;
	}
	
	
	
	public MemberDTO getMember(String id){ //updateForm.jsp의 memberDAO.getMember(id)의 값을 전달
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.getMember", id);
		sqlSession.close();

		return memberDTO;
	}
//	
//	public void memberUpdate(MemberDTO memberDTO){
//		String sql = "update member set name=?"
//						  			+ ", pwd=?"
//						  			+ ", gender=?"
//						  			+ ", email1=?"
//						  			+ ", email2=?"
//						  			+ ", tel1=?"
//						  			+ ", tel2=?"
//						  			+ ", tel3=?"
//						  			+ ", zipcode=?"
//						  			+ ", addr1=?"
//						  			+ ", addr2=?"
//						  			+ ", logtime=sysdate"
//						  			+ " where id=?";
//		
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memberDTO.getName());
//			pstmt.setString(2, memberDTO.getPwd());
//			pstmt.setString(3, memberDTO.getGender());
//			pstmt.setString(4, memberDTO.getEmail1());
//			pstmt.setString(5, memberDTO.getEmail2());
//			pstmt.setString(6, memberDTO.getTel1());
//			pstmt.setString(7, memberDTO.getTel2());
//			pstmt.setString(8, memberDTO.getTel3());
//			pstmt.setString(9, memberDTO.getZipcode());
//			pstmt.setString(10, memberDTO.getAddr1());
//			pstmt.setString(11, memberDTO.getAddr2());
//			pstmt.setString(12, memberDTO.getId());
//			
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		} finally {
//			MemberDAO.close(conn, pstmt);
//		}
//		
//	}
//	
//	
//	
//	public boolean isExistPwd(String id, String pwd){
//		boolean exist = false;
//		String sql = "select * from member where id=? and pwd=?";
//		
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, pwd);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) exist = true;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MemberDAO.close(conn, pstmt, rs);
//		}
//		
//		return exist;
//	}
//	
//	public void memberDelete(String id) {
//		
//		String sql = "delete member where id=?";
//		
//		
//		
//		try {
//			conn = ds.getConnection();
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			
//			pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		} finally {
//			MemberDAO.close(conn, pstmt);
//		}
//	}
//
	public boolean isExistId(String id) {
		boolean existId = false;
		MemberDTO dto =new MemberDTO();
		
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		dto = sqlSession.selectOne("memberSQL.isExistId", id);
		
		if(dto==null) {
			existId=false;
		}
		else if(dto!=null) {
			existId=true;
		}
		
		sqlSession.close();
		
		return existId;
	}
	

}
