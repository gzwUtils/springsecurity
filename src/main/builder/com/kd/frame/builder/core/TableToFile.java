package com.kd.frame.builder.core;

import java.io.File;

import com.kd.frame.builder.domain.Configruation;
import com.kd.frame.builder.domain.Table;
import com.kd.frame.builder.maker.MybatisMaker;
import com.kd.frame.builder.util.FileUtil;

/**
 * 加载配置文件 
 * @author Jane Wang    2017年5月16日 上午9:56:43
 */
public class TableToFile {

    public static void buildAllForEntity(Table table, Configruation conf) {
        //加载load 
        MybatisMaker load = new MybatisMaker(table, conf);
        String fileName = table.getEntityName();
        //设置路径
        String path = conf.getOutPath();
        String pagePath = path + "/" + toDir(conf.getPagePath());
        String IdaoPath = path + "/" + toDir(conf.getDaoPackage());
        String daoPath = path + "/" + toDir(conf.getMapperPackage());
        String IservciePath = path + "/" + toDir(conf.getServicePackage());
        String servciePath = IservciePath + "/impl";
        String actionPath = path + "/" + toDir(conf.getActionPackage());
        String domainPath = path + "/" + toDir(conf.getEntityPackage());
        //生成到文件
        File daoDir = new File(daoPath);
        File idaoDir = new File(IdaoPath);
        File serviceDir = new File(IservciePath);
        File iserviceDir = new File(servciePath);
        File actionDir = new File(actionPath);
        File domainDir = new File(domainPath);
        File pageDir = new File(pagePath);
        //1.生成文件夹
        daoDir.mkdirs();
        idaoDir.mkdirs();
        serviceDir.mkdirs();
        iserviceDir.mkdirs();
        actionDir.mkdirs();
        domainDir.mkdirs();
//        pageDir.mkdirs();
        //2.生成到domian
        String makeEntity = load.makeEntity();
        FileUtil.out(domainPath, fileName + "VO.java", makeEntity);
        //3.生成dao
        String makeDao = load.makeDaoMapper();
        String makeDaoI = load.makeDaoInterface();
        FileUtil.out(daoPath, fileName + "Mapper.xml", makeDao);
        FileUtil.out(IdaoPath, fileName + "Dao.java", makeDaoI);
        //4.生成service 
        String makeService = load.makeService();
        String makeServiceI = load.makeServiceInterface();
        FileUtil.out(servciePath, fileName + "ServiceImpl.java", makeService);
        FileUtil.out(IservciePath, fileName + "Service.java", makeServiceI);
        //5.生成action 
        String makeAction = load.makeAction();
        FileUtil.out(actionPath, fileName + "Controller.java", makeAction);
        //5.生成page
//        String list = load.makeListPage();
//        String save = load.makeSavePage();
//        String edit = load.makeEditPage();
//        FileUtil.out(pagePath, "list.jsp", list);
//        FileUtil.out(pagePath, "save.jsp", save);
//        FileUtil.out(pagePath, "edit.jsp", edit);
    }

    public static String toDir(String str) {
        return str.replace(".", "/");
    }
}
