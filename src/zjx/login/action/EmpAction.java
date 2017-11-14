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
	public String login(Emp emp,HttpSession session) throws Exception{
		//����ҵ���
		//System.out.println("Action");
		boolean b = empService.login(emp,session);
		if(b == true){
			Emp ee = (Emp)session.getAttribute("user");
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
	public String bjb(HttpSession session){
		Emp ee = (Emp) session.getAttribute("user");
		empService.findAllSubjects(ee,session);
		return "/jsp1/bjb.jsp";
	}
	@RequestMapping(value="/create")
	public String create(HttpServletRequest request,HttpSession session){
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
	
}







