#SSM-CRM
基本的SSM框架，实现crm简单的客户查询修改功能

#版本选择
框架版本尽量采用新的

JDK 1.8

Spring 5.0.4.RELEASE

Junit 4.12

Servlet 4.0

Jsp 2.3.1

web.xml 3.0

连接池有druid和c3p0，建议是用druid

运行插件配置了tomcat和jetty

测试URL
http://localhost:8080/customer/list

#数据库连接
## 关于数据库连接遇到的问题
mysql-connector-java使用了高版本6.0.6结果遇到如下问题
c3p0需要加入这个参数serverTimezone=UTC
druid需要在上面的基础上再修改驱动jdbc.driver=com.mysql.cj.jdbc.Driver