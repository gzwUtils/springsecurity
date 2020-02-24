package com.kd.frame.builder.util;

import java.io.FileReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * freeMarker辅助类 
 * @author Jane Wang    2017年5月18日 下午4:42:59
 */
public class FreeMakerUtil {
    /**
     * 用模板生成设置
     * @param fltPath
     * @param attribute
     * @return
     */
    public static String builder(String fltPath, Map<String, Object> attribute) {
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        URL resource = Thread.currentThread().getContextClassLoader().getResource("\\");
        String path = resource.getPath();
        try {
            //解决空格问题
            path = URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        try {

            Template template = new Template(fltPath, new FileReader(path + "com\\kd\\frame\\builder\\ftl\\" + fltPath),
                configuration);
            StringWriter out = new StringWriter();
            template.process(attribute, out);
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String builder = FreeMakerUtil.builder("MyBatisEntity.ftl", null);
        System.out.println(builder);
    }
}
