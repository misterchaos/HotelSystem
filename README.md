# Xhotel
------

[![release](https://img.shields.io/badge/release-1.0.0-green)](https://github.com/misterchaos/HotelSystem/releases)
[![release](https://img.shields.io/badge/version-beta-orange)](https://github.com/misterchaos/HotelSystem/releases)
[![release](https://img.shields.io/badge/build-passing-green)](https://github.com/misterchaos/HotelSystem/releases)

## :smile:Introduction

TopView工作室一轮考核项目：酒店管理系统（黄钰朝）

xhotel是一个酒店管理系统，提供查看房间，预订房间，个人信息管理，房间和酒店信息管理(管理员)等功能</br>
后台技术：Java,tomcat,mysql,servlet,jsp</br>

## :heavy_check_mark:Quick Start

### :point_right:[点击这里](http://www.cxkball.club:2333/index.jsp)立即体验

## :bulb:Information

开发者：黄钰朝</br>
联系邮箱：<a href="mailto:kobe524348@gmail.com">kobe524348@gmail.com</a></br>
项目开发时间：2019-04-04至2019-04-25</br>
版本号：1.0.0</br>
开源许可：Apache License 2.0</br>

## :sunny:Features

#### 1.登陆页面


![img](https://github.com/misterchaos/HotelSystem/blob/dev/项目截图/登陆功能.jpg)

#### 2.首页

#### ![img](https://github.com/misterchaos/HotelSystem/blob/dev/项目截图/主页.jpg)

#### 3.模糊查询房间


![img](https://github.com/misterchaos/HotelSystem/blob/dev/项目截图/模糊查询.jpg)

#### 4.留言板

![img](https://github.com/misterchaos/HotelSystem/blob/dev/项目截图/留言板.jpg)



## :triangular_flag_on_post:实现的功能

### 1.用户模块


- 注册功能
- 登陆功能
- 记住登陆状态，下次自动登陆
- 退出登陆
- 用户查看个人信息，修改自己的个人信息
- 用户上传自己的头像，修改自己的头像
- 用户修改自己的登陆密码
- 用户修改自己的支付密码
- 搜索房间，查看房间信息，预订房间
- 订单中可以选择入住时间，离开时间
- 订单中可以填写备注信息
- 用户查看自己的订单，取消自己的订单
- 可以在留言板中留言，查看别人的留言

### 2.管理员模块

- 管理员可以添加新用户
- 管理员可以添加新房间
- 管理员可以修改房间信息，删除房间

### 3.超级管理员

- 对酒店增删查改（无界面展示，仅完成到Dao层）



## :zap:代码特色

### 安全性

- 使用正则进行输入检查，不允许不合法数据进入数据库
- PrepareStatement防止sql注入
- 过滤标签注入
- 使用md5加密用户密码
- 使用uuid保证全局唯一性
- 空指针检查

### 代码复用性 

- 所有Dao都是BaseDao的子类，子类只负责处理对应Service层传入的数据
  和书写部分sql语句，所有数据库操作都在BaseDao的两个方法中
- po层使用继承体系，所有实体都（直接或间接）继承BaseEntity,存储数据库表的id,status，gmt_create,和gmt_modified信息，
  并且房间和服务都继承Product类，房间和服务订单都继承Order
- md5加密，获取uuid,等等功能放到工具类复用
- 重复代码抽取重构，使用模板方法和策略模式等优化代码

### 可维护性

- 代码注释：绝大部分代码都提供了类注释，方法注释，属性注释
- 接口文档：使用javadoc注释，提供API文档
- 面向接口编程：Dao层和Service层都向上提供接口，与实现类分离
- 封装性：po，vo层只有getter和setter方法
- 健壮性：绝大多数类都有对应的测试类，并且经过多轮测试
- 规范性: 统一前端请求参数规范，使用枚举类管理请求参数
- 使用配置文件，数据库配置,连接池配置，工厂配置全部与代码分离
- MVC设计模式：servlet中没有页面输出，jsp中没有java代码，数据处理
  都下放到service层
- 几乎没有“魔法值”：绝大多数的常量使用枚举类，极少数使用final变量，
  剩下的是前端部分请求参数中的常量
- 避免代码污染：将CheckException封装成RuntimeException再向
  上层抛出，避免各层之间出现耦合 
- 单一职责：每个Service都有自己对应的Dao层实现类，每个Service和Dao可以单独完成自己的功能

### 封装数据的入口和出口：  

- 前端数据：所有的请求参数通过BeanUtils映射成实体类对象，在此过程统一过滤标签注入
- 持久化数据：所有的数据库更新操作和数据库查询操作都封装在BaseDaoImpl的executeUpdate和executeQuery
  方法中，只有这两个方法中向数据库连接池取连接，资源统一获取和释放
- 查询结果集数据：BaseDaoImpl封装了所有的数据库更新操作和大部分的查询操作，只有少数查询
  通过子类传入sql语句执行，结果集的处理全部由BaseDaoImpl封装
- 状态和处理结果：service层返回的转台码和处理后的数据，全部放在Result中返回
- 页面数据：所有返回前端的数据都放在PageVo中返回

### 性能

- 手写数据库连接池，提高访问数据库性能

### 设计模式

- 工厂模式
- 单例模式
- 策略模式
- 装饰模式
- 模板方法
- MVC模式



## :page_facing_up:项目开发日志：

#### 4月20日更新：构建基本的jsp页面

#### 4月17日更新：构建房间，订单等服务

#### 4月14日更新：构建控制层，UserService实现

#### 4月12日更新：构建房间，订单Dao实现

#### 4月11日更新：构建UserDao

#### 4月10日更新：构建基础Dao层

#### 4月9日更新：初步构建Dao层

#### 4月8日更新：构建数据库连接池

#### 4月7日更新：建立项目

#### 4月3日更新：提交项目需求分析（项目命名：Xhotel）

#### 4月1日更新：目前处于需求分析，建立数据模型和业务流程初步设计阶段

#### 3月30日更新：刚刚完成CAT工作室的项目，加上QG训练营有任务，暂未开始动手

#### 准备先好好总结一下CAT项目的经验，并且把一些遇到的问题理解清楚再动手写这个项目

### 

## :star:License

本软件仅供交流学习，不得用于商业用途

Copyright 黄钰朝 

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

```
   http://www.apache.org/licenses/LICENSE-2.0
```

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

