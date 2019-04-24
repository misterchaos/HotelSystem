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

package com.hyc.www.vo;

import com.hyc.www.po.*;

import java.util.LinkedList;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program XHotel
 * @description 负责向前端传输首页页面数据
 * @date 2019-04-18 00:49
 */
public class PagesVo {

    private LinkedList<Room> rooms;
    private LinkedList<Hotel> hotels;
    private LinkedList<User> users;
    private LinkedList<OrderRoom> orderRooms;
    private LinkedList<Picture> pictures;
    private LinkedList<Remark> remarks;
    private String message;
    private int maxPage;
    private int count;

    public LinkedList<Remark> getRemarks() {
        return remarks;
    }

    public void setRemarks(LinkedList<Remark> remarks) {
        this.remarks = remarks;
    }

    public LinkedList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(LinkedList<Room> rooms) {
        this.rooms = rooms;
    }

    public LinkedList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(LinkedList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LinkedList<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(LinkedList<Picture> pictures) {
        this.pictures = pictures;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public LinkedList<OrderRoom> getOrderRooms() {
        return orderRooms;
    }

    public void setOrderRooms(LinkedList<OrderRoom> orderRooms) {
        this.orderRooms = orderRooms;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
