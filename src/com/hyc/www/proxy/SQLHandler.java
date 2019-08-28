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

package com.hyc.www.proxy;

import com.hyc.www.annotation.InsertSQL;
import com.hyc.www.annotation.SQLParam;
import com.hyc.www.dao.impl.BaseDaoImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description
 * @date 2019-05-01 11:01
 */
public class SQLHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getAnnotation(InsertSQL.class) != null) {
            BaseDaoImpl baseDao = new BaseDaoImpl();
            /**
             * 默认没有sql语句，使用直接插入对象的方法
             */
            if ("".equalsIgnoreCase(method.getAnnotation(InsertSQL.class).value())) {
                Object obj = args[0];
                return baseDao.insert(obj) ;
            } else {
                String sql = method.getDeclaredAnnotation(InsertSQL.class).value();
                return baseDao.executeUpdate(sql, args);
            }
        }
        return null;
    }
}
