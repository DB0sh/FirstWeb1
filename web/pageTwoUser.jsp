<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--User: dima Date: 14.12.2021 Time: 12:00--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Second Web</title>
    <link rel="stylesheet" href="style/Style.css">
</head>
<body class="body2">
    <div align="center" class="block3">
        <h1 align="center">User manipulation</h1>
        <a href="CreateAdd"><input value="Create" class="block4"></a>
        <table border="1" width=60%>
            <tr>
                <th>Id</th><th>E-mail</th>
            </tr>
            <c:forEach items="${users}" var="t">
                <tr>
                    <td>${users.indexOf(t) + 1}</td>
                    <td><a></a></td>
                </tr>
            </c:forEach>

        </table>

    </div>

</body>
</html>
