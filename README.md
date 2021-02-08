# ShardingSphere 分库分表demo

分库分表说明：

- 共有三个数据源：cent0，cent1，cent2；cent2为默认数据源（广播表及不分库分表的表会路由到cent2）
- 表格说明：t_order、t_order_item分库分表；student分库、t_country广播表、cat不分库分表

测试步骤：

1. 创建3个数据库分别命名为cent0、cent1、cent2
2. 运行建表语句（文件位于src/main/resources/sql）
3. 修改application.yml关于数据源相关配置
4. 运行src/test/com.heilan.shard.example下相关的测试类