package com.coderitl.dao;

import com.coderitl.entity.Person;

import java.util.List;

public interface PersonDao {
    // 数据添加方法
    public int insert(Person person);

    // 数据删除方法
    public int delete(int id);

    // 数据修改方法
    public int update(Person person);

    // 数据查询方法 单个查询
    public Person selectOne(int id);

    // 数据查询方法 查询所有
    public List<Person> selectAll();

}
