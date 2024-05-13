# 图书馆管理系统（lms）

## 技术选型

JDK版本：1.8

前端：Vue3、Echarts、ElementPlus

后端：SpringBoot、Mybatis-Plus、Json、JWT

数据库：MySQL

## 主要功能

管理员模块：注册、登录、书籍管理、读者管理、借阅管理、借阅者权限管理、借阅状态、修改个人信息、修改密码

读者模块：注册、登录、查询图书信息、借阅和归还图书、查看个人借阅记录、修改个人信息、修改密码

## 代码结构

### 前端

```shell
vue
├─api			// api接口
├─assets		// 资源文件	
│  ├─icon	 	// 图标
│  └─css	 	// 样式
├─img    	 	// 图片
├─components	        // 自定义Vue组件
├─layout		// 页面布局
├─router		// Vue路由
├─utils			// 工具函数
├─store                 // Vuex状态管理
└─views			// 页面
```

### 后端

```shell
spring
├─java
│  └─com
│      └─sunny
│          └─lms
│              ├─LmsApplication         // 项目启动文件
│              ├─common			// 通用类
│              ├─controller		// 控制层
│              ├─entity			// 实体类
│              ├─mapper			// 持久层
│              └─service		// 业务层
└─resources	// maven资源配置
```
### 前端启动
```shell
npm install  #安装所需依赖
npm run serve  # 启动前端项目
npm build      # 打包前端项目(dist)部署
```
### 后端启动
1.运行根目录中的sql文件，测试连接数据库

2.启动本地redis服务(window或者docker部署，短信服务可选)

3.添加阿里云短信服务Key和pwd（短信服务可选）

4.运行springboot启动类

5.SmsUtils.sendSms(phone, code);阿里短信服务（可选、不选不会报错不会影响运行） 
