package web.annotation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Tjl on 2018/9/14 15:20.
 */
@Controller
@RequestMapping("/hm")
public class Test6_HandlerMethodParamBind {

    @RequestMapping("/test1")
    public String test1(ServletRequest request,ServletResponse response){
        System.out.println(request);
        System.out.println(request.getParameter("name"));
        request.setAttribute("msg", "ServletRequest");
        System.out.println(response);
        return "hello";
    }
    @RequestMapping("/test2")
    public String test2(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println(request);
        System.out.println(request.getParameter("name"));
        System.out.println(request.getServletPath());
        System.out.println(request.getContextPath());
        request.setAttribute("msg", "ServletRequest");
        System.out.println(response);
        PrintWriter pw = response.getWriter();
        return "hello";
    }
    //直接获取字节输出流，说明要通过输出流写出响应，无需视图解析
    @RequestMapping("/test3")
    public void test3(InputStream is,OutputStream os){
        System.out.println(is);
        System.out.println(os);
        try {
            os.write("<h1>hello</h1>".getBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/test4")
    public String test4(Reader reader,Writer writer){
        System.out.println(reader);
        System.out.println(writer);
        try {
            writer.write("<h1>#######</h1>");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
    }
    @RequestMapping("/test5")
    public void test5(Reader reader,Writer writer){
        System.out.println(reader);
        System.out.println(writer);
        try {
            writer.write("<h1>#######</h1>");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/test6")
    public String test6(WebRequest webRequest,NativeWebRequest nativeWebRequest){
        System.out.println(webRequest.getHeader("Accept"));
        System.out.println(webRequest.getParameter("name"));
        webRequest.setAttribute("msg", "tom", webRequest.SCOPE_REQUEST);
        System.out.println(webRequest.getAttribute("msg", webRequest.SCOPE_REQUEST));
        //获取本地ServletAPI
        HttpServletRequest httpServletRequest =
                nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse httpServletResponse =
                nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        System.out.println(httpServletRequest);
        System.out.println(httpServletResponse);
        System.out.println(httpServletRequest.getAttribute("msg"));
        return "hello";
    }
    @RequestMapping("/test7")
    public String test7(HttpSession session){
        System.out.println(session.getId());
        session.setAttribute("msg", "sessionMsg");
        return "hello";
    }
    //写的参数可以不传，但是如果String--null，类型转换可能出问题
    //请求参数key与功能处理方法变量名一致的情况下，可以不做额外配置,也能赋值
    @RequestMapping("/test8")
    public String test8(String name,int age,int id,Model model){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("id:"+id);
        model.addAttribute("name", name);
        return "hello";
    }
    //如果表单对象pojo，无参创建对象，可以使用key与property对应做属性初始化，
    //同时表单对象会以首字母小写作为key，存于model
    @RequestMapping("/test9")
    public String test9(String name, String age, String id, User user){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("id:"+id);
        System.out.println("user:"+user);
        return "hello";
    }
}
