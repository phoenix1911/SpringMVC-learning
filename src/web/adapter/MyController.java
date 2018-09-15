package web.adapter;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tjl on 2018/9/13 9:46.
 * 自定义的控制器接口
 */

public interface MyController {
    //希望 自定义适配器的适配规则可以达到效果,只要通过url找到的bean是属于本接口的实现类对象
    //将来就调用myHandlerRequest去处理请求
    ModelAndView myHandlerRequest(HttpServletRequest request, HttpServletResponse response);


}
