package zjx.note.service;

import javax.servlet.http.HttpSession;

import zjx.login.entity.Bj;
import zjx.note.dao.BjDao;

public class BjService {

	private BjDao bjDao;
	public void setBjDao(BjDao bjDao) {
		this.bjDao = bjDao;
	}
	public void create(String createBjName, String neirong, HttpSession session) {
		// TODO Auto-generated method stub
		//·â×°Bj
		Bj bj = new Bj();
		bj.setName1(createBjName);
		bj.setNid1((Integer)session.getAttribute("foreignKey"));
		bj.setContent1(neirong);
		bjDao.create(bj);
	}
	public void del(int id) {
		// TODO Auto-generated method stub
		bjDao.del(id);
	}

}
