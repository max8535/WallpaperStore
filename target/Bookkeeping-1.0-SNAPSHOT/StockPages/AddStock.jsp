<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Добавление Склада</title>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>
<body>
<form action="AddStockServlet" method="post">
    <h1>Добавьте новый склад</h1>

    <div class="input">
        <label for="item">Товар</label>
        <select name="item" id="item">
            <c:forEach items="${getAllItem}" var="c">
                <option value="${c.ID}">${c.ID}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input">
    <label for="amount">Количество товара на складе</label>
    <input type="number" name="amount" id="amount" pattern="^[ 0-9]+$" required>
    </div>

    <div class="input">
        <label for="adress">Адрес</label>
        <input type="text" name="adress" id="adress"  required>
    </div>
    <button class="btn btn-primary" style="width: 50%" type="submit">Добавить</button><br>
    <button class="btn btn-primary" style="width: 50%" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AllStockServlet';">Отменить</button>
</form>

</body>
</html>

