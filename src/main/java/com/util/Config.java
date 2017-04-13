package com.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 加载配置文件
 * Created by Lin on 2017/3/30.
 */
public class Config {
    /**
     * 是否持久化到数据库
     */
    public static boolean dbEnable;
    /**
     * 是否使用代理抓取
     */
    public static boolean isProxy;

    /**
     * 下载网页线程数
     */
    public static int downloadThreadSize;
    /**
     * 验证码路劲
     */
    public static String verificationCodePath;
    /**
     * 注册的手机号或邮箱
     */
    public static String emailOrPhone;

    /**
     * 密码
     */
    public static String password;

    /**
     * 爬虫入口
     */
    public static String startURL;

    public static String startUserToken;
    /**
     * 下载网页数
     */
    public static int downloadPageCount;

    /**
     * 数据库名称
     */
    public static String dbName;

    public static String dbUserName;

    public static String dbHost;

    public static String dbPassword;

    /**
     * 创建user表语句
     */
    public static String createUserTable;

    /**
     * 创建price表语句
     */
    public static String createPriceTable;

    /**
     * cookie路劲
     */
    public static String cookiePath;

    public static String proxyPath;


    static {
        Properties p = new Properties();
        try {
            p.load(Config.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbEnable = Boolean.parseBoolean(p.getProperty("db.enable"));
        verificationCodePath = p.getProperty("verificationCodePath");
        emailOrPhone = p.getProperty("jd.emailOrPhoneNum");
        password = p.getProperty("jd.password");
        startURL = p.getProperty("startURL");
        startUserToken = p.getProperty("startUserToken");
        downloadPageCount = Integer.valueOf(p.getProperty("downloadPageCount"));
        downloadThreadSize = Integer.valueOf(p.getProperty("downloadThreadSize"));
        cookiePath = p.getProperty("cookiePath");
        proxyPath = p.getProperty("proxyPath");
        isProxy = Boolean.valueOf(p.getProperty("isProxy"));
        if (dbEnable){
            dbName = p.getProperty("db.name");
            dbHost = p.getProperty("db.host");
            dbUserName = p.getProperty("db.username");
            dbPassword = p.getProperty("db.password");
            createPriceTable = p.getProperty("createPriceTable");
            createUserTable = p.getProperty("createUserTable");
        }
    }
}
