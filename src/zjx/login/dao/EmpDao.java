package zjx.login.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import zjx.login.entity.Bj;
import zjx.login.entity.Emp;
import zjx.login.entity.Note;

/**
 * 持久层
 * 实现类
 * @author AdminTC
 */
public class EmpDao {
	private SqlSessionFactory sqlSessionFactory;
	private Emp user;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	/**
	 * 登录方法
	 */
	public Emp login(Emp emp) {
		// TODO Auto-generated method stub
//		System.out.println("之前"+emp.getName()+emp.getPassword());
		SqlSession sqlSession = sqlSessionFactory.openSession();
		user = sqlSession.selectOne("empNamespace.login",emp);
		sqlSession.close();
		return user;
//		System.out.println("daodaoll");
//		System.out.println("之后"+emp.getName()+emp.getPassword());
	}
	/**
	 * 通过用户名找笔记本中的科目方法
	 */
	public List<Note> findAllSubjects(Emp ee) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Note> list = sqlSession.selectList("noteNamespace.findAllByName",ee);
		//System.out.println((list == null)+"pppppppppp");
		sqlSession.close();
		return list;
	}
	/*
	 * 新建笔记本
	 */
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
	/**
	 * 删除记事本
	 * @param note
	 * @return
	 */
	public boolean del(Note note) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		System.out.print("删除的学科："+ note.getSubject1());
		int count = sqlSession.delete("noteNamespace.del", note);
		sqlSession.close();
		if(count == 1){
			System.out.println(" 成功"+"aaaaa");
			return true;
		}else{
			System.out.println(" 失败"+"aaaaa");
			return false;
		}
	}
	/**
	 * 更新笔记本
	 * @param note 存放用户名和原来的科目
	 * @param updateSub 新的科目
	 */
	public void update(Note note, String updateSub) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Note note1 = sqlSession.selectOne("noteNamespace.findId", note);
		System.out.println(note.getName1()+note.getSubject1()+"原来");
		System.out.println("新的为空？");
        System.out.println(note1.getId1()+"ppppppp");
		//根据用户名和原来的科目查询id
		note.setId1(note1.getId1());
		note.setSubject1(updateSub);
		//根据id更新
		sqlSession.update("noteNamespace.delete1", note);
		sqlSession.close();
		//System.out.println(count);
	}
	public List<Bj> findNoteById(Note note) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Note note1 = sqlSession.selectOne("noteNamespace.findId", note);
		System.out.println(note.getName1() + note.getSubject1());
		System.out.println(note1.getId1());
		Bj bj = new Bj();
		List<Bj> list = new ArrayList<Bj>();
		bj.setNid1(note1.getId1());
		list = sqlSession.selectList("noteNamespace.findBj", bj);
		sqlSession.close();
		return list;
	}
	
}





