<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Изменение производителя</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
</head>

<body>
<c:forEach items="${findManufactureById}" var="p">
    <form class = "form-group" action="UpdateManufactureServlet?id=${p.ID}" method="post">
        <h1>Изменить производителя</h1>

        <input name="id" type="hidden" value="${p.ID}" required>

        <div class="input">
            <label for="name">Название</label>
            <input class = "text" type="text" name="name" id="name" value="${p.name}" required>
            <span class="spin"></span>
        </div>

        <div class="input">
            <label for="adress">Адрес</label>
            <input type="text" name="adress" id="adress" value = "${p.address}" required>
        </div>

        <button class="btn btn-primary" style="width: 50%" type="submit">Обновить</button><br>
        <button class="btn btn-primary" style="width: 50%"
                onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AllManufactureServlet';">Отменить
        </button>
    </form>
</c:forEach>

</body>
</html>