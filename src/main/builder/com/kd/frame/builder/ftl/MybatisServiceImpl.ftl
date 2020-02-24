package ${config.servicePackage}.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddxx.core.dao.BaseDao;
import com.ddxx.core.service.impl.BaseServiceImpl;


import ${config.daoPackage}.${table.entityName}Dao;
import ${config.entityPackage}.${table.entityName}VO;
import ${config.servicePackage}.${table.entityName}Service;

@Service
public class ${table.entityName}ServiceImpl extends BaseServiceImpl<${table.entityName}VO, String> implements  ${table.entityName}Service {
    @Autowired
    private ${table.entityName}Dao dao;
  
    @Override
    public BaseDao<${table.entityName}VO, String> getDao() {
        return dao;
    }
}

