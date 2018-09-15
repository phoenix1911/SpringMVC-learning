package web.adapter;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import web.controller.Test5_MyAdapterController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tjl on 2018/9/13 8:52.
 */
public class MyHandlerAdapter implements HandlerAdapter {
    //定义适配规则,通过url得到的路径,已经在容器中找到了对应的bean,但是这个bean是否能够处理请求
    @Override
    public boolean supports(Object handler) {
        System.out.println("spring适配校验没通过,使用自己的");
        return (handler instanceof MyController);
    }
    //将request,response对象交给上边通过适配规则校验的控制器去处理
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("调用适配成功的处理方法");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("hello");
//        modelAndView.addObject("msa","MyHandlerAdapter");
//        return modelAndView;
        System.out.println("类型转换为自定义接口,传入请求响应对象,然后处理请求");
        System.out.println("符合自定义校验规则,调用方法处理请求");
        return ((MyController) handler).myHandlerRequest(request, response);
    }

    @Override
    public long getLastModified(HttpServletRequest request, Object handler) {
        return -1;
    }
}
