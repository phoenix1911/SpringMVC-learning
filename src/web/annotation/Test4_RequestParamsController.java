package web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tjl on 2018/9/14 14:12.
 * 限制请求参数
 */
@Controller
@RequestMapping("/rpm")
public class Test4_RequestParamsController {

    //params="name"必须有参数 key为name
    @RequestMapping(value="/test1",params = "name")
    public String test1(HttpServletRequest request) {
        System.out.println("test1"+request.getParameter("name"));
        return "hello";
    }
    @RequestMapping(value="/test2",params = "!name")
    public String test2(HttpServletRequest request) {
        System.out.println("test2"+request.getParameter("name"));
        return "hello";
    }
    //params="name=tom":参数中必须有name，且值必须为tom
    @RequestMapping(value="/test3",params="name=tom")
    public String test3(){
        System.out.println("test3");
        return "hello";
    }
    //params="name!=tom":参数中如果有key为name的键值对，value不能是tom，或者就不要出现key为name的键值
    @RequestMapping(value="/test4",params="name!=tom")
    public String test4(){
        System.out.println("test4");
        return "hello";
    }
    //多种限制
    @RequestMapping(value="/test5",params={"name!=tom","age","gender=F"})
    public String test5(){
        System.out.println("test5");
        return "hello";
    }

}
