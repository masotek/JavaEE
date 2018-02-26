<!DOCTYPE HTML>
<html lang="pl">
<head>
    <title>
        Users list
    </title>
</head>
<body>
<#list users>
<#items as user>

    ID:${user.id}<br>
    Name:${user.name}<br>
    Login:${user.login}<br>
    Age:${user.age}<br>
    <#sep>*********************************************** </#sep>
    </#items>
</#list>
</body>
</html>
