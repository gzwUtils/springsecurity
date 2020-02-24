package com.kd.frame.builder.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 配置文件加载辅助类
 * @author Jane Wang    2017年5月18日 下午4:44:11
 */
public class Prop {
    /**
     * 加载dao配置文件
     * @return
     */
    public static Map<String, String> loadJDBC() {
        Map<String, String> map = new HashMap<String, String>();
        Properties prop = new Properties();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String path = contextClassLoader.getResource("//").getPath();
        path += "/com/kd/frame/builder/config/jdbc.properties";
        try {
            path = URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        File file = new File(path + "");
        try {
            InputStream in = new FileInputStream(file);
            prop.load(in);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String pwd = prop.getProperty("pwd");
            String uname = prop.getProperty("uname");
            map.put("driver", driver);
            map.put("url", url);
            map.put("pwd", pwd);
            map.put("uname", uname);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 加载文件路径文件
     * @return
     */
    public static Properties loadFile() {
        Properties prop = new Properties();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String path = contextClassLoader.getResource("//").getPath();
        path += "com/kd/frame/builder/config/path.properties";
        try {
            path = URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        File file = new File(path + "");
        try {
            InputStream in = new FileInputStream(file);
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
