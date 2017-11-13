package zjx.login.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	public String login(Emp emp, HttpServletRequest request) throws Exception{
		//调用业务层
		//System.out.println("Action");
		boolean b = empService.login(emp,request);
		if(b == true){
			Emp ee = (Emp)request.getAttribute("user");
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
	public String bjb(HttpServletRequest request){
		Emp ee = (Emp) request.getAttribute("user");
		empService.findAllSubjects(ee,request);
		return "/jsp1/bjb.jsp";
	}
	
}







