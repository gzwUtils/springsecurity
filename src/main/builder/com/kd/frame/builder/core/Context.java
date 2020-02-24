package com.kd.frame.builder.core;

import java.util.HashMap;
import java.util.Map;

import com.kd.frame.builder.domain.Configruation;

/**
 * 环境类用于选择factory
 * @author Jane Wang    2017年5月16日 上午9:55:56
 */
public class Context {
    public Context() {

    }

    public Context(Configruation config) {
        this.config = config;
    }

    private Configruation config;
    public static Map<String, String> dbs = new HashMap<String, String>();
    static {
        dbs.put("oracle", "com.kd.frame.builder.factory.OracleTableFactory");
        dbs.put("mysql", "com.kd.frame.builder.factory.MySqlTableFactory");
        dbs.put("dm", "com.kd.frame.builder.factory.DMSqlTableFactory");
    }

    public Configruation getConfig() {
        return config;
    }

    public void setConfig(Configruation config) {
        this.config = config;
    }

    /**
     * table工厂  
     * @return
     */
    public ITableFactory getFactory() {
        String db = config.getDb();
        String className = dbs.get(db);
        try {
            Class<?> forName = Class.forName(className);
            ITableFactory newInstance = (ITableFactory) forName.newInstance();
            return newInstance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
