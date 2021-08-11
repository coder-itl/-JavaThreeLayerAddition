package com.coderitl.advanced;

import java.sql.ResultSet;

/**
 * 受影响函数的 ORM 封装
 */
public interface RowMapper {
    // 约束
    public Object getRows(ResultSet resultSet);
}
