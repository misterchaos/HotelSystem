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

package com.hyc.www.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于将请求参数映射为Javabean对象
 * @date 2019-04-15 00:47
 */
public class BeanUtils {

    /**
     * 负责将request中的parameterMap映射成为一个对象
     *
     * @param map   request中的getParameterMap返回的Map
     * @param clazz 映射的目标类，将返回该类的一个实例
     * @return java.lang.Object
     * @name toObject
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/15
     */
    public static Object toObject(Map<String, String[]> map, Class clazz) {
        /**
         * 本方法仅用来将request中的参数映射为对象，并不承担<br>
         * 数据检查的职责，因此本方法中产生的异常没有打印堆栈信息
         */
        LinkedList<Method> methods = new LinkedList<>();
        LinkedList<Field> fields = new LinkedList<>();
        /**
         * 这里clazz必须用claz代替，否则clazz将被修改
         */
        for (Class claz = clazz; claz != Object.class; claz = claz.getSuperclass()) {
            methods.addAll(Arrays.asList(claz.getDeclaredMethods()));
            fields.addAll(Arrays.asList(claz.getDeclaredFields()));
        }
        Object obj;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("无法实例化类：" + clazz.getName());
        }
        for (Field f : fields) {
            /**
             * 获取每个属性的String类型参数的构造器
             */
            Constructor cons = null;
            try {
                cons = f.getType().getConstructor(String.class);
            } catch (Exception e) {
                /**
                 * 某些属性确实没有这种构造器，在这里不需要处理这个问题
                 */
                System.out.println("该变量没有String类型参数的构造器"+f.getName());
            }
            /**
             * 构造属性
             */
            String[] param = map.get(f.getName());
            if (param != null && param[0] != null) {
                Object value = null;
                try {
                    if (cons != null) {
                        value = cons.newInstance(param[0]);
                    }
                    for (Method m : methods) {
                        if (m.getName().equalsIgnoreCase(StringUtils.field2SetMethod(f.getName()))) {
                            m.invoke(obj, value);
                        }
                    }
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException("无法初始化该属性 ："+param[0]);
                }
            }
        }
        return obj;
    }
}
