package com.noobyang.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParamsAction {

    private static final Logger log = LoggerFactory.getLogger(HelloAction.class);

    @RequestMapping(value="/params.action", method = RequestMethod.POST)
    public String params(Model model, String username, String id) throws Exception {
        log.info("params 用户名是：" + username + ", 编号是：" + id);
        model.addAttribute("message", username + " " + id);
        return "annotation";
    }

}
