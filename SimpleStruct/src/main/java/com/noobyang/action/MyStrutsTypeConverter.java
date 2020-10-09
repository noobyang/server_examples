package com.noobyang.action;

import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 自定义异常转换器类
 */
public class MyStrutsTypeConverter extends StrutsTypeConverter {

    // 需求，当Struts自动封装数据时，也支持yyyyMMdd,yyyy年MM月dd日等格式的支持\
    private SimpleDateFormat[] format = {
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日")
    };

    /**
     * 把String转换为指定的类型 【String To Date】
     * @param map 当前上下文环境
     * @param strings jsp表单提交的字符串的值
     * @param aClass 要转换为的目标类型
     */
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        System.out.println(aClass.toString());
        // 判断是否有值
        if (strings == null) {
            return null;
        }
        // 判断是否是日期类型的
        if (Date.class != aClass) {
            return null;
        }

        // 遍历循环
        for (SimpleDateFormat dateFormat : format) {
            try {
                // 解析传递进来的第一个就行啦
                return dateFormat.parse(strings[0]);
            } catch (ParseException e) {
                // 如果格式不对，那么就跳出当前的循环
            }
        }
        return null;
    }

    @Override
    public String convertToString(Map map, Object o) {
        Date date = (Date) o;
        //输出格式为yyyy-MM-dd
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

}
