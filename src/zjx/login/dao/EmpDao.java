package zjx.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import zjx.login.entity.Emp;

/**
 * 持久层
 * 实现类
 * @author AdminTC
 */
public class EmpDao {
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public void login(Emp emp) {
		// TODO Auto-generated method stub
		System.out.println("之前"+emp.getName()+emp.getPassword());
		SqlSession sqlSession = sqlSessionFactory.openSession();
		emp = sqlSession.selectOne("empNamespace.login",emp);
		System.out.println("daodaoll");
		System.out.println("之后"+emp.getName()+emp.getPassword());
	}
	
}





