package com.baidu.hui.common.test.biz.time;

import java.text.ParseException;
import java.util.Date;

public class TestTime {

    public static void main(String[] args) throws ParseException {

        String dateStr = "2016-10-19T14:15:36+08:00";
        Date date = javax.xml.bind.DatatypeConverter.parseDateTime(dateStr).getTime();

        System.out.println(date);

    }

}
