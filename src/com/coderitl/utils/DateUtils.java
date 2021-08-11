package com.coderitl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // 将 字符串转换为 util.Date
    public static Date strToUtil(String str) {
        try {
            Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //  util.Date 转换为 sql.Date
    public static java.sql.Date utiltoSql(Date date) {
        return new java.sql.Date(date.getTime());
    }

    //  util.Date 转换为字符串形式
    public static String utilToStr(Date date) {
        return sdf.format(date);
    }
}
