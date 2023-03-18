package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.bean.MemberDTO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static MemberDAO memberDAO = new MemberDAO();

	public static MemberDAO getInstance() {
		
		return memberDAO;
	}

	public MemberDAO() {
		
		try {
			Reader reader = Resources.getResourceAsReader("conf/mybatis-config.xml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public MemberDTO memberLogin(Map map) {
		//DB연결
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.memberLogin", map);
		sqlSession.close();
		
		return memberDTO;
		
	}
	
}
