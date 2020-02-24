package com.kd.frame.builder.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.kd.frame.builder.core.ITableFactory;
import com.kd.frame.builder.core.TypeTable;
import com.kd.frame.builder.dao.Dao;
import com.kd.frame.builder.domain.Column;
import com.kd.frame.builder.domain.Table;
import org.apache.ibatis.type.JdbcType;

/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Jane Wang    2017年5月16日 上午9:58:29
 */
public class DMSqlTableFactory implements ITableFactory {
    /**
     * 根据表名称创建表对象
     * @param tableName
     * @return
     */
    public Table build(String tableName, String entityName, String pkName) {
        Dao dao = new Dao();
        Connection conn = dao.getConnect();
        Table table = new Table();
        table.setTableName(tableName);
        table.setEntityName(entityName);
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from " + tableName + " where 1=2 ");
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //String columnClassName = metaData.getColumnClassName(i);
                Column clo = new Column();
                String columnName = metaData.getColumnLabel(i);
                System.out.println(metaData.getColumnType(i));
                //设置名称
                clo.setDbName(columnName);
                clo.setJavaName(convert(columnName.toLowerCase()));
                int columnType = metaData.getColumnType(i);
                JdbcType jdbcType= JdbcType.forCode(columnType);
                //设置类型
                clo.setJavaType(TypeTable.dm.get(columnType));
                clo.setDbType(jdbcType.name());
                table.add(clo);

                //如果是pk那么设置pkColumn
                System.out.println(columnName);
                if (columnName.equalsIgnoreCase(pkName)) {
                    table.setKeyName(pkName);
                    table.setKeyColumn(clo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return table;
    }

    /**
     * 强 user_name 变为 userName
     * @param str
     * @return
     */
    private String convert(String str) {
        if (str == null || str.trim().length() < 1) {
            return null;
        }
        String[] split = str.split("_");
        String retString = "";
        int i = 1;
        retString += split[0];
        while (i < split.length) {
            String string = split[i];
            if (string.length() > 1) {
                retString += string.substring(0, 1).toUpperCase() + string.substring(1);
            } else {
                retString += string;
            }
            i++;
        }
        return retString;
    }
}
