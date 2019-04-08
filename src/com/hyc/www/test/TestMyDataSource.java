package com.hyc.www.test;

import com.hyc.www.dao.MyDataSource;
import com.hyc.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author HYC kobe524348@gmail.com
 * @program XHotel
 * @description 用于测试数据库连接池
 * @date 2019-04-08 02:11
 */
public class TestMyDataSource {
    public static void main(String[] args) {
        System.out.println("测试直接从连接池获取连接");
        MyDataSource dataSource = MyDataSource.getInstance();
        System.out.println("获取一个连接\n");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        System.out.println("当前已创建连接数 = " + dataSource.getCurrentCount());
        System.out.println("当前空闲连接数 = " + dataSource.getfreeCount());
        System.out.println("释放一个连接");
        dataSource.free(conn);
        for (int i = 0; i < 10; i++) {
            conn = dataSource.getConnection();
            System.out.println(conn);
            dataSource.free(conn);
        }
        System.out.println("释放一个连接");
        dataSource.free(conn);
        System.out.println("当前已创建连接数 = " + dataSource.getCurrentCount());
        System.out.println("当前空闲连接数 = " + dataSource.getfreeCount());

        System.out.println("测试通过jdbcUtil获取连接");
        for (int i = 0; i < 10; i++) {
            conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }
        System.out.println("释放一个连接");
        dataSource.free(conn);
        System.out.println("当前已创建连接数 = " + dataSource.getCurrentCount());
        System.out.println("当前空闲连接数 = " + dataSource.getfreeCount());
    }
}
