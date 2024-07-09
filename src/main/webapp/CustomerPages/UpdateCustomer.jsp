<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Изменение клиента</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
</head>

<body>
<c:forEach items="${findCustomerById}" var="p">
    <form class = "form-group" action="UpdateCustomerServlet?id=${p.ID}" method="post">
        <h1>Изменить клиента</h1>

        <input name="id" type="hidden" value="${p.ID}" required>

        <div class="input">
            <label for="fio">ФИО</label>
            <input class = "text" type="text" name="fio" id="fio" value="${p.fio}" pattern="^[А-Яа-яЁё\s]+$" required>
            <span class="spin"></span>
        </div>


        <div class="input">
            <label for="number">Номер телефона</label>
            <input type="text" name="number" id="number" value = "${p.number}" pattern="^[ 0-9]+$" required>
        </div>

        <div class="input">
            <label for="mail">"Электронная почта"</label>
            <input type="text" name="mail" id="mail" value = "${p.mail}" pattern="\w+@[a-zA-Z_]+?\.[a-zA-Z]{2-8}" required>
        </div>

        <button class="btn btn-primary" style="width: 50%" type="submit">Обновить</button><br>
        <button class="btn btn-primary" style="width: 50%"
                onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AllCustomerServlet';">Отменить
        </button>
    </form>
</c:forEach>

</body>
</html>