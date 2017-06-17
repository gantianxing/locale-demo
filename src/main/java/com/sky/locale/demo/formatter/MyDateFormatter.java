package com.sky.locale.demo.formatter;

import org.springframework.format.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gantianxing on 2017/6/13.
 */
public class MyDateFormatter implements Formatter<Date> {

    @Override
    public Date parse(String s, Locale locale) throws ParseException{
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
        System.out.println("parse");
        try {
            return df.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException(
                    "invalid date format.");
        }
    }

    @Override
    public String print(Date date, Locale locale) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
        System.out.println("format");
        return df.format(date);
    }


    //en:Jun 13, 2017 9:40:57 PM  中国：2017-6-13 21:41:30
    public static void main(String[] args) throws ParseException{
        Date dt = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.UK);
        System.out.println(df.format(dt));
//        System.out.println(df.parse("2017-06-13 21:41:30"));
    }
}
