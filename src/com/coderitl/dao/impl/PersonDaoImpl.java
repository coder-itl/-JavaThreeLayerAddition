package com.coderitl.dao.impl;

import com.coderitl.advanced.RowMapper;
import com.coderitl.advanced.impl.PersonRowMapperImpl;
import com.coderitl.dao.PersonDao;
import com.coderitl.entity.Person;
import com.coderitl.utils.DaoUtils;
import com.coderitl.utils.DateUtils;
import com.coderitl.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 接口的实现类需要实现所有接口的抽象方法
 */
public class PersonDaoImpl implements PersonDao {
    private DaoUtils daoUtils = new DaoUtils();

    @Override
    public int insert(Person person) {
        String sql = "insert into Person values(?,?,?,?,?)";
        Object[] obj = {person.getName(), person.getAge(), DateUtils.utiltoSql(person.getBornDate()), person.getEmail(), person.getAddress()};
        return daoUtils.commentsUpdate(sql, obj);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from  Person where id=?";
        return daoUtils.commentsUpdate(sql, id);
    }

    @Override
    public int update(Person person) {
        String sql = "update Person set name=?,age=?,bornDate=?,email=?,address=? where id=?";
        Object[] obj = {person.getName(), person.getAge(), DateUtils.utiltoSql(person.getBornDate()), person.getEmail(), person.getAddress(), person.getId()};
        return daoUtils.commentsUpdate(sql, obj);
    }

    @Override
    public Person selectOne(int id) {
        // 先写全局在对共性进行抽取封装
        String sql = "select * from Person where id=?";
        List<Object> list = daoUtils.commentsSelect(sql, new PersonRowMapperImpl(), id);
        // 如果获取的集合不为空
        if (!list.isEmpty()) {
            // 获取第一个的值并强转为 Person 类型
            return (Person) list.get(0);
        }
        return null;
    }

    @Override
    public List<Person> selectAll() {

        return null;
    }
}
