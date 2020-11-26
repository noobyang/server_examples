package com.noobyang.action;

import com.noobyang.dao.impl.DeptDaoImpl;
import com.noobyang.entity.Dept;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/dept")
public class HelloAction {

    private static final Logger logger = LogManager.getLogger("HelloAction");

    @Resource
    private DeptDaoImpl deptDao;

    @RequestMapping(value="/insert")
    public ModelAndView insert(Dept dept){
        logger.debug("insert " + dept);
        deptDao.insertDept(dept);

        ModelAndView modelAndView = new ModelAndView();
        // 跳转到hello.jsp页面
        modelAndView.setViewName("message");
        return modelAndView;
    }
}