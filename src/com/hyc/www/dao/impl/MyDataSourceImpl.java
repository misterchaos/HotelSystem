/*
 * Copyright (c) 2019.  黄钰朝
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hyc.www.dao.impl;

import com.hyc.www.dao.inter.MyDataSource;
import com.hyc.www.exception.DaoException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 实现了MyDataSource接口，负责提供数据库连接池，向dao实现类提供数据库连接
 * @date 2019-04-08 23:13
 */
public class MyDataSourceImpl implements MyDataSource {
    /**
     * 配置文件路径
     */
    private static String PROP_PATH ="data_source.properties";
    /**
     * 测试数据库连接的等待时长
     */
    private static int TIMEOUT;
    /**
     * 初始连接数
     */
    private static int INIT_SIZE;
    /**
     * 最大连接数
     */
    private static int MAX_SIZE;
    /**
     * 当前已经创建的连接数
     */
    private static int currentCount = 0;

    private static String url;
    private static String user;
    private static String password;
    private static MyDataSourceImpl instance;
    /**
     * 数据库连接池
     */
    private LinkedList<Connection> connPool = new LinkedList<>();

    static {
        try {
            /**
             * 加载配置文件
             */
            Properties prop = new Properties();
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROP_PATH));
            /**
             * 驱动类名称
             */
            String driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            MAX_SIZE = Integer.parseInt(prop.getProperty("MAX_SIZE"));
            INIT_SIZE = Integer.parseInt(prop.getProperty("INIT_SIZE"));
            TIMEOUT = Integer.parseInt(prop.getProperty("TIMEOUT"));
            /**
             * 注册驱动
             */
            Class.forName(driver);
            instance= new MyDataSourceImpl();
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
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    public static MyDataSourceImpl getInstance() {
        return instance;
    }


    /**
     * 负责从数据库连接池中获取数据库连接
     *
     * @return java.sql.Connection
     * @throws DaoException 如果数据库连接已经达到最大值时仍然调用此方法，则抛出此异常
     * @name getConnection
     * @notice 数据库连接的数量受到配置文件中最大值的限制
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    @Override
    public Connection getConnection() throws DaoException {
        if (connPool.size() > 0) {
            /**
             * 先检查连接是否可用，如果不可用，关闭该连接，返回一个新连接
             */
            Connection conn = connPool.removeLast();
            try {
                if(conn.isValid(TIMEOUT)){
                    return conn;
                }else {
                    destroyConnection(conn);
                    return createConnection();
                }
            } catch (SQLException e) {
                throw new DaoException("测试数据库连接产生异常",e);
            }
        } else if (currentCount < MAX_SIZE) {
            return createConnection();
        } else {
            throw new DaoException("数据库连接数已达到最大值");
        }
    }


    /**
     * 用于将数据库连接放回连接池中
     *
     * @param conn 数据库连接
     * @name freeConnection
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    @Override
    public void freeConnection(Connection conn) {
        this.connPool.addLast(conn);
    }


    /**
     * 负责返回当前已经创建的连接数
     *
     * @return int 当前已经创建的连接数
     * @name getCurrentCount
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    @Override
    public int getCurrentCount() {
        return currentCount;
    }

    /**
     * 负责返回当前池中剩余的空闲连接数
     *
     * @return int 当前空闲连接数
     * @name getfreeCount
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    @Override
    public int getfreeCount() {
        return this.connPool.size();
    }

    /**
     * 创建连接("协议+访问的数据库名”，“用户名”，“密码”）
     *
     * @return java.sql.Connection
     * @name createConnection
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
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
     * 关闭数据库连接
     *
     * @return java.sql.Connection
     * @name createConnection
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/30
     */
    private void destroyConnection(Connection conn) throws DaoException {
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            throw new DaoException("关闭数据库连接异常",e);
        }
    }


    /**
     * 创建连接池实例，初始化数据库连接池
     *
     * @name MyDataSource
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/8
     */
    private MyDataSourceImpl() {
        for (int i = 0; i < INIT_SIZE; i++) {
            this.connPool.add(this.createConnection());
        }
    }
}
