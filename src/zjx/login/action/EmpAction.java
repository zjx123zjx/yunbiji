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
 * ����
 * ������
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
	 * ��¼����
	 */
	@RequestMapping(value="/login")
	public String login(Emp emp, HttpServletRequest request) throws Exception{
		//����ҵ���
		//System.out.println("Action");
		boolean b = empService.login(emp,request);
		if(b == true){
			Emp ee = (Emp)request.getAttribute("user");
			System.out.println(ee.getName()+"�ɹ��ĵ�½��ϵͳ��");
			return "/emp/bjb.action";
		}else{
			System.out.println("false");
			return "/login.jsp";
		}
	}
	
	/**
	 * �ʼǱ�����
	 */
	
	@RequestMapping(value="/bjb")
	public String bjb(HttpServletRequest request){
		Emp ee = (Emp) request.getAttribute("user");
		empService.findAllSubjects(ee,request);
		return "/jsp1/bjb.jsp";
	}
	
}







