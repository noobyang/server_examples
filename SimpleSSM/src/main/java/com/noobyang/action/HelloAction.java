package com.noobyang.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloAction {

    private static final Logger logger = LogManager.getLogger("HelloAction");

    @RequestMapping(value="/params2.action", method = RequestMethod.POST)
    public String params2(String username, int[] hobby) throws Exception {
        logger.debug(username);
        return "message";
    }

}
