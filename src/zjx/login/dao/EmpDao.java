package zjx.login.dao;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import zjx.login.entity.Emp;
import zjx.login.entity.Note;

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
	/**
	 * ��¼����
	 */
	public Emp login(Emp emp) {
		// TODO Auto-generated method stub
//		System.out.println("֮ǰ"+emp.getName()+emp.getPassword());
		SqlSession sqlSession = sqlSessionFactory.openSession();
		user = sqlSession.selectOne("empNamespace.login",emp);
		sqlSession.close();
		return user;
//		System.out.println("daodaoll");
//		System.out.println("֮��"+emp.getName()+emp.getPassword());
	}
	/**
	 * ͨ���û����ұʼǱ��еĿ�Ŀ����
	 */
	public List<Note> findAllSubjects(Emp ee) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Note> list = sqlSession.selectList("noteNamespace.findAllByName",ee);
		//System.out.println((list == null)+"pppppppppp");
		sqlSession.close();
		return list;
	}
	public boolean create(String createName, String userName) {
		// TODO Auto-generated method stub
		//System.out.println(createName+userName+"[[[[[[[[[[");
		Note n = new Note();
		n.setName1(userName);
		n.setSubject1(createName);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("noteNamespace.create",n);
//		System.out.println("success!");
		sqlSession.close();
		return false;
	}
	
}





