# 介绍
SpringMVC + MyBatis + DubboX 框架

##结构剖析
```
cash-parent   父POM，所有三方包的依赖都在此处定义
  cash-app    主应用工程，客户端（PC,IPAD,移动设备）请求入口
  cash-service-facade 定义RPC交互的第三方DUBBOX服务API
  cash-service-integration 需要依赖的第三方外部服务（例如短信，个推，高德地图等）
  cash-biz-shared     业务域层，主要用来编写核心业务，提供给cash-app层调用
  cash-dal     数据库交互定义层，该层主要用来定义与数据库相关的操作
  cash-util    工具层，定义项目中各处需要用到的工具类
  dalgen       一种基于SQL模板自动生成mybaties配置文件的技术
  cash-core-service 基础业务组件层，该层用来根据业务特征编写的公共业务组件代码
  cash-model   数据模型层。介于DO与BIZ之间的中间层，用来组装和转换从业务对象到DO数据之间的转换
  cash-service-impl 第三方DUBBOX服务接口的实现层
  cash-biz-task 定时任务层

```
##多环境支持
```
  cash-app 的src/main/resources/conf目录下定义了dev,prod,test三套环境配置，使用时根据各个环境分别配置。
  执行 mvn clean package -Pdev -Dmaven.test.skip=true 打的是开发环境的配置包
  执行 mvn clean package -Pprod -Dmaven.test.skip=true 打的是线上环境的配置包
  执行 mvn clean package -Ptest -Dmaven.test.skip=true 打的是测试环境的配置包
 ```
##简化操作支持
```
 1.执行 mvn mybatis-generator:generate 命令可以直接基于开发环境生成数据库相关的MYBATIES DAO,XML层的代码，可直接使用；
 2.执行 mvn mybatis:gen 命令可以直接根据自定义的SQL模板生成数据库相关的MYBATIES DAO,XML层的代码,可直接使用；对于数据库操作SQL有洁癖的同学可以使用
 3.执行 mvn tomcat7:run -Dprofiles.activation=dev 命令可以直接启动内置的TOMCAT容器测试代码
```
##采用SPRING4,支持最新的SRPING新特性和简化标签

##集成阿里Druid数据源，可动态的监控SQL的执行状况，进行SQL优化
```
http://127.0.0.1/druid/ 
登录账号密码均是yylc
```
##分页支持
```
直接在DAL数据操作层方法上入参增加PageBounds page参数可自动装配分页数据
例：public StudentDO queryByFullMinusNo(Long id,PageBounds page);
```

##多协议支持
内部服务RPC调用支持DUBBO,HESSIEN,HTTP等协议

