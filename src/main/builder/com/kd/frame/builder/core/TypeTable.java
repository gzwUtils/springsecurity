package com.kd.frame.builder.core;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * TODO(这里用一句话描述这个类的作用) 
 * @author Jane Wang    2017年5月16日 上午9:57:11
 */
public class TypeTable {
	public static Map<Integer,String> mysql = new HashMap<Integer, String>();
	public static Map<Integer,String> dm = new HashMap<Integer, String>();
	public static Map<Integer, String> oracleJava = new HashMap<Integer, String>();
	public static Map<Integer, String> oracleDb = new HashMap<Integer, String>();
	static {
		mysql.put(1, "String");
		mysql.put(4, "Integer");
		mysql.put(12, "String");
		mysql.put(8, "Double");
		mysql.put(93, "Date");
		mysql.put(3, "BigDecimal");
		mysql.put(-1, "BigDecimal");
		mysql.put(7, "Date");
		
		dm.put(1, "TIMESTAMP");
		dm.put(4, "Integer");
		dm.put(12, "String");
		dm.put(8, "Double");
		dm.put(93, "Date");
		
		
		oracleJava.put(2, "Integer");
		oracleJava.put(12, "String");
		oracleJava.put(93, "Date");
		oracleDb.put(2, "INTEGER");
		oracleDb.put(12, "VARCHAR");
		oracleDb.put(93, "TIMESTAMP");
	}
}
