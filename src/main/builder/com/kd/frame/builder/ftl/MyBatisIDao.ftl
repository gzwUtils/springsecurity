package ${config.daoPackage};
 
import org.apache.ibatis.annotations.Mapper;

import com.ddxx.core.dao.BaseDao;
import ${config.entityPackage}.${table.entityName}VO;

/**
 * 
 * <p><b>${config.description}Dao</b></p>
 * @author Chao.yy #2018年3月13日 下午10:34:40 
 * @version V1.0
 */
@Mapper
public interface ${table.entityName}Dao extends BaseDao<${table.entityName}VO, String>{

}
