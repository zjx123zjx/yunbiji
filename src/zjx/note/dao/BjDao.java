package zjx.note.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import zjx.login.entity.Bj;

public class BjDao {
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	

	public void create(Bj bj) {
//		System.out.println(bj.getNid1());
//		System.out.println(bj.getName1());	
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.insert("noteNamespace.createBj", bj);
		System.out.println(count);
		sqlSession.close();
	}
}
