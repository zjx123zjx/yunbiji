package zjx.note.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zjx.login.entity.Bj;
import zjx.note.service.BjService;
import zjx.util.Util;

@RequestMapping(value="/bj")
@Controller
public class BjAction {
	private BjService bjService;
	@Resource(name="bjServiceID")
	public void setBjService(BjService bjService) {
		this.bjService = bjService;
	}
	
	/**
	 * 创建笔记
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/create")
	public String create(HttpServletRequest request,HttpSession session){
		//获取笔记名称及内容
		String createBjName = request.getParameter("createBjName");
		String neirong = request.getParameter("neirong");		
		createBjName = Util.convert(createBjName);
		neirong = Util.convert(neirong);
		bjService.create(createBjName,neirong,session);
		return "/emp/bjb.action";
	}
	@RequestMapping(value="/del")
	public String del(HttpServletRequest request){
		String hidd = request.getParameter("hidd");
		int id = Integer.parseInt(hidd);
		bjService.del(id);
		return "/jsp1/bjb.jsp";
	}
	@RequestMapping(value="/cxBj")
	public String cxBj(HttpServletRequest request,HttpSession session){
		String str = request.getParameter("id");
		str = Util.convert(str);
		int id = Integer.parseInt(str);
		String str1 = bjService.cxBj(id);
		session.setAttribute("str1", str1);
		return "/jsp1/content.jsp";
	}
	
	@RequestMapping(value="/upBj")
	public String upBj(HttpServletRequest request,HttpSession session){
		String str = request.getParameter("id");
		str = Util.convert(str);
		int id = Integer.parseInt(str);
		String str1 = bjService.cxBj(id);
		session.setAttribute("str2", str1);
		session.setAttribute("s", id);
		return "/jsp1/up.jsp";
	}
	
	@RequestMapping(value="/save")
	public String save(HttpServletRequest request,HttpSession session){
		String str = request.getParameter("c");
		int i = (Integer)session.getAttribute("s");
		Bj bj = new Bj();
		bj.setId1(i);
		bj.setContent1(str);
		bjService.save(bj);
		return "/jsp1/bj.jsp";
	}
}
