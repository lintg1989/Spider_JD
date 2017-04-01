package com.util;

/**
 * 加载配置文件
 * Created by Lin on 2017/3/30.
 */
public class Config {
    /**
     * 是否持久化到数据库
     */
    public static boolean daEnable;
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
     * cookie路劲
     */
    public static String cookiePath;

    public static String proxyPath;
}
