package web.controller;

import org.springframework.web.servlet.ModelAndView;
import web.adapter.MyController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tjl on 2018/9/13 9:06.
 */
public class Test5_MyAdapterController implements MyController {
    @Override
    public ModelAndView myHandlerRequest(HttpServletRequest request, HttpServletResponse response){
        System.out.println("想要提供控制器的功能,但是不想实现Controller");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","test5_myhandler");
        return modelAndView;
    }
}
