package zjx.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import zjx.login.dao.EmpDao;
import zjx.login.entity.Bj;
import zjx.login.entity.Emp;
import zjx.login.entity.Note;


/**
 * 业务层
 * 实现类
 * @author AdminTC
 */
public class EmpService {
	private EmpDao empDao;
	private Emp user;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	/**
	 * 登录方法
	 */
	public boolean login(Emp emp,HttpSession session) {
		// TODO Auto-generated method stub
		user = empDao.login(emp);
		if(user == null){
			//用户名不存在
			session.setAttribute("error", "用户名不存在");
			return false;
		}else{
			if(user.getPassword().equals(emp.getPassword())){
				//登陆成功，将用户保存到域对象中
				session.setAttribute("user", user);
				return true;
			}
			//密码不正确
			session.setAttribute("error", "此用户名对应的密码不正确");
			return false;
		}
	}
	/**
	 * 通过用户名找笔记本中的科目方法
	 */
	public void findAllSubjects(Emp ee, HttpSession session) {
		// TODO Auto-generated method stub
		List<Note> list = empDao.findAllSubjects(ee);
		//结果集中含有对象
		if(list.size() > 0){
			session.setAttribute("notesList", list);
			//System.out.println(list.size());
			return ;
		}else{
			//System.out.println("++++++++++++++");
			//结果集中不含有对象
			List<Note> l = new ArrayList<Note>(); 
			session.setAttribute("notesList", l);
			//System.out.println(list.size());
			return ;
		}
	}
	/**
	 * 新建笔记本方法
	 * @param session
	 * @param createName（学科名）
	 */
	public void create(HttpSession session, String createName) {
		// TODO Auto-generated method stub
		//System.out.println("========");
		Emp eee = (Emp) session.getAttribute("user");
		//System.out.println(eee.getName()+eee.getPassword()+"000000");
		String userName = eee.getName();
		//System.out.println(userName+"=userName");
		boolean b = empDao.create(createName,userName);
	}
	/**
	 * 删除记事本
	 * @param sub
	 * @param session
	 * @return
	 */
	public boolean del(String sub, HttpSession session) {
		// TODO Auto-generated method stub
		Note note = new Note();
		String name = ((Emp)(session.getAttribute("user"))).getName();
		note.setName1(name);
		note.setSubject1(sub);
		boolean b = empDao.del(note);
		return b;
	}
	/**
	 * 更新笔记本
	 * @param updateSub
	 * @param session
	 */
	public void update(String updateSub, HttpSession session) {
		// TODO Auto-generated method stub
		Note note = new Note();
		//获取原来的数据
		String oldSub = (String)session.getAttribute("upSub");
		//获取用户名
		String name = ((Emp)(session.getAttribute("user"))).getName();
		note.setName1(name);
		note.setSubject1(oldSub);
		empDao.update(note,updateSub);
	}
	public boolean findNoteById(Note note, HttpSession session) {
		// TODO Auto-generated method stub
		List<Bj> list = empDao.findNoteById(note,session);
		session.setAttribute("bjlist", list);
		return true;
	}
}







