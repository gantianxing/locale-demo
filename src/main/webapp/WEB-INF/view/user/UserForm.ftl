
<!DOCTYPE html>
<html>
<head>
    <title><@spring.message "page.user.title"/> </title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<div id="global">
<@spring.message "current.locale"/> : ${request.locale}
    <br/>

<@spring.message "select.language"/> : <span><a href="javascript:void(0)" onclick="changeLanguage('en_GB')">EN</a></span>
    |<span><a href="javascript:void(0)" onclick="changeLanguage('zh_CN')">CN</a></span>

    <form name="user" action="save" method="post">
        <fieldset>
            <legend><@spring.message "user.form.name"/></legend>
            <p>
            <@spring.bind "user.name" />
                <label for="name"><@spring.message "label.userName"/>:</label>
                <input id="name" type="text" name="name" value="${user.name}" cssErrorClass="error"/>
            <@spring.showErrors "<br/>" cssClass="error"/>
            </p>
            <p>
            <@spring.bind "user.birthday" />
                <label for="birthday"><@spring.message "label.birthday"/>: </label>
                <input id="birthday" type="text" name="birthday" value="<#if (user.birthday)??> ${(user.birthday?datetime)} </#if>" cssErrorClass="error"/>
            <@spring.showErrors "<br/>" cssClass="error"/>

            </p>
            <p>
            <@spring.bind "user.money" />
                <label for="money"><@spring.message "label.money"/>: </label>
                <input id="money" type="text" name="money" value="${(user.money?string.currency)!}" cssErrorClass="error"/>
            <@spring.showLastError classOrStyle="error"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4"
                       value="<@spring.message "button.reset"/>">
                <input id="submit" type="submit" tabindex="5"
                       value="<@spring.message "button.submit"/>">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
<script type="text/javascript" src="//misc.360buyimg.com/jdf/lib/jquery-1.6.4.js?t=1705252218"></script>
<script type="text/javascript">
    function changeLanguage(language)
    {
        $.ajax({
            type: "POST",
            url:"/changelanguage",
            data: "new_lang="+language,
            dataType:"text",
            async: true,
            error: function(data, error) {alert("change lang error!"); alert(error)},
            success: function(data)
            {
                window.location.reload();
            }
        });
    }
</script>
