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

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 用于对用户的密码进行摘要处理
 * @date 2019-04-16 00:50
 */
public class Md5Utils {
    private static final String ENCODING = "UTF-8";

    private Md5Utils() {
    }

    public static String getDigest(String originText) {
        MessageDigest md = null;
        byte[] digest = null;
        try {
            md = MessageDigest.getInstance("md5");
            digest = md.digest(originText.getBytes(ENCODING));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无法支持md5加密", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("无法支持UTF-8编码格式", e);
        }
        return Base64.getEncoder().encodeToString(digest);
    }
}
