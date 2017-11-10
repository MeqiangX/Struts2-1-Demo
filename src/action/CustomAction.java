package action;


import java.util.List;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import bean.Custom;
import bean.User;
import service.CustomService;

public class CustomAction extends ActionSupport{
    private Custom custom;
    
	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	
	public String execute() throws Exception{
		
		return null;
	}
    
	public String Login() {
		
		CustomService cs = new CustomService();
		User user = new User(custom.getUsername(),custom.getPassword());
		if (cs.Login(user)) {
			Map session = ActionContext.getContext().getSession();
			session.put("user", user);
			return "loginsuccess";
		}
		this.addFieldError("custom.username", "用户不存在或者密码错误！");
		return "input";
	}
	
	public String Register() {
		CustomService cs = new CustomService();
		if (cs.Register(custom)) {
			return "registersuccess";
		}
		return "input";
	}
	
	public String getAll(){
		
		CustomService cs = new CustomService();
		List<Custom> list = cs.getAll();
		System.out.println(list.size());
		//获得值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		//将用户List存入root栈顶 Map形式
		vs.set("clist", list);
		return "success";
	}
}
