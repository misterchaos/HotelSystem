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


import com.hyc.www.service.constant.Status;

import java.io.File;

import static com.hyc.www.service.constant.Status.SUCCESS;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于测试与文件路径相关的方法
 * @date 2019-04-08 02:19
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("./src/db_config.properties");
        System.out.println(file.getAbsolutePath());
    }
}
