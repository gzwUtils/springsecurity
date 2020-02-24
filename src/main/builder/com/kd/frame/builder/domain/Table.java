package com.kd.frame.builder.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * table实体
 * @author Jane Wang    2017年5月16日 上午9:58:08
 */
public class Table {
    private String tableName;
    private String entityName;
    private String keyName = "id";
    private Column keyColumn;

    public Column getKeyColumn() {
        return keyColumn;
    }

    public void setKeyColumn(Column keyColumn) {
        this.keyColumn = keyColumn;
    }

    private List<Column> columns = new ArrayList<Column>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void add(Column column) {
        columns.add(column);
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

}
