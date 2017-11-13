package zjx.login.service;

import zjx.login.dao.EmpDao;
import zjx.login.entity.Emp;


/**
 * 业务层
 * 实现类
 * @author AdminTC
 */
public class EmpService {
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	public void login(Emp emp) {
		// TODO Auto-generated method stub
		empDao.login(emp);
	}
}







