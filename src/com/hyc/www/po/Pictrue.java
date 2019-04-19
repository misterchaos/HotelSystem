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

package com.hyc.www.po;

import com.hyc.www.po.abs.BaseEntity;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 图片
 * @date 2019-04-19 18:59
 */
public class Pictrue  extends BaseEntity {
    String authorId;
    String pictrue;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getPictrue() {
        return pictrue;
    }

    public void setPictrue(String pictrue) {
        this.pictrue = pictrue;
    }
}
