package com.coderitl.view;

import com.coderitl.dao.PersonDao;
import com.coderitl.dao.impl.PersonDaoImpl;
import com.coderitl.entity.Person;

public class TestPerson {
    public static void main(String[] args) {
        // 接口指向接口的实现类
        PersonDao personDao = new PersonDaoImpl();
        Person person = personDao.selectOne(2);
        System.out.println(person);
    }
}
