package com.coderitl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class Utils {
    private static final Properties PROPERTIES = new Properties();

    static {
        InputStream is = Utils.class.getResourceAsStream("/db.properties");
        try {
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 封装连接方法
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("user"), PROPERTIES.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 关闭资源方法封装
    public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }

            if(preparedStatement!=null){
                preparedStatement.close();
            }

            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
