package com.noobyang.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloAction {

    private static final Logger logger = LogManager.getLogger("HelloAction");

    @RequestMapping(value="/params2.action", method = RequestMethod.POST)
    public String params2(Model model, String username, int[] hobby) throws Exception {
        String str = "";
        for (int i : hobby) {
            str  = str + i + " ";
        }
        logger.info("params2 " + username + " " + str);
        model.addAttribute("message", username + " " + str);
        return "message";
    }



}
