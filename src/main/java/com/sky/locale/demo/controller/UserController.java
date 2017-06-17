package com.sky.locale.demo.controller;

import com.sky.locale.demo.moudle.User;
import com.sky.locale.demo.validator.UserValidator;
import org.apache.commons.lang.CharEncoding;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gantianxing on 2017/6/8.
 */

@Controller
public class UserController {
    @RequestMapping(value="add")
    public String addUser(Model model) {
        model.addAttribute(new User());
        return "/user/UserForm";
    }

    @RequestMapping(value="save")
    public String saveUser(@ModelAttribute User user, BindingResult bindingResult,
                               Model model) {
        //表单验证
        UserValidator userValidator = new UserValidator();
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println("Code:" + fieldError.getCode()
                    + ", field:" + fieldError.getField());
            return "/user/UserForm";
        }

        return "/user/UserInfo";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value="edit")
    public String editUser(Model model) {
        //省略从数据库中查询代码

        User user = new User();
        user.setName("张三");
        Date now = new Date();
        user.setBirthday(now);
        user.setMoney(new BigDecimal("12.12"));
        model.addAttribute("user",user);
        return "/user/UserForm";
    }

    @RequestMapping(value = "/changelanguage", method = RequestMethod.POST)
    public void changeLanguage(@RequestParam String new_lang,HttpServletRequest request, HttpServletResponse response)
    {
        String msg = "";
        try
        {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            if (localeResolver == null) {
                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
            }

            LocaleEditor localeEditor = new LocaleEditor();
            localeEditor.setAsText(new_lang);
            localeResolver.setLocale(request, response, (Locale)localeEditor.getValue());

            msg = "Change Language Success!";
        }
        catch(Exception ex)
        {
            msg = "error";
            ex.printStackTrace();
        }

        response.setCharacterEncoding(CharEncoding.UTF_8);

        try {
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
