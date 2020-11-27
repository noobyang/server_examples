package com.noobyang.action;

import com.noobyang.entity.Dept;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/dept")
public class HelloAction {

    private static final Logger logger = LogManager.getLogger("HelloAction");

    @RequestMapping(value="/insert.action", method = RequestMethod.POST)
    public String insert(Dept dept) throws Exception {
        logger.debug(dept.toString());
        return "message";
    }

}
