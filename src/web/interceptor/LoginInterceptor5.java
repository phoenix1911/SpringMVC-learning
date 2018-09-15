package web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Tjl on 2018/9/13 10:56.
 */
public class LoginInterceptor5 extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果用户登陆了,放行
        //如果用户没登陆,返回到login.jsp
        //如果用户没登陆,但访问的是login.*** 放行
        System.out.println("权限校验开始");

        System.out.println("用户的访问请求"+request.getServletPath());
        if (request.getServletPath().startsWith("/login")) {
            System.out.println("正在准备登陆,放行");
            return true;
        }

        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("session is  null return false");
            return false;
        }
        System.out.println(session.getAttribute("user"));
        if (session.getAttribute("user")==null) {
            System.out.println("session is not null,未登陆");
            return false;
        }


        return true;
    }
}
