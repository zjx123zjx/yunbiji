package zjx.login.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import zjx.login.entity.Bj;
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
	/*
	 * �½��ʼǱ�
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
	 * ɾ�����±�
	 * @param note
	 * @return
	 */
	public boolean del(Note note) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		System.out.print("ɾ����ѧ�ƣ�"+ note.getSubject1());
		int count = sqlSession.delete("noteNamespace.del", note);
		sqlSession.close();
		if(count == 1){
			System.out.println(" �ɹ�"+"aaaaa");
			return true;
		}else{
			System.out.println(" ʧ��"+"aaaaa");
			return false;
		}
	}
	/**
	 * ���±ʼǱ�
	 * @param note ����û�����ԭ���Ŀ�Ŀ
	 * @param updateSub �µĿ�Ŀ
	 */
	public void update(Note note, String updateSub) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Note note1 = sqlSession.selectOne("noteNamespace.findId", note);
		System.out.println(note.getName1()+note.getSubject1()+"ԭ��");
		System.out.println("�µ�Ϊ�գ�");
        System.out.println(note1.getId1()+"ppppppp");
		//�����û�����ԭ���Ŀ�Ŀ��ѯid
		note.setId1(note1.getId1());
		note.setSubject1(updateSub);
		//����id����
		sqlSession.update("noteNamespace.delete1", note);
		sqlSession.close();
		//System.out.println(count);
	}
	public List<Bj> findNoteById(Note note, HttpSession session) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Note note1 = sqlSession.selectOne("noteNamespace.findId", note);
//		System.out.println(note.getName1() + note.getSubject1());
//		System.out.println(note1.getId1());
		Bj bj = new Bj();
		List<Bj> list = new ArrayList<Bj>();
		bj.setNid1(note1.getId1());
		session.setAttribute("foreignKey", note1.getId1());
		list = sqlSession.selectList("noteNamespace.findBj", bj);
		sqlSession.close();
		return list;
	}
	
}





