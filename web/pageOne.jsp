<%--User: dima Date: 10.12.2021 Time: 12:21--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Web</title>
    <link rel="stylesheet" href="style/Style.css">
</head>
<body class="body1">


    <div class="block1" align="center" title="Нужен логин & пароль">
        <form action="LogIn">
            <h2>Авторизоваться</h2>
            Эл. адрес: <br><input size="15" maxlength="30" name="Email"><br>
            Пароль: <br><input size="15" maxlength="30" name="Password"><br>
            <input type="submit" value="Зайти" class="block2">
        </form>

    </div> <%--TODO 1) создать класс (сущность/энтити) Юзер с тремя полями(ИД, Имэйл, Пар.)--%>
            <%--2) создать новую БД и табл. для хранения юзеров--%>
            <%--3) создать класс ЮзерРепозиторий (умеет получать, сохр, обр., созвать юзеров)--%>
            <%--4) создать две страницы: успешную и ошибочную--%>

</body>
</html>
