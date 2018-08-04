<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8">
    <title>mysql</title>
</head>
<body>
<#--<font color="red"><h3>${error!}</h3> </font>-->
<h1>数据库展示</h1>
<form action="/ifindAll"  method="get">
    <input type="submit" id="submit0" value="首页"/>
</form>

<h4>查找一个id</h4>
<form action="/seletePersonId1"  method="get">
    <input type="number" id="id" name="id" required/>
    <input type="submit" id="submit1" value="查找"/>
</form>

<h3>数据查找</h3>
<table>
    <tr>
        <td>name</td>
        <td>username</td>
        <td>university</td>
    </tr>
    <tr>
        <form action="/findmore">
        <td><input type="text" id="name" name="name" width="10px" placeholder="name"/></td>
        <td><input type="text" id="username" name="username" width="10px" placeholder="username"/></td>
        <td><input type="text" id="university" name="university" width="10px" placeholder="university"/></td>

    </tr>
    <tr>
        <td><input type="submit" id="submit" value="查找"/></td>
    </tr>
</table>

</form>
<h4>增加一个记录</h4>
<form action="/savePerson1"  method="get">
    <input type="number" id="addid" name="id" placeholder="添加id" required/><font color="#a9a9a9" maxlength="3">必填</font><br/>
    <input type="text" id="addusername" name="username" placeholder="username" required/><font color="#a9a9a9">必填</font><br/>
    <input type="password" id="addpassword" name="password" placeholder="password" required/><font color="#a9a9a9">必填</font><br/>
    <input type="text" id="addname" name="name"  placeholder="name" required/><font color="#a9a9a9">必填</font><br/>
    <input type="text" id="adduniversity" name="university"  placeholder="university"/><br/>
    <input type="submit" id="submit4" value="提交"/>
</form>
<br/><br/>


<table border="1" th:width="200">
    <tr th:width="50" th:height="15">
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>name</td>
        <td>university</td>
        <td>删</td>
        <td>改</td>
    </tr>
<#if listres ??>
    <#list listres as items>
    <tr>
        <td width="30">${items.id}</td>
        <td width="30">${items.username}</td>
        <td width="30">${items.password}</td>
        <td width="30">${items.name}</td>
        <td width="30">${items.university}</td>
        <td>
            <form action="/deleteName1" method="get">
                <input value="${items.id}" name="delid" style="display: none">
                <input value="删除" type="submit"></form>
        </td>
        <td>
            <form action="/toupdpage" method="get">
                <input value="${items.id}" name="updid" style="display: none" >
                <input value="修改" type="submit" src="/updpage"></form>
        </td>
    </tr>
    </#list>
</#if>

</table>

</body>
</html>
<#--
<h4>查找name</h4>
<form action="/seletePerson1"  method="get">
    <input type="text" id="name" name="name"/>
    <input type="submit" id="submit2" value="查找"/>
</form>

<h4>查找username</h4>
<form action="/findByname1"  method="get">
    <input type="text" id="username" name="username"/>
    <input type="submit" id="submit3" value="查找"/>
</form>

<h4>查找university</h4>
<form action="/seleteUniversity"  method="get">
    <input type="text" id="university" name="university"/>
    <input type="submit" id="submit4" value="查找"/>
</form>-->