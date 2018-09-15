package web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tjl on 2018/9/12 9:48.
 * //第一个控制器/处理器,哪个请求应该对应这个控制器呢?需要处理器
 */
public class Test1_HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("请求访问到了Test1_helloController"+request.getServletPath());
        String name = request.getParameter("name");
        System.out.println(name);

        //准备返回值
        ModelAndView modelAndView = new ModelAndView();
        //添加数据模型
        modelAndView.addObject("msg", "helloworld");
        //设置逻辑视图名,将来逻辑视图名需要通过视图解析器转换成为物理视图
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
