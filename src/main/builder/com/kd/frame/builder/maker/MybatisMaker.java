
package com.kd.frame.builder.maker;

import java.util.HashMap;
import java.util.Map;

import com.kd.frame.builder.domain.Configruation;
import com.kd.frame.builder.domain.Table;
import com.kd.frame.builder.util.FreeMakerUtil;

/**
 * 进行字符串拼接的类
 * @author Jane Wang    2017年5月18日 下午4:42:05
 */
public class MybatisMaker {
    private Map<String, Object> attribute = new HashMap<String, Object>();

    public MybatisMaker(Table table, Configruation conf) {
        attribute.put("table", table);
        attribute.put("config", conf);
    }

    /**
     * 制作实体对象   
     * @return
     */
    public String makeEntity() {
        return FreeMakerUtil.builder("MybatisEntity.ftl", attribute);
    }

    /**
     * 输出dao层接口   
     * @return
     */
    public String makeDaoInterface() {
        return FreeMakerUtil.builder("MybatisIDao.ftl", attribute);
    }

    /**
     * 输出dao 
     * @return
     */
    public String makeDaoMapper() {
        return FreeMakerUtil.builder("MybatisMapper.ftl", attribute);
    }

    /**
     * 生成serviceinterface   
     * @return
     */
    public String makeServiceInterface() {
        return FreeMakerUtil.builder("MybatisIService.ftl", attribute);
    }

    /**
     * 生成service
     * 
     * @param table
     * @return
     */
    public String makeService() {
        return FreeMakerUtil.builder("MybatisServiceImpl.ftl", attribute);
    }

    /**
     * 创建action层  
     * @return
     */
    public String makeAction() {
        return FreeMakerUtil.builder("MybatisController.ftl", attribute);
    }

    public String makeListPage() {
        return "";
    }

    public String makeSavePage() {
        return "";
    }

    public String makeEditPage() {
        return "";
    }

}
