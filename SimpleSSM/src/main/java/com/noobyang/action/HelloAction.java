package com.noobyang.action;

import com.noobyang.dao.impl.DeptDaoImpl;
import com.noobyang.entity.Dept;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class HelloAction {

    private static final Logger logger = LogManager.getLogger("HelloAction");

//    @Resource
//    private DeptDaoImpl deptDao;

    @RequestMapping(value="/insert.action", method = RequestMethod.GET)
    public String insert(){
        logger.debug("insert ");
//        deptDao.insertDept(dept);

        return "message";
    }

    @RequestMapping(value="/params6.action", method = RequestMethod.POST)
    public String params6(Model model) throws Exception {
        logger.debug("params6 ");

        model.addAttribute("message", "redirect");
        return "message";
    }

}