package ${config.entityPackage};


import com.ddxx.core.dao.PropertyMapper;
import io.swagger.annotations.ApiModel;

/**
 * 
 * <p><b>${config.description}实体类</b></p>
 * @author Chao.yy  #2018年06月04日 下午2:53:18
 * @version V1.0
 */
@ApiModel(description = "${config.description}对象")
public class ${table.entityName}VO implements java.io.Serializable, PropertyMapper {


    private static final long serialVersionUID = 1L;

    <#list table.columns as column>
    private ${column.javaType} ${column.javaName};
    </#list>

    <#list table.columns as column>
    public ${column.javaType} get${column.javaName?cap_first}() {
        return this.${column.javaName};
    }

    public void set${column.javaName?cap_first}(${column.javaType} ${column.javaName}) {
        this.${column.javaName} = ${column.javaName};
    }
    </#list>
    
    @Override
    public String getPropertyMapper(String property) {
        String columnName = null;
        switch (property) {
         <#list table.columns as column>
        case "${column.javaName}":
            columnName = "${column.dbName}";
            break;
         </#list>
        default:
            columnName = null;
            break;
        }
        return columnName;
    }
}