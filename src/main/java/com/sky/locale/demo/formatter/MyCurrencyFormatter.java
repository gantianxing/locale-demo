package com.sky.locale.demo.formatter;

import org.springframework.format.Formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by gantianxing on 2017/6/15.
 */
public class MyCurrencyFormatter implements Formatter<BigDecimal> {

    /**
     * 去掉货币符号，并转换为BigDecimal
     * @param s
     * @param locale
     * @return
     * @throws ParseException
     */
    @Override
    public BigDecimal parse(String s, Locale locale) throws ParseException {
        try {
            NumberFormat curF = NumberFormat.getCurrencyInstance(locale);
            BigDecimal bd = new BigDecimal(curF.parse(s).toString());//去掉货币符号
            return bd;
        } catch (ParseException e) {

            //如果没有带单位 转换会失败，但是如果是数字可以成功转换成BigDecimal，主要是springMVC做了兼容处理
            throw new IllegalArgumentException(
                    "invalid Currency format.");
        }
    }

    /**
     * 把BigDecimal 转换为对应国家带货币单位的 字符串格式
     * @param bigDecimal
     * @param locale
     * @return
     */
    @Override
    public String print(BigDecimal bigDecimal, Locale locale) {
        NumberFormat curF = NumberFormat.getCurrencyInstance(locale);
        return curF.format(bigDecimal);
    }

    public static void main(String[] args) {
        NumberFormat curF = NumberFormat.getCurrencyInstance(new Locale("en"));
        System.out.println(curF.format(123.123));
    }
}
