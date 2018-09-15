package web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tjl on 2018/9/14 10:15.
 */
@Controller
@RequestMapping("rm")
public class Test3_RequestMehodController {


    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String test1() {
        System.out.println("test1");
        return "hello";

    }
    @RequestMapping(value = "/test2/{userId}",method = RequestMethod.POST)
    public String test2(@PathVariable String userId) {
        System.out.println("test2post"+userId);
        return "hello";

    }
    @RequestMapping(value = "/test2/{userId}",method = RequestMethod.GET)
    public String test3(@PathVariable String userId) {
        System.out.println("test2get"+userId);
        return "hello";

    }
    @RequestMapping(value = "/test4/{userId}",method = {RequestMethod.GET,RequestMethod.POST})
    public String test4(@PathVariable String userId) {
        System.out.println("test4"+userId);
        return "hello";

    }
    // /rm/register   get:访问注册页面,post:用户做了提交，想要完成注册功能
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String test5(){
        System.out.println("接收到GET的Register请求，说明用户想要跳转到注册页面");
        return "register";
    }
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String test6(HttpServletRequest request){
        System.out.println("接收到POST的Register请求，说明用户已经提交了注册信息了，完成注册功能，方法参数获取就不一样了"+request.getParameter("name"));
        return "hello";
    }
    @RequestMapping(value = "")
    public String test() {
        System.out.println("");
        return "success";

    }
}
