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
		//System.out.println(count);
		sqlSession.close();
	}


	public void del(int idd) {
		// TODO Auto-generated method stub
		System.out.println(idd +"  id " );
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.delete("noteNamespace.del1",idd);
		System.out.println("count == "+ count);
		sqlSession.close();
	}


	public String cxBj(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String str = sqlSession.selectOne("noteNamespace.selectContent",id);
		//System.out.println(str);
		sqlSession.close();
		return str;
	}


	public void save(Bj bj) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.update("noteNamespace.save",bj);
		System.out.println(count);
		sqlSession.close();
	}
}
