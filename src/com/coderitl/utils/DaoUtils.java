package com.coderitl.utils;

import com.coderitl.advanced.RowMapper;
import com.coderitl.entity.Person;

import javax.rmi.CORBA.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作用: 复用增删改查
 */

public class DaoUtils {
    /**
     * 公共处理增、删、改的方法
     *
     * @param sql  执行的 sql 语句
     * @param args 参数列表,用于存储 preparedStatement.setXXX 信息
     * @return 受影响的行数
     */
    public int commentsUpdate(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = Utils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            int resultRows = preparedStatement.executeUpdate();
            return resultRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.closeAll(connection, preparedStatement, null);
        }
        return 0;
    }

    /**
     * 公共查询方法(可以查询任意一张表，可查询单个对象，也可以查询多个对象)
     *
     * @param sql  查询sql单个，多个
     * @param args 参数列表
     * @return 集合
     */
    public List<Object> commentsSelect(String sql, RowMapper rowMapper, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Object> list = new ArrayList<>();

        connection = Utils.getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                // 循环
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    // 如何根据查询结果完成 ORM？ 如何进行对象的创建以及赋值
                    // 将查询的结果传递给 getRows() 回调: 调用者提供的一个封装方法 ORM
                    Object obj = rowMapper.getRows(resultSet);
                    list.add(obj); // list = 0 ?
                }

            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
