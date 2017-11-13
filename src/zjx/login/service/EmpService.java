package zjx.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import zjx.login.dao.EmpDao;
import zjx.login.entity.Emp;
import zjx.login.entity.Note;


/**
 * ҵ���
 * ʵ����
 * @author AdminTC
 */
public class EmpService {
	private EmpDao empDao;
	private Emp user;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	public boolean login(Emp emp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		user = empDao.login(emp);
		if(user == null){
			request.setAttribute("error", "�û���������");
			return false;
		}else{
			if(user.getPassword().equals(emp.getPassword())){
				request.setAttribute("user", user);
				return true;
			}
			request.setAttribute("error", "���û�����Ӧ�����벻��ȷ");
			return false;
		}
	}

	public void findAllSubjects(Emp ee, HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<Note> list = empDao.findAllSubjects(ee);
		if(list.size() > 0){
			request.setAttribute("notesList", list);
			//System.out.println(list.size());
			return ;
		}else{
			//System.out.println("++++++++++++++");
			List<Note> l = new ArrayList<Note>(); 
			request.setAttribute("notesList", l);
			//System.out.println(list.size());
			return ;
		}
	}
}







