package com.tiye.IntelligentClass.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.model.SysAccount;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class UrlInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		try {
			HttpSession session = request.getSession();
			String path = request.getServletPath();
			System.out.println("path="+path);
			SysAccount user =  (SysAccount) session.getAttribute(Const.SESSION_USER);
			if(null == user || "".equals(user)){
				response.sendRedirect("/back/user/noLogin");
				return false;
			}else{
				/*path = path.substring(1, path.length());
				boolean b = Jurisdiction.hasJurisdiction(path,session);
				if(!b){
					response.sendRedirect("/error/404");
					return b;
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
