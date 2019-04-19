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

import javax.servlet.http.Part;
import java.io.IOException;

import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于上传文件
 * @date 2019-04-19 13:31
 */
public class UploadUtils {


    /**
     * 用于上传一个文件，返回该文件的文件名
     *
     * @return String 存储的文件名
     * @name
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/19
     */
    public static String upload(Part part) throws IOException {
        String head = part.getHeader("Content-Disposition");
        String filename = getUUID() + head.substring(head.lastIndexOf("."), head.lastIndexOf("\""));
        part.write(filename);
        return filename;
    }
}
