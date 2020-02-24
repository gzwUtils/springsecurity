package com.kd.frame.builder.domain;

/**
 * 对path.properties 的配置抽象 
 * @author Jane Wang    2017年5月16日 上午9:57:50
 */
public class Configruation {
    //基本路徑數據
    private String outPath;
    private String packagePath;
    private String prefix;
    private String description;
    private String actionPackage;
    private String servicePackage;
    private String daoPackage;
    private String mapperPackage;
    private String pagePath;
    private String entityPackage;

    //实体名称数据
    private String[] tableNames;
    private String[] entityNames;
    private String[] pkNames;

    //系统配置
    private String db = "oracle";

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String[] getTableNames() {
        return tableNames;
    }

    public void setTableNames(String[] tableNames) {
        this.tableNames = tableNames;
    }

    public String[] getEntityNames() {
        return entityNames;
    }

    public void setEntityNames(String[] entityNames) {
        this.entityNames = entityNames;
    }

    public String[] getPkNames() {
        return pkNames;
    }

    public void setPkNames(String[] pkNames) {
        this.pkNames = pkNames;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getActionPackage() {
        return actionPackage;
    }

    public void setActionPackage(String actionPackage) {
        this.actionPackage = actionPackage;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
