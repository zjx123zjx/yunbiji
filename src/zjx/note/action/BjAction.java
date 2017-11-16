package zjx.note.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
