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

package com.hyc.www.dao.inter;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于将属性映射成sql预编译语句
 * @date 2019-04-11 17:55
 * @see com.hyc.www.dao.impl.BaseDaoImpl
 */
public interface SqlMapper {


    /**
     * 用于将一个或多个参数映射成预编译sql语句
     *
     * @param params 可变参数，允许传递多个映射sql语句所需的源数据
     * @return 返回映射之后的预编译sql语句
     * @name doMap
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/12
     */
    String doMap(Object... params);

}
