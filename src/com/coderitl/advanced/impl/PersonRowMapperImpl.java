package com.coderitl.advanced.impl;

import com.coderitl.advanced.RowMapper;
import com.coderitl.entity.Person;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapperImpl implements RowMapper {
    @Override
    public Object getRows(ResultSet resultSet) {
        Person person = null;
        try {
            int pid = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Date bornDate = resultSet.getDate("bornDate");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            person = new Person(pid, name, age, bornDate, email, address);
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
