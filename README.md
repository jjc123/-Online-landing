# -Online-landing
Javaweb实现在线登陆小Demo

界面比较简陋，主要是实现功能
# 需求：
1.登陆页面登陆成功进入主页且添加该对象于在线名单，  
跳转主页显示成员  如果失败跳转回登陆页面 
2.登陆成功后显示全部成员列表，可点击查看在线成员，
3.退出即没有权限访问其他资源 且在在线成员中清除
4.同一个浏览器打开登陆后不允许再一次登陆
5.不同浏览器不能登陆别地已经登陆的账号
 
 
# 流程
## 若别地登陆报错：

![](https://github.com/jjc123/-Online-landing/blob/master/image/1.png?raw=true )
## 若账号密码错误：

![](https://github.com/jjc123/-Online-landing/blob/master/image/4.png?raw=true )

## 账号密码正确，且无登录状态即登陆成功跳转到主页，显示所有成员
![](https://github.com/jjc123/-Online-landing/blob/master/image/2.png?raw=true )

## 查看在线成员
![](https://github.com/jjc123/-Online-landing/blob/master/image/3.png?raw=true )

## 添加所需的数据库
```
mysql -uroot -p login < D:/login.sql
Enter password: ******
```

添加所需的jar包：
https://pan.baidu.com/s/1ISTPDQOYF4Ofa6CO4XEoTQ
