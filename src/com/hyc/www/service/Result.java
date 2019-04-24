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

package com.hyc.www.service;

import com.hyc.www.service.constant.Status;
import com.hyc.www.vo.PagesVo;

/**
 * 用于向控制层返回数据和状态
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description
 * @date 2019-04-22 17:11
 */
public class Result {
    /**
     * 服务状态枚举常量
     */
    private Status status;
    /**
     * 返回的数据
     */
    private PagesVo data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PagesVo getData() {
        return data;
    }

    public void setData(PagesVo data) {
        this.data = data;
    }

    public Result(Status status, PagesVo data) {
        this.status = status;
        this.data = data;
    }

    public Result(Status status) {
        this.status = status;
    }

    public Result(PagesVo data) {
        this.data = data;
    }

    public Result() {
    }
}
