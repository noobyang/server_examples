package com.noobyang.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownloadAction extends ActionSupport {

    // 列出所有可以下载的文件
    public String list() {

        // 得到upload文件夹
        String path = ServletActionContext.getServletContext().getRealPath("/upload");

        // 创建file对象
        File file = new File(path);

        // 列出文件下所有的文件
        File[] files = file.listFiles();

        //将这些文件存到request域中
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("files", files);
        return "list";
    }

    /**
     * 访问Action的业务方法仅仅返回的是字符串。因此Struts在result节点提供了stream类型的type，
     * 指定了stream就代表着我这是要下载的...
     * <p>
     * 既然要下载文件，那么肯定需要几样东西：
     * 1、文件名
     * 2、代表文件的流
     */
    public String downLoad() {

        return "downLoad";
    }

    // 得到要下载的文件名，Struts提供了自动封装的功能
    private String fileName;

    // 如果文件名是中文的，那么需要手动转换，因为超链接是get方法提交
    public void setFileName(String fileName) throws UnsupportedEncodingException {
        fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
        this.fileName = fileName;
        System.out.println(fileName);
    }

    // 得到代表下载文件流，该方法由Struts调用
    public InputStream getAttrInputStream() {
        return ServletActionContext.getServletContext().getResourceAsStream("/upload/" + fileName);
    }

    // 下载时，显示的名称【如果是中文，可能会乱码，因此要URLencode】---->在Struts.xml文件中通过${}可获取
    public String getDownFileName() throws UnsupportedEncodingException {

        fileName = URLEncoder.encode(fileName, "UTF-8");
        return fileName;
    }

}
