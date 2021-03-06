HRM_TEST
-----------
一个简单的人员管理系统，由java和mysql实现

### 主要功能：

> 1. 对员工信息的增加
> 2. 对员工信息的修改
> 3. 对员工信息的删除
> 4. 查看数据库中所有员工的信息
> 5. 通过关键字检索员工的信息记录(通过与所有的字段进行匹配进行检索)！

### 开发环境和工具：

- oracle jdk_1.8
- mysql Server version: 5.7.17-0ubuntu0.16.04.1 (Ubuntu)
- Ubuntu 16.04
- eclispe Neon.2 Release (4.6.2)

### 设计模式：

- 使用代理模式进行设计,将要使用到的方法都放到接口IPersonDAO.java中；
- 使用数据库代理来进行分工，设计和安排业务功能，IPersonDAOProxy.java；
- 将接口中的函数在IPersonDAOImplement.java中一一进行实现，用以支撑业务功能；
- 使用“工厂”设计模式，实例化接口，进而对代理类中的业务进行耦合。

### 关键技术

- 设计模式，使用面向对象的方法进行合理的类的结构划分
- 使用SimpleDateFormat类进行日期格式的转换
- 使用JDBC进行数据库的相关操作
- 使用J2SE中的集合进行数据的临时取出和便利操作

### 目录:

![HRM 目录](https://github.com/Nutao/HRM_TEST/blob/1a2a6c81e9f144de47d5ff35b1615fd42241e40a/imgs/content.png?raw=true)

### 增加员工信息

![HRM 1](https://github.com/Nutao/HRM_TEST/raw/1a2a6c81e9f144de47d5ff35b1615fd42241e40a/imgs/1.png?raw=true)

### 修改员工信息

![HRM 2](https://github.com/Nutao/HRM_TEST/blob/1a2a6c81e9f144de47d5ff35b1615fd42241e40a/imgs/2.png?raw=true)

### 删除员工信息
![HRM 3](https://github.com/Nutao/HRM_TEST/raw/1a2a6c81e9f144de47d5ff35b1615fd42241e40a/imgs/3.png?raw=true)


### 通过关键字检索员工信息
![HRM 5](https://github.com/Nutao/HRM_TEST/blob/1a2a6c81e9f144de47d5ff35b1615fd42241e40a/imgs/5_1.png?raw=true)
![HRM 5](https://github.com/Nutao/HRM_TEST/blob/1a2a6c81e9f144de47d5ff35b1615fd42241e40a/imgs/5_2.png?raw=true)
