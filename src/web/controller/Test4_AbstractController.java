package web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tjl on 2018/9/13 8:33.
 * 选择继承AbstractController的方式去实现控制器,提供了其他的一些功能
 */
public class Test4_AbstractController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("in test4 AbstractController");
        System.out.println(request.getAttribute("name"));
        System.out.println(request.getMethod());
        System.out.println("会话对象session是否已有"+request.getSession(false));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg", "test4 AbstractController");
        return modelAndView;
    }
}
