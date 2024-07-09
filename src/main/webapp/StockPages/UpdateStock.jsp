<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Изменение Склада</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>

<body>
<c:forEach items="${findStockById}" var="v">
    <form action="UpdateStockServlet?id=${v.ID}" method="post">
        <h1>Изменить Склад</h1>
        <input type="text" hidden value="${v.ID}" id="id" name="id" required>

        <div>
            <label for="item">Товар</label>
            <select name="item" id="item">
                <c:forEach items="${getAllItem}" var="r">
                    <c:if test="${r.ID==v.item_id}">
                        <option value="${r.ID}" selected>${r.ID}</option>
                    </c:if>
                    <c:if test="${not (r.ID==v.item_id)}">
                        <option value="${r.ID}">${r.ID}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="input">
            <label for="amount">Количество товара на складе</label>
            <input type="number" name="amount" id="amount" value="${v.stock_amount}"pattern="^[ 0-9]+$" required>
        </div>

        <div class="input">
            <label for="adress">Адрес</label>
            <input type="text" name="adress" id="adress" value="${v.stock_address}" required>
        </div>
        <button class="btn btn-primary"  style="width: 50%" type="submit">Изменить</button>
        <button class="btn btn-primary"  style="width: 50%" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AllStockServlet';">
            Отменить
        </button>
    </form>
</c:forEach>

</body>
</html>
