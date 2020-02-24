配置
path文件配置：
#生成文件的路径
outPath=d://src/
#生成文件的包路径
packagePath=com.ddxx.etl
#服务层所在包
servicePackage=com.kd.authorization.service
#数据库连接层层所在包
daoPackage=com.kd.authorization.dao
#mapping文件所在包
mapperPackage=com.kd.authorization.mapping
#控制层层所在包
actionPackage=com.kd.authorization.action
#实体层所在包
entityPackage=com.kd.authorization.entity
#暂时无用
pagePahe=view
#数据库表名称,隔开
tableNames=FW_AUTH_ACCOUNT,FW_AUTH_ROLE,FW_AUTH_MENU
#对应实体名称 ,隔开
entityNames=Account,Role,Menu
#表主键（主键对应的java属性名称，所以小写。
注equipment_id变为equipmentId） ,隔开
pkNames=id,id,id
#数据库
db=oracle

数据库文件配置：
driver=oracle.jdbc.driver.OracleDriver
uname=TEST
pwd=root
url=jdbc\:oracle\:thin\:@localhost\:1521\:ORCL


结构：
jdbc 中修改连接参数
tablefactory 提供根据表名生产table对象
load 中修改生成的东西
fileutil load生成的stringBuilder 写到文件中
builder 是进一步封装 
dao ，domain ， prop 都是处理与数据库进行连接