package web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Tjl on 2018/9/13 8:23.
 * 处理器返回null,直接响应输出结果
 */
public class Test3_ResponseNull implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("in Test3ResponseNull");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>ModelAndView=null,直接使用response输出</h1>");
        //视图解析器无需解析
        return  null;

    }
}
