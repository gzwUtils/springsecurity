package com.kd.frame.builder.core;

import java.util.Properties;

import com.kd.frame.builder.domain.Configruation;
import com.kd.frame.builder.util.Prop;

/**
 * 加载配置文件
 * @author Jane Wang    2017年5月16日 上午9:56:34
 */
public class LoadConfig {
    public static Configruation load() {
        Properties loadFile = Prop.loadFile();
        Configruation conf = new Configruation();
        //路径属性
        conf.setOutPath(loadFile.get("outPath") + "");
        conf.setPackagePath(loadFile.getProperty("packagePath"));
        conf.setPrefix(loadFile.getProperty("prefix"));
        conf.setDescription(loadFile.getProperty("description"));
        String packagePath = conf.getPackagePath();
        conf.setActionPackage(packagePath+".controller");
        conf.setServicePackage(packagePath+".service");
        conf.setEntityPackage(packagePath+".domain");
        conf.setDaoPackage(packagePath+".dao");
        conf.setMapperPackage(packagePath+".mapper");
        conf.setOutPath(loadFile.getProperty("outPath"));
        conf.setPagePath(loadFile.getProperty("pagePahe"));
        //实体属性
        String tableName = loadFile.getProperty("tableNames");
        String entityName = loadFile.getProperty("entityNames");
        String pkName = loadFile.getProperty("pkNames");
        String[] tableNames = tableName.split(",");
        String[] entityNames = entityName.split(",");
        String[] pkNames = pkName.split(",");

        conf.setTableNames(tableNames);
        conf.setEntityNames(entityNames);
        conf.setPkNames(pkNames);
        //系统配置
        conf.setDb(loadFile.getProperty("db"));
        return conf;
    }
}
