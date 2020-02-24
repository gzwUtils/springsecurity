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

public class OracleTableFactory implements ITableFactory {
    /**
     * 根据表名称创建表对象
     * 
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
            if (pkName != null) {
                table.setKeyName(pkName);
            }
            table.setKeyName(pkName);
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //创建列对象
                Column clo = new Column();
                String columnName = metaData.getColumnLabel(i);

                clo.setDbName(columnName);
                clo.setJavaName(convert(columnName.toLowerCase()));
                //如果是pk那么设置pkColumn
                if (convert(columnName.toLowerCase()).equals(table.getKeyName())) {
                    table.setKeyColumn(clo);
                }
                int columnType = metaData.getColumnType(i);
                String javaType = TypeTable.oracleJava.get(columnType);
                javaType = javaType == null ? "String" : javaType;
                clo.setJavaType(javaType);
                System.out.println(columnType);
                String columnType2 = TypeTable.oracleDb.get(columnType);
                columnType2 = columnType2 == null ? "VARCHAR" : columnType2;
                clo.setDbType(columnType2);
                table.add(clo);
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
    public String convert(String str) {
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
