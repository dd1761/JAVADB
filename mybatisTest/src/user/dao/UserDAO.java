package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;	//sqlSession을 만들기 위해 만듬.

	public UserDAO() {
		InputStream inputStream;
		try {
			//Reader reader = Resources.getResourceAsReader("mybatis-config.xml");//추상클래스여서 직접적으로 new 할 수 없다.
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		
		sqlSession.insert("userSQL.write", userDTO); //넘길 데이터
		sqlSession.commit();
		sqlSession.close();
		
	}

}

