package zjx.login.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zjx.login.entity.Emp;
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
	 * 注册员工
	 */
	@RequestMapping(value="/login")
	public String login(Emp emp) throws Exception{
		//调用业务层
		//System.out.println("Action");
		empService.login(emp);
		
		return "success";
	}
}







