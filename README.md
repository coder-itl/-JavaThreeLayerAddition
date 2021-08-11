###  说明文档



####  JavaThreeLayerAddition

+ `java`三层架构实现

+ 目录结构

  ```bash
  E:.
  │  .gitignore
  │  PersonProj.iml
  │  README.md
  │
  ├─.idea
  │  │  .gitignore
  │  │  misc.xml
  │  │  modules.xml
  │  │  runConfigurations.xml
  │  │  uiDesigner.xml
  │  │  workspace.xml
  │  │
  │  └─libraries
  │          libs.xml
  │
  ├─libs
  │      mysql-connector-java-5.1.47.jar
  │
  ├─out
  │  └─production
  │      └─PersonProj
  │          │  db.properties
  │          │
  │          └─com
  │              └─coderitl
  │                  ├─advanced
  │                  │  │  RowMapper.class
  │                  │  │
  │                  │  └─impl
  │                  │          PersonRowMapperImpl.class
  │                  │
  │                  ├─dao
  │                  │  │  PersonDao.class
  │                  │  │
  │                  │  └─impl
  │                  │          PersonDaoImpl.class
  │                  │
  │                  ├─entity
  │                  │      Person.class
  │                  │
  │                  ├─service
  │                  │  │  PersonService.class
  │                  │  │
  │                  │  └─impl
  │                  │          PersonServiceImpl.class
  │                  │
  │                  ├─utils
  │                  │      DaoUtils.class
  │                  │      DateUtils.class
  │                  │      Utils.class
  │                  │
  │                  └─view
  │                          TestPerson.class
  │
  └─src
      │  db.properties
      │
      └─com
          └─coderitl
              ├─advanced
              │  │  RowMapper.java
              │  │
              │  └─impl
              │          PersonRowMapperImpl.java
              │
              ├─dao
              │  │  PersonDao.java
              │  │
              │  └─impl
              │          PersonDaoImpl.java
              │
              ├─entity
              │      Person.java
              │
              ├─service
              │  │  PersonService.java
              │  │
              │  └─impl
              │          PersonServiceImpl.java
              │
              ├─utils
              │      DaoUtils.java
              │      DateUtils.java
              │      Utils.java
              │
              └─view
                      TestPerson.java
  ```

+ 主要实现常用工具类封装

  + 日期工具类
  + `JDBC`连接、资源关闭工具类
  + 回调函数封装

+ 封装查询方法，完善优化

+ 封装`增删改`

+ 实现表现分离

+ `git`常用命令

  ```bash
  # 解决 .gitignore 文件失效
  git rm -r --cache .
  
  # 版本标签
  # 建立本地标签
  git tag -a tagName version[v0.0] -m "描述信息"
  # 推送至远程
  git push origin tagName
  # 查看
  git show tagName
  
  
  ```

  

