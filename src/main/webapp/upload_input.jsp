<%--
  Created by IntelliJ IDEA.
  User: lv
  Date: 2016/4/14
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File upload</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="text" name="normalField">
        <input type="file" name="file1" multiple>
        <input type="file" name="file2">
        <input type="submit" value="submit">
    </form>
</body>
</html>
