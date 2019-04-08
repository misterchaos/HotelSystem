package com.hyc.www.util;

import com.hyc.www.dao.MyDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author HYC kobe524348@gmail.com
 * @program XHotel
 * @description 用于从数据库连接池中获取连接和将连接放回数据库连接池
 * @date 2019-04-08 03:00
 */
public class JdbcUtils {

    private static MyDataSource dataSrc =  MyDataSource.getInstance();

    private JdbcUtils() {

    }


    /**
     * 负责从数据库连接池中获取数据库连接
     *
     * @return java.sql.Connection
     * @name getConnection
     * @notice 数据库连接的数量受到配置文件中最大值的限制
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    public static Connection getConnection()  {
        return dataSrc.getConnection();
    }


    /**
     * 用于将数据库连接放回连接池中,并释放Statement和ResultSet的资源
     *
     * @param conn 数据库连接
     * @name close
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            dataSrc.free(conn);
        }
    }

    /**
     * 用于将一个数据库连接放回连接池中
     *
     * @param conn 数据库连接
     * @name close
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    public static void close(Connection conn){
        if (conn != null) {
            dataSrc.free(conn);
        }
    }



}
