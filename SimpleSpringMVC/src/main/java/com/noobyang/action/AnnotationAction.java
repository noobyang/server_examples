package com.noobyang.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/noobyang")
public class AnnotationAction {

    private static final Logger log = LoggerFactory.getLogger(HelloAction.class);

    /**
     * RequestMapping 表示只要是/hello.action的请求，就交由该方法处理。当然了.action可以去掉
     * model 它和ModelAndView类似，它这个Model就是把数据封装到request对象中，我们就可以获取出来
     * 返回跳转的页面【真实路径，就不用配置视图解析器了】
     */
    @RequestMapping(value="/annotation.action", method = RequestMethod.POST)
    public String annotation(Model model) throws Exception{
        log.info("annotation");
        model.addAttribute("message","你是谁 ？");
        return "annotation";
    }



}
