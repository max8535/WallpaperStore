<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Изменение филиала</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
</head>

<body>
<c:forEach items="${findStoreById}" var="p">
    <form class = "form-group" action="UpdateStoreServlet?id=${p.ID}" method="post">
        <h1>Изменить филиал</h1>

        <input name="id" type="hidden" value="${p.ID}" required>

        <div class="input">
            <label for="name">Название</label>
            <input type = "text" name = "name" id = "name" value = "${p.name}" pattern="^[А-Яа-яЁё\s]+$" required>
        </div>
        <div class="input">
            <label for="number">Телефон</label>
            <input type="text" name="number" id="number" value = "${p.number}"pattern="^[0-9/s-]+$"required>
        </div>
        <div class="input">
            <label for="adress">"Адрес"</label>
            <input type="text" name="adress" id="adress" value = "${p.address}" required>
        </div>
        <div class="input">
            <label for="open_time">Час открытия</label>
            <input type="number" name="open_time" id="open_time" value = "${p.open_time}"pattern="^[ 0-9]+$"required>
        </div>
        <div class="input">
            <label for="close_time">Час закрытия</label>
            <input type="number" name="close_time" id="close_time" value = "${p.close_time}"pattern="^[ 0-9]+$"required>
        </div>
        <button class="btn btn-primary" style="width: 50%" type="submit">Обновить</button><br>
        <button class="btn btn-primary" style="width: 50%"
                onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AllStoreServlet';">Отменить
        </button>
    </form>
</c:forEach>

</body>
</html>