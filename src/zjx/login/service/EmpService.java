package zjx.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	/**
	 * ��¼����
	 */
	public boolean login(Emp emp,HttpSession session) {
		// TODO Auto-generated method stub
		user = empDao.login(emp);
		if(user == null){
			//�û���������
			session.setAttribute("error", "�û���������");
			return false;
		}else{
			if(user.getPassword().equals(emp.getPassword())){
				//��½�ɹ������û����浽�������
				session.setAttribute("user", user);
				return true;
			}
			//���벻��ȷ
			session.setAttribute("error", "���û�����Ӧ�����벻��ȷ");
			return false;
		}
	}
	/**
	 * ͨ���û����ұʼǱ��еĿ�Ŀ����
	 */
	public void findAllSubjects(Emp ee, HttpSession session) {
		// TODO Auto-generated method stub
		List<Note> list = empDao.findAllSubjects(ee);
		//������к��ж���
		if(list.size() > 0){
			session.setAttribute("notesList", list);
			//System.out.println(list.size());
			return ;
		}else{
			//System.out.println("++++++++++++++");
			//������в����ж���
			List<Note> l = new ArrayList<Note>(); 
			session.setAttribute("notesList", l);
			//System.out.println(list.size());
			return ;
		}
	}
	public void create(HttpSession session, String createName) {
		// TODO Auto-generated method stub
		//System.out.println("========");
		Emp eee = (Emp) session.getAttribute("user");
		//System.out.println(eee.getName()+eee.getPassword()+"000000");
		String userName = eee.getName();
		//System.out.println(userName+"=userName");
		boolean b = empDao.create(createName,userName);
	}
}







