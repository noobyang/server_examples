package com.noobyang.action;

import com.noobyang.entity.Dept;
import com.noobyang.service.IDaoService;
import com.noobyang.service.IMongoService;
import com.noobyang.service.IRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/dept")
public class HelloAction {

    private static final Logger logger = LoggerFactory.getLogger("HelloAction");

    @Resource
    private IDaoService daoService;

    @RequestMapping(value="/selectDept/{id}", method = RequestMethod.GET)
    public String selectDept(@PathVariable Integer id) throws Exception {
        // 记录trace级别的信息
        logger.trace("HelloAction log4j2日志输出：This is trace message.");
        // 记录debug级别的信息
        logger.debug("HelloAction log4j2日志输出：This is debug message.");
        // 记录info级别的信息
        logger.info("HelloAction log4j2日志输出：This is info message.");
        // 记录error级别的信息
        logger.error("HelloAction log4j2日志输出：This is error message.");
        // 记录warn级别的信息
        logger.warn("HelloAction log4j2日志输出：This is warn message.");

        daoService.selectDept(id);

        return "forward:/message.jsp";
    }

    @RequestMapping(value="/insert.action", method = RequestMethod.POST)
    public String insert(Dept dept) throws Exception {
        // 记录trace级别的信息
        logger.trace("HelloAction log4j2日志输出：This is trace message.");
        // 记录debug级别的信息
        logger.debug("HelloAction log4j2日志输出：This is debug message.");
        // 记录info级别的信息
        logger.info("HelloAction log4j2日志输出：This is info message.");
        // 记录error级别的信息
        logger.error("HelloAction log4j2日志输出：This is error message.");
        // 记录warn级别的信息
        logger.warn("HelloAction log4j2日志输出：This is warn message.");

        logger.debug("HelloAction " + dept.toString());

        daoService.insertDept(dept);

        return "forward:/message.jsp";
    }

    @Resource
    private IRedisService redisService;

    @RequestMapping(value="/setRedis.action", method = RequestMethod.POST)
    public String setRedis(String key, String value) throws Exception {
        logger.debug("setRedis " + key + ", " + value);
        redisService.setValueRedis(key, value);
        return "forward:/message.jsp";
    }

    @Resource
    private IMongoService mongoService;

    @RequestMapping(value="/testMongo", method = RequestMethod.GET)
    public String testMongo() throws Exception {
        logger.debug("HelloAction testMongo");

        mongoService.save();

        return "forward:/message.jsp";
    }

}
