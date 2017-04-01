package com.util;

import org.apache.http.client.HttpClient;

import java.io.*;

/**
 * 将没有访问过的url的内容存储到文件系统中去
 * Created by Lin on 2017/3/23.
 */
public class DownloadFile {

    //构造存储的文件名称（去除url中不能作为文件名的字符）
    public String getFileName(String url, String contentType) {
        String fileName = "";
        if(contentType.contains("html")) {
            fileName = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
        } else {
            //将类似text/html的字符串截取出文件类型后缀
            fileName = url.replaceAll("\\?/:*|<>\"]","_") + "."
            +contentType.substring(contentType.indexOf("/")+1);
        }

        return fileName;
    }

    //一个写文件的方法
    public void saveToLocal(byte[] content, String filePath) {
        try {

            DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filePath)));
            for (int i=0; i<content.length; i++) {
                try {
                    out.write(content[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //将page的内容写入文件系统
    public String downloadFile(String url) {
        String fileName = "";

        // 设置HttpClient的连接管理对象，设置 HTTP连接超时5s


        return fileName;
    }


}
