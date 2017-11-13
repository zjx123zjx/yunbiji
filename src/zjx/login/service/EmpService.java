package zjx.login.service;

import javax.servlet.http.HttpServletRequest;

import zjx.login.dao.EmpDao;
import zjx.login.entity.Emp;


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
	
	public boolean login(Emp emp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		user = empDao.login(emp);
		if(user == null){
			request.setAttribute("error", "用户名不存在");
			return false;
		}else{
			if(user.getPassword().equals(emp.getPassword())){
				request.setAttribute("user", user);
				return true;
			}
			request.setAttribute("error", "此用户名对应的密码不正确");
			return false;
		}
	}
}







