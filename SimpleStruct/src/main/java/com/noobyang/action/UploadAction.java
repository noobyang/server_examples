package com.noobyang.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

public class UploadAction extends ActionSupport {

    // 上传文件对应的File对象
    private File file1;
    private File file2;

    // 得到上传文件的名称
    private String file1FileName;
    private String file2FileName;

    // 得到上传文件的类型
    private String file1ContentType;
    private String file2ContentType;

    // 给出相对应的setter
    public void setFile1(File file1) {
        this.file1 = file1;
    }

    public void setFile2(File file1) {
        this.file1 = file1;
    }

    public void setFile1FileName(String file1FileName) {
        this.file1FileName = file1FileName;
    }

    public void setFile2FileName(String file2FileName) {
        this.file2FileName = file2FileName;
    }

    public void setFile1ContentType(String file1ContentType) {
        this.file1ContentType = file1ContentType;
    }

    public void setFile2ContentType(String file2ContentType) {
        this.file2ContentType = file2ContentType;
    }

    public String upload() throws IOException {
        System.out.println("file1FileName " + file1FileName);
        System.out.println("file2FileName " + file2FileName);
        System.out.println("file1ContentType " + file1ContentType);
        System.out.println("file2ContentType " + file2ContentType);


        // 得到上传的路径
        String path = ServletActionContext.getServletContext().getRealPath("upload");
        System.out.println(path);

        // 创建文件对象
        File destFile = new File(path, file1FileName);

        // 调用工具类方法，将文件拷贝过去
        FileUtils.copyFile(file1, destFile);

        return "success";
    }
}
