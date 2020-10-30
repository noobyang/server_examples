package com.noobyang.action;

import com.noobyang.action.bean.ListBean;
import com.noobyang.action.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParamsAction {

    private static final Logger log = LoggerFactory.getLogger(HelloAction.class);

//    @RequestMapping(value="/params.action", method = RequestMethod.POST)
//    public String params(Model model, String username, String id) throws Exception {
//        log.info("params 用户名是：" + username + ", 编号是：" + id);
//        model.addAttribute("message", username + " " + id);
//        return "message";
//    }

    @RequestMapping(value="/params.action", method = RequestMethod.POST)
    public String params(Model model, User user) throws Exception {
        log.info("params " + user.getUsername() + ", " + user.getId());
        model.addAttribute("message", user.getUsername() + " " + user.getId());
        return "message";
    }

    @RequestMapping(value="/params2.action", method = RequestMethod.POST)
    public String params2(Model model, String username, int[] hobby) throws Exception {
        String str = "";
        for (int i : hobby) {
            str  = str + i + " ";
        }
        log.info("params2 " + username + " " + str);
        model.addAttribute("message", username + " " + str);
        return "message";
    }

    @RequestMapping(value="/params2.action", method = RequestMethod.POST)
    public String params3(Model model, ListBean bean) throws Exception {
        String str = "";
        for (User user : bean.getList()) {
            str  = str + user.getUsername() + " " + user.getId()  + " ";
        }
        log.info("params3 " + str);
        model.addAttribute("message", str);
        return "message";
    }

}
