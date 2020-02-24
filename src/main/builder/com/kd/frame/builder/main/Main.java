package com.kd.frame.builder.main;

import com.kd.frame.builder.core.Context;
import com.kd.frame.builder.core.LoadConfig;
import com.kd.frame.builder.core.TableToFile;
import com.kd.frame.builder.domain.Configruation;
import com.kd.frame.builder.domain.Table;

/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Jane Wang    2017年5月18日 下午4:38:07
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Configruation conf = LoadConfig.load();
        Context context = new Context(conf);
        String[] entityNames = conf.getEntityNames();
        String[] tableNames = conf.getTableNames();
        String[] pkNames = conf.getPkNames();
        if (tableNames.length == entityNames.length) {
            for (int i = 0; i < tableNames.length; i++) {
                String tName = tableNames[i];
                String eName = entityNames[i];
                String kName = pkNames[0];
                Table table = context.getFactory().build(tName, eName, kName);
                TableToFile.buildAllForEntity(table, conf);
            }
        } else {
            System.out.println("配置錯誤！！");
        }
        System.out.println("生成結束！！");
    }
}
