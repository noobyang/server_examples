<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/26
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<form action="uploadfile.action" method="post" enctype="multipart/form-data" >
    <input type="file" name="picture">
    <input type="submit" value="submit">
</form>

</body>
</html>
