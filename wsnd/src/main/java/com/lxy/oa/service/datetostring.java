package com.lxy.oa.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class datetostring {
    public static String dateToString(Date date) {
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        String tiem = sformat.format(date);

        return tiem;
    }
}
