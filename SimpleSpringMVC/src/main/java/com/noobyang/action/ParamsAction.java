package com.noobyang.action;

import com.noobyang.action.bean.CombBean;
import com.noobyang.action.bean.ListBean;
import com.noobyang.action.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value="/params3.action", method = RequestMethod.POST)
    public String params3(Model model, ListBean bean) throws Exception {
        String str = "";
        for (User user : bean.getList()) {
            str  = str + user.getUsername() + " " + user.getId()  + " ";
        }
        log.info("params3 " + str);
        model.addAttribute("message", str);
        return "message";
    }

    @RequestMapping(value="/params4.action", method = RequestMethod.POST)
    public String params4(Model model, CombBean bean) throws Exception {
        String str = "";
        str  = str + bean.getUser().getUsername() + " " + bean.getUser().getId()  + " ";
        log.info("params4 " + str);
        model.addAttribute("message", str);
        return "message";
    }

    /**
     * 字符串转日期类型
     */
//    @InitBinder
//    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//    }

    @RequestMapping(value="/params5.action", method = RequestMethod.POST)
    public String params5(Model model, String username, Date date) throws Exception {
        String str = "";
        str  = str + username + " " + date  + " ";
        log.info("params5 " + str);
        model.addAttribute("message", str);
        return "message";
    }

    @RequestMapping(value="/params6.action", method = RequestMethod.POST)
    public String params6(Model model, String username, Date date) throws Exception {
            model.addAttribute("message", "redirect");
        // 我们一般做开发的时候，经常编辑完数据就返回到显示列表中。我们在Struts2是使用配置文件进行重定向或转发的
        // 结果重定向和转发
//        return "redirect:message.jsp";
        return "redirect:/redirect6.action";
    }

    @RequestMapping("/redirect6.action")
    public String redirect6(Model model) throws Exception {
        log.info("redirect6");
        model.addAttribute("message", "redirect");
        return "message";
    }

    /**
     * 如果我们使用@RequestParam注解的话，我们就可以使方法参数名与传递过来的name属性名不同…
     * 该注解有三个变量
     *     value【指定name属性的名称是什么】
     *     required【是否必须要有该参数】
     *     defaultvalue设置默认值
     */
    @RequestMapping("/params7.action")
    public String params7(Model model, @RequestParam(value="id", required=true) String id) throws Exception {
        log.info("params7");
        model.addAttribute("message", "params7");
        return "message";
    }

    @ModelAttribute("itemsType")
    public Map<String, String> getItemsType() throws Exception {
        HashMap<String, String> itemsType = new HashMap<>();
        itemsType.put("oo1", "Dog");
        itemsType.put("oo2", "Cat");
        return itemsType;
    }

    @RequestMapping("/uploadfile.action")
    public void uploadfile(MultipartFile picture) throws Exception {
        log.info("uploadfile " + picture.getOriginalFilename());
        log.info("uploadfile " + picture.getSize());
        log.info("uploadfile " + Arrays.toString(picture.getBytes()));
    }

}
