package com.kd.frame.builder.core;

import com.kd.frame.builder.domain.Table;

/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Jane Wang    2017年5月16日 上午9:56:24
 */
public interface ITableFactory {
    Table build(String tableName, String entityName, String pkName);
}
