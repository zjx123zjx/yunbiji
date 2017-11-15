package zjx.login.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zjx.login.entity.Emp;
import zjx.login.entity.Note;
import zjx.login.service.EmpService;

/**
 * 单例
 * 控制器
 * @author AdminTC
 */
@Controller
@RequestMapping(value="/emp")
public class EmpAction {
	private EmpService empService;
	@Resource(name="empServiceID")
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	/**
	 * 登录方法
	 */
	@RequestMapping(value="/login")
	public String login(Emp emp,HttpSession session) throws Exception{
		//调用业务层
		//System.out.println("Action");
		boolean b = empService.login(emp,session);
		if(b == true){
			Emp ee = (Emp)session.getAttribute("user");
			System.out.println(ee.getName()+"成功的登陆了系统！");
			return "/emp/bjb.action";
		}else{
			System.out.println("false");
			return "/login.jsp";
		}
	}
	
	/**
	 * 笔记本方法
	 */
	
	@RequestMapping(value="/bjb")
	public String bjb(HttpSession session){
		Emp ee = (Emp) session.getAttribute("user");
		empService.findAllSubjects(ee,session);
		return "/jsp1/bjb.jsp";
	}
	/*
	 * 新建笔记本
	 */
	
	@RequestMapping(value="/create")
	public String create(HttpServletRequest request,HttpSession session){
		//接收数据及转码
		String createName = request.getParameter("createName");
		try {
			createName = new String(createName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(createName+"createName");
		empService.create(session,createName);
		return "/emp/bjb.action";
	}
	/**
	 * 删除记事本
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/del")
	public String del(HttpServletRequest request,HttpSession session){
		System.out.println("===========++");
		String sub = (String) request.getParameter("sub");
		try {
			sub = new String(sub.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empService.del(sub,session);
		System.out.println("true");
		return "/emp/bjb.action";
	}
	/**
	 * 更新笔记本
	 * @param session
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/update")
	public String update(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException{
		//获得输入
		String updateSub = (String)request.getParameter("updateSub");
		updateSub = new String(updateSub.getBytes("ISO-8859-1"),"utf-8");
		empService.update(updateSub,session);
		return "/emp/bjb.action";
	}
	@RequestMapping(value="/findNoteById")
	public String findNoteById(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		String cxSub = request.getParameter("cxSub");
		String cxName = request.getParameter("cxName");
		cxSub = new String(cxSub.getBytes("ISO-8859-1"),"utf-8");
		cxName = new String(cxName.getBytes("ISO-8859-1"),"utf-8");
		Note note = new Note();
		note.setName1(cxName);
		note.setSubject1(cxSub);
		boolean b = empService.findNoteById(note,session);
		return "/jsp1/bj.jsp?foreign="+session.getAttribute("foreignKey"); 
	}
	
	
	
	
}







