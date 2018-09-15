package web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tjl on 2018/9/13 11:08.
 */
public class Test6_LoginController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("登陆controller");
        request.getSession().setAttribute("user","user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginSuccess");
        return modelAndView;
    }
}
