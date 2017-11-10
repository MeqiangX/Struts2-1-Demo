package interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
     //一个简单的权限验证  ,之后还要在struts.xml中配置
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = ActionContext.getContext().getSession();
		
		if (session.get("user")==null) {
			session.put("meg", "您还未登陆~！");
			return Action.INPUT;
		}
		//妈蛋，，这弄了好久     拦截指定action的方法 这个方法不会执行，要调用invoke() 主动执行， 对于一些表单和值栈的获取
		//不执行就无法从这个拦截器向Action中传递
		return invocation.invoke(); //每一次invoke函数被调用时，ActionInvocation 总会查询自身的状态，调用接下来的拦截器
		// 在所有拦截器被调用之后，invoke方法会促使动作类执行
		//invoke是一个递归方法，ActionProxy生成的Action代理类对象中的ActionInvocation对象，这个对象有所有的拦截器,
		//ActionpProxy代理类对象执行execute方法，就会执行ActionInvocation的invoke方法，invoke中有当前拦截器的处理
		//inteceptor.getInterceptor().intercept(DefaultActionInvovation.this),invoke返回的是下一个拦截器的
		//invoke方法，是递归的去执行ActionInvocation里面所有拦截器的intecept方法，最后执行Action
		//return Action.SUCCESS;
	}
   
}
