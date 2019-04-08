package com.hyc.www.dao;

import com.hyc.www.exception.DaoException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * @author HYC kobe524348@gmail.com
 * @program XHotel
 * @description 负责提供数据库连接池，向dao实现类提供数据库连接
 * @date 2019-04-08 00:29
 */
public class MyDataSource {
    /**
     * 配置文件路径
     */
    private static String propPath = "./src/db_config.properties";
    /**
     * 驱动类名称
     */
    private static String driver;
    /**
     * 初始连接数
     */
    private static int initCount;
    /**
     * 最大连接数
     */
    private static int maxCount;
    /**
     * 当前已经创建的连接数
     */
    private static int currentCount = 0;

    private static String url;
    private static String user;
    private static String password;
    private static MyDataSource instance;
    /**
     * 数据库连接池
     */
    private  LinkedList<Connection> connPool = new LinkedList<>();

    static {
        try {
            /**
             * 加载配置文件
             */
            Properties prop = new Properties();
            prop.load(new FileReader(new File(propPath)));
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            maxCount = Integer.parseInt(prop.getProperty("maxCount"));
            initCount = Integer.parseInt(prop.getProperty("initCount"));
            /**
             * 注册驱动
             */
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }


    /**
     * 负责提供数据库连接池实例
     *
     * @return com.hyc.www.dao.MyDataSource
     * @name getInstance
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    public static MyDataSource getInstance() {
        if (instance == null) {
            try {
                instance = new MyDataSource();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return instance;
    }


    /**
     * 负责从数据库连接池中获取数据库连接
     *
     * @return java.sql.Connection
     * @throws DaoException 如果数据库连接已经达到最大值时仍然调用此方法，则抛出此异常
     * @name getConnection
     * @notice 数据库连接的数量受到配置文件中最大值的限制
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    public Connection getConnection() throws DaoException {
        if (connPool.size() > 0) {
            return connPool.removeLast();
        } else if (currentCount < maxCount) {
            return createConnection();
        } else {
            throw new DaoException("数据库连接数已达到最大值");
        }
    }


    /**
     * 用于将数据库连接放回连接池中
     *
     * @param conn 数据库连接
     * @name free
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    public void free(Connection conn) {
        this.connPool.addLast(conn);
    }


    /**
     * 负责返回当前已经创建的连接数
     *
     * @return int 当前已经创建的连接数
     * @name getCurrentCount
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    public int getCurrentCount() {
        return currentCount;
    }

    /**
     * 负责返回当前池中剩余的空闲连接数
     *
     * @return int 当前空闲连接数
     * @name getfreeCount
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    public int getfreeCount() {
        return this.connPool.size();
    }

    /**
     * 创建连接("协议+访问的数据库名”，“用户名”，“密码”）
     *
     * @exception SQLException
     * @return java.sql.Connection
     * @name createConnection
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    private Connection createConnection() throws DaoException {
        currentCount++;
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DaoException("无法创建数据库连接",e);
        }
    }

    /**
     * 创建连接池实例，初始化数据库连接池
     *
     * @exception SQLException
     * @name MyDataSource
     * @author HYC kobe524348@gmail.com
     * @date 2019/4/8
     */
    private MyDataSource() throws SQLException {
        for (int i = 0; i < initCount; i++) {
            this.connPool.add(this.createConnection());
        }
    }
}
