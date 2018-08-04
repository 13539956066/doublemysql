<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8">
    <title>修改页面</title>
</head>
<body>

<h2>修改数据</h2>
<hr/>
<form action="/updaPerson1"  method="get">
    <input type="number" id="id" name="id" value="${id}" required/><br/>
    <input type="number" id="oldid" name="oldid" value="${id}" style="display: none"/>
    <input type="text" id="updusername" name="username" placeholder="username" required/><br/>
    <input type="password" id="updpassword" name="password" placeholder="password" required/><br/>
    <input type="text" id="updname" name="name" placeholder="name" required/><br/>
    <input type="text" id="upduniversity" name="university" placeholder="university" required/><br/>
    <input type="submit" id="submit" value="提交"/>
</form>

</body>
</html>