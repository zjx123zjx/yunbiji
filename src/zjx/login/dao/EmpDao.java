package zjx.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import zjx.login.entity.Emp;

/**
 * �־ò�
 * ʵ����
 * @author AdminTC
 */
public class EmpDao {
	private SqlSessionFactory sqlSessionFactory;
	private Emp user;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public Emp login(Emp emp) {
		// TODO Auto-generated method stub
//		System.out.println("֮ǰ"+emp.getName()+emp.getPassword());
		SqlSession sqlSession = sqlSessionFactory.openSession();
		user = sqlSession.selectOne("empNamespace.login",emp);
		return user;
//		System.out.println("daodaoll");
//		System.out.println("֮��"+emp.getName()+emp.getPassword());
	}
	
}





