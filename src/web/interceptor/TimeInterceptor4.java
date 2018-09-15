package web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tjl on 2018/9/13 10:46.
 */
public class TimeInterceptor4 extends HandlerInterceptorAdapter {
    private ThreadLocal<Long> local = new ThreadLocal<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("记录开始时间"+start);
        local.set(start);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        System.out.println("记录结束时间"+(System.currentTimeMillis()-local.get()));
    }
}
