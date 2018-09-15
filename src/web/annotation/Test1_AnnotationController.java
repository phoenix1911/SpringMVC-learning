package web.annotation;

import common.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/9/13 14:16.
 */
@Controller//声明:处理器控制器
@RequestMapping("/day2")//基础url路径
public class Test1_AnnotationController {

    //功能处理方法,通过@RequestMapping 可以限定要处理的请求需要满足的各种条件value:url
    @RequestMapping("/test1")
    public ModelAndView test1() {
        System.out.println("test1");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "helloannotation");
        modelAndView.setViewName("hello");
        return modelAndView;

    }

    @RequestMapping("/test2")
    public ModelAndView test2() {
        System.out.println("test1");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "helloannotation2");
        modelAndView.setViewName("hello");
        return modelAndView;

    }
    //返回值为String ,数据Model可以在方法参数中声明
    @RequestMapping("/test3")
    public String test3(Model model) {
        System.out.println("test3");
        model.addAttribute("msg", "返回值为String的情况");
        User zs = new User(100, "zs", 15);
        model.addAttribute("user", zs);
        model.addAttribute(zs);

        return "hello";
    }

    /*
    返回值为void 说明要通过请求或者响应对象做跳转或者返回
    情况1:如果参数为获取HttpServletResponse,以请求的url作为逻辑视图名
    情况2:通过request进行内部跳转
     */
    @RequestMapping("/test4")
    public void test4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test4");
        //内部跳转 不会被视图解析器解析
        request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request,response);
//        //重定向到一个请求
//        response.sendRedirect("test1");
//        //重定向到一个不被保护的页面
//        response.sendRedirect("post.jsp");
//        //直接使用response做输出
//        PrintWriter writer = response.getWriter();
//        writer.print("<h1>直接输出</h1>");
//        writer.flush();
//        writer.close();
    }

    //不做任何处理,只是希望进行跳转页面的操作
    @RequestMapping("/test5")
    public String test5() {
        System.out.println("test5");
        return "hello";
    }


}
