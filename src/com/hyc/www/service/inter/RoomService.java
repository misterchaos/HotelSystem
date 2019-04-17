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

package com.hyc.www.service.inter;

import com.hyc.www.service.constant.ServeConsts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责提供房间相关的服务
 * @date 2019-04-16 23:32
 */
public interface RoomService {
    ServeConsts.Status add(HttpServletRequest req, HttpServletResponse resp);

    ServeConsts.Status delete(HttpServletRequest req, HttpServletResponse resp);

    ServeConsts.Status update(HttpServletRequest req, HttpServletResponse resp);

    ServeConsts.Status find(HttpServletRequest req, HttpServletResponse resp);

}
