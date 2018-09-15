package web.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tjl on 2018/9/14 8:28.
 */
@Controller
@RequestMapping("rp")
public class Test2_RequestPathController {
    @RequestMapping("/test1")
    public String test1() {
        System.out.println("test1");
        return "hello";
    }
    @RequestMapping("/test2")
    public String test2() {
        System.out.println("test2");
        return "hello";
    }
    @RequestMapping("/test3")
    public String test3() {
        System.out.println("test3");
        return "hello";
    }
    @RequestMapping(value = {"/test4","test41","test42"})
    public String test4() {
        System.out.println("test4");
        return "hello";
    }

    //模板映射
//    :{xxx}:占位,必须得写,只代表一个路径,不包含子路径
    @RequestMapping("/test5/user/{userId}")
    public String test5(@PathVariable String userId) {
        System.out.println("test5"+userId);
        return "hello";
    }
//    默认情况下,当当前处理方法得参数变量名与模板中声明的变量一致的时候,可以不做特殊声明,否则需要指定
    @RequestMapping("/test6/user/{userId}/group")
    public String test6(@PathVariable("userId") String id) {
        System.out.println("test6"+id);
        return "hello";
    }
    @RequestMapping("/test7/user/{userId}/group/{groupId}")
    public String test7(@PathVariable String userId,@PathVariable Long groupId) {
        System.out.println("test7"+userId+groupId);
        return "hello";
    }
    @RequestMapping("/test8/user/{userId}-{groupId}")
    public String test8() {
        System.out.println("test8");
        return "hello";
    }

    /**
     * ANT风格路径映射
     * **:之路径包含后代路径
     * ?:有且只有一个字符
     * *:0-n个字符
     */

    @RequestMapping("/test9/**")
    public String test9() {
        System.out.println("test9");
        return "hello";
    }
    @RequestMapping("/test10/?")
    public String test10() {
        System.out.println("test10");
        return "hello";
    }
    @RequestMapping("/test11?")
    public String test11() {
        System.out.println("test11");
        return "hello";
    }
    @RequestMapping("/test12/*")
    public String test12() {
        System.out.println("test12");
        return "hello";
    }
//    @RequestMapping()
//    public String test13() {
//        System.out.println("test13");
//        return "hello";
//    }
    @RequestMapping("/test14*")
    public String test14() {
        System.out.println("test14");
        return "hello";
    }@RequestMapping("/??/test15*/**/{userId}")
    public String test15(@PathVariable long userId) {
        System.out.println("test15");
        return "hello";
    }

    //正则表达式风格的路径映射:更加精确限定请求的url，也可以以模板映射的方式获取到符合条件的url片段的值[特殊的模板映射]
    //					 条件可以写的很复杂，比如限定数据类型、模式

    @RequestMapping(value="/test16/{userId:[0-9]}")
    public String test16(@PathVariable String userId){
        System.out.println("test16, userId:"+userId);
        return "hello";
    }
    @RequestMapping(value="/test17/{userId:[0-9]abc}")
    public String test17(@PathVariable String userId){
        System.out.println("test17, userId:"+userId);
        return "hello";
    }
    @RequestMapping(value="/test18/{userId:[0-9]?abc}")
    public String test18(@PathVariable String userId){
        System.out.println("test18, userId:"+userId);
        return "hello";
    }
    @RequestMapping(value="/test19/{userId:[0-9]+abc}")
    public String test19(@PathVariable String userId){
        System.out.println("test19, userId:"+userId);
        return "hello";
    }
    @RequestMapping(value="/test20/{userId:[0-9]*[a-z]{3}-\\d{2,}}")
    public String test20(@PathVariable String userId){
        System.out.println("test20, userId:"+userId);
        return "hello";
    }
    @RequestMapping(value="/test21/{test}/{userId:^[0-9]*[B-z]{3}-\\d{2,}$}/{groupId:^\\w{1,3}\\d+$}")
    public String test21(@PathVariable("test") String tests,@PathVariable String userId,
                         @PathVariable("groupId") String groupId){
        System.out.println("test21,test:"+tests+" userId:"+userId+", groupId:"+groupId);
        return "hello";
    }
	/*"/test14/{userId:[0-9]}"
	"/test15/{userId:a[0-9]b}"
	"/test16/{userId:[0-9]+}"
	"/test17/{userId:[A-z]*}"
	"/test18/{userId:^\\d{3,4}a\\w{2,}$}"
	"/test19/{userId:\\d{3,4}a\\w{2,}}-{groupId:\\d{3}}"*/


}
