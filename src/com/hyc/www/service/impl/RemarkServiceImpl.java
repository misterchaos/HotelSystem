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

package com.hyc.www.service.impl;

import com.hyc.www.dao.inter.RemarkDao;
import com.hyc.www.dao.inter.UserDao;
import com.hyc.www.po.Remark;
import com.hyc.www.service.Result;
import com.hyc.www.service.inter.RemarkService;
import com.hyc.www.util.BeanFactory;
import com.hyc.www.util.BeanUtils;
import com.hyc.www.vo.PagesVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;

import static com.hyc.www.service.constant.Status.ERROR;
import static com.hyc.www.service.constant.Status.SUCCESS;
import static com.hyc.www.util.ServiceUtils.setResult;
import static com.hyc.www.util.StringUtils.toLegalText;
import static com.hyc.www.util.UUIDUtils.getUUID;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description RemarkServiceImpl
 * @date 2019-04-23 01:30
 */
public class RemarkServiceImpl implements RemarkService {

    private RemarkDao dao = (RemarkDao) BeanFactory.getBean(BeanFactory.DaoType.RemarkDao);

    /**
     * 添加记录
     *
     * @param req
     * @param resp
     * @name add
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/23
     */
    @Override
    public Result add(HttpServletRequest req, HttpServletResponse resp) {
        Remark remark = (Remark) BeanUtils.toObject(req.getParameterMap(), Remark.class);
        remark.setId(getUUID());
        /**
         * 使用toLegalText过滤非法字符
         */
        remark.setRemark(toLegalText(remark.getRemark()));
        /**
         * 此处将留言中的用户名字段修改为用户的昵称
         */
        UserDao userDao = (UserDao) BeanFactory.getBean(BeanFactory.DaoType.UserDao);
        String userName = remark.getUserName();
        String nickName = userDao.getUser(remark.getUserName()).getNickName();
        remark.setUserName(userName+"("+nickName+")");
        if (dao.add(remark)) {
            PagesVo vo = new PagesVo();
            vo.setRemarks(dao.listAll());
            return new Result(SUCCESS, vo);
        }
        return setResult(ERROR);
    }

    /**
     * 返回所有评论
     *
     * @param req
     * @param resp
     * @name
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/23
     */
    @Override
    public Result listAll(HttpServletRequest req, HttpServletResponse resp) {
        LinkedList<Remark> remarks = dao.listAll();
        if (remarks != null) {
            PagesVo vo = new PagesVo();
            vo.setRemarks(remarks);
            return new Result(SUCCESS, vo);
        }
        return setResult(ERROR);
    }
}
