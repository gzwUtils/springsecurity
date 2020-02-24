<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#assign x="${">
<#assign f="}">
<#assign s="#{">
<mapper namespace="${config.packagePath}.dao.${table.entityName}Dao">
   <sql id="tableName">${table.tableName}</sql>
   <sql id="baseColumnList">
		<#list table.columns as item>
         ${item.dbName}<#if item_has_next>,</#if>
    	</#list>
	</sql> 
	<resultMap id="baseResultMap"
		type="${config.entityPackage}.${table.entityName}VO">
		 <#list table.columns as item>
       <result column="${item.dbName}" property="${item.javaName}"/>
   		 </#list>
	</resultMap>
     
     <insert id="save" parameterType="${config.entityPackage}.${table.entityName}VO">
		INSERT INTO
		<include refid="tableName" />
		(
		<include refid="baseColumnList" />
		)
		values 
           (
           <#list table.columns as item>${s}${item.javaName},jdbcType=${item.dbType}${f}<#if item_has_next>,</#if>
           </#list>
           )
	</insert> 
     
    <insert id="saveForBatch" parameterType="java.util.List">
		INSERT INTO
		<include refid="tableName" />
		(
		<include refid="baseColumnList" />
		)
		values
		<foreach collection="list" separator="," item="item">
            (<#list table.columns as item>
            	${s}${item.javaName},jdbcType=${item.dbType}${f}<#if item_has_next>,</#if></#list>
             )
        </foreach>
	</insert>
     
     <update id="updateByKey"
		parameterType="${config.entityPackage}.${table.entityName}VO">
		UPDATE
		<include refid="tableName" />
		SET
		<#list table.columns as item>
			${item.dbName}= ${s}${item.javaName},jdbcType=${item.dbType}${f}<#if item_has_next>,</#if>
		</#list>
		WHERE ${table.keyName} = ${s}${table.keyColumn.javaName},jdbcType=${table.keyColumn.dbType}${f}	
	</update>

	<update id="updateByKeySelective"
		parameterType="${config.entityPackage}.${table.entityName}VO">
		UPDATE
		<include refid="tableName" />
		<set>
		<#list table.columns as item>
		<if test="${item.javaName} != null">
			${item.dbName}= ${s}${item.javaName},jdbcType=${item.dbType}${f}<#if item_has_next>,</#if>
		</if>
		</#list>
		</set>
		WHERE ${table.keyName} = ${s}${table.keyColumn.javaName},jdbcType=${table.keyColumn.dbType}${f}
	</update>

	<delete id="removeByKey" parameterType="java.lang.String">
		DELETE FROM
		<include refid="tableName" />
		WHERE  ${table.keyName}  = ${s}id,jdbcType=${table.keyColumn.dbType}${f}
	</delete>

	<delete id="removeForBatch">
		DELETE FROM
		<include refid="tableName" />
		WHERE ${table.keyName} in
		<foreach index="index" item="item" collection="ids" open="("
			separator="," close=")">
			${s}item${f}
		</foreach>
	</delete>
	
	<delete id="removeByCondition">
		DELETE FROM
		<include refid="tableName" />
		<where>
			<foreach item="item" index="index" collection="params">
				AND
				${x}item.columnName${f} ${x}item.operator${f} ${s}item.value${f}
			</foreach>
		</where>
	</delete>

	<select id="queryList" resultMap="baseResultMap">
		SELECT
		<include refid="baseColumnList" />
		FROM
		<include refid="tableName" />
		WHERE 1=1
	</select>

	<select id="queryByKey" parameterType="java.lang.String"
		resultMap="baseResultMap">
		SELECT
		<include refid="baseColumnList" />
		FROM
		<include refid="tableName" />
		WHERE ${table.keyName}  = ${s}id,jdbcType=${table.keyColumn.dbType}${f}
	</select>

	<select id="queryListByCondition" resultMap="baseResultMap">
		SELECT
		<include refid="baseColumnList" />
		FROM
		<include refid="tableName" />
		<where>
			<foreach item="item" index="index" collection="params">
				AND
				${x}item.columnName${f} ${x}item.operator${f} ${s}item.value${f}
			</foreach>
		</where>
	</select>
</mapper>
