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

package com.hyc.www.test;

import com.hyc.www.dao.impl.RemarkDaoImpl;
import com.hyc.www.dao.inter.RemarkDao;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 测试RemarkDao
 * @date 2019-04-23 01:24
 */
public class TestRemarkDao {
    public static void main(String[] args) {
        RemarkDao dao  = new RemarkDaoImpl();
        System.out.printf(dao.listAll().get(0).getRemark());
    }
}
