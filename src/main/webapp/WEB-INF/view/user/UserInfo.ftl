
<!DOCTYPE HTML>
<html>
<head>
    <title><@spring.message "page.info.title"/></title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<@spring.message "current.locale"/> : ${request.locale}
<div id="global">
    <h4><@spring.message "page.form.title"/></h4>
    <p>
    <h5><@spring.message "page.info.details"/></h5>
    <@spring.message "label.userName"/>: ${user.name}<br/>
    <@spring.message "label.birthday"/>:<#if (user.birthday)??> ${(user.birthday?datetime)} </#if><br/>
    <@spring.message "label.money"/>: ${(user.money?string.currency)!}
    </p>
</div>
</body>
</html>