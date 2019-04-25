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

package com.hyc.www.controller.listener;

import com.hyc.www.service.inter.OrderRoomService;
import com.hyc.www.service.inter.RemarkService;
import com.hyc.www.service.inter.RoomService;
import com.hyc.www.service.inter.UserService;
import com.hyc.www.util.BeanFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责监听servlet的初始化和销毁事件
 * @date 2019-04-13 22:41
 */

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /**
         * 注册服务单例
         */
        ServletContext sc = sce.getServletContext();
        UserService userService = (UserService) BeanFactory.getBean(BeanFactory.ServiceType.UserService);
        sc.setAttribute("userService",userService);
        RoomService roomService = (RoomService) BeanFactory.getBean(BeanFactory.ServiceType.RoomService);
        sc.setAttribute("roomService",roomService);
        OrderRoomService orderRoomService = (OrderRoomService)BeanFactory.getBean(BeanFactory.ServiceType.OrderRoomService);
        sc.setAttribute("orderRoomService",orderRoomService);
        RemarkService remarkService = (RemarkService) BeanFactory.getBean((BeanFactory.ServiceType.RemarkService));
        sc.setAttribute("remarkService",remarkService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
