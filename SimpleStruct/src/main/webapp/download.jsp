<%--
  Created by IntelliJ IDEA.
  User: liyang
  Date: 2020/9/22
  Time: 06:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<c:if test="${files==null}">

    对不起，没有下载的页面

</c:if>

<c:if test="${files!=null}">

    <table border="1px">
        <tr>
            <td>编号</td>
            <td>文件名称</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${files}" varStatus="file" var="fileName">
            <tr>

                <td>${file.count}</td>

                    <%--如果直接写fileName，输出的名字带有路径，使用EL方法库来截取--%>
                <td>${fn:substringAfter(fileName, "upload\\")}</td>
                <td>

                        <%--使用url标签来构建url，不然超链接带有中文，会出现乱码--%>
                    <c:url var="url" value="down_downLoad">
                        <c:param name="fileName">${fn:substringAfter(fileName, "upload\\")}</c:param>
                    </c:url>

                    <a href="${url}">下载</a>

                </td>
            </tr>
        </c:forEach>

    </table>
</c:if>
</body>
</html>
