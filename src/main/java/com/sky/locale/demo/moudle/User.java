package com.sky.locale.demo.moudle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gantianxing on 2017/6/8.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;//姓名

    private Date birthday;//生日

    private BigDecimal money;//资产

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
