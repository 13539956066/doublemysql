<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>多数据源展示</title>
</head>
<body>
<span style="font-size:24px;">
    <meta http-equiv="refresh" content="3;URL=http://localhost:8080/ifindAll?"> </span>
    <#if error ??>
        <font color="red"><h4>抱歉， ${error!}</h4></font><br>
    <h4>即将返回主页，你可以直接<a href="http://localhost:8080/ifindAll?">点击</a>返回 </h4>
    <#else>
     <h4>操作成功，即将返回主页，你可以直接<a href="http://localhost:8080/ifindAll?">点击</a>返回 </h4>
    </#if>
</body>
</html>