package zjx.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import zjx.login.dao.EmpDao;
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
	public boolean login(Emp emp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		user = empDao.login(emp);
		if(user == null){
			//用户名不存在
			request.setAttribute("error", "用户名不存在");
			return false;
		}else{
			if(user.getPassword().equals(emp.getPassword())){
				//登陆成功，将用户保存到域对象中
				request.setAttribute("user", user);
				return true;
			}
			//密码不正确
			request.setAttribute("error", "此用户名对应的密码不正确");
			return false;
		}
	}
	/**
	 * 通过用户名找笔记本中的科目方法
	 */
	public void findAllSubjects(Emp ee, HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<Note> list = empDao.findAllSubjects(ee);
		//结果集中含有对象
		if(list.size() > 0){
			request.setAttribute("notesList", list);
			//System.out.println(list.size());
			return ;
		}else{
			//System.out.println("++++++++++++++");
			//结果集中不含有对象
			List<Note> l = new ArrayList<Note>(); 
			request.setAttribute("notesList", l);
			//System.out.println(list.size());
			return ;
		}
	}
}







