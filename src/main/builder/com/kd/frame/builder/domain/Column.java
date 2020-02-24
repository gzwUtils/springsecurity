package com.kd.frame.builder.domain;

/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Jane Wang    2017年5月16日 上午9:57:37
 */
public class Column {
    private String javaName;
    private String dbName;
    private String dbType;
    private String javaType;
    //注释
    private String comment;

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
