<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Изменение Покупки</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>

<body>
<c:forEach items="${findPurchaseById}" var="v">
    <form action="UpdatePurchaseServlet?id=${v.ID}" method="post">
        <h1>Изменить Покупку</h1>
        <input type="text" hidden value="${v.ID}" id="id" name="id" required>
        <div>

            <label for="store">Филиал</label>
            <select name="store" id="store">
                <c:forEach items="${getAllStore}" var="c">
                    <c:if test="${c.ID==v.store_id}">
                        <option value="${c.ID}" selected>${c.name}</option>
                    </c:if>
                    <c:if test="${not (c.ID==v.store_id)}">
                        <option value="${c.ID}">${c.name}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="customer">Клиент</label>
            <select name="customer" id="customer">
                <c:forEach items="${getAllCustomer}" var="r">
                    <c:if test="${r.ID==v.customer_id}">
                        <option value="${r.ID}" selected>${r.fio}</option>
                    </c:if>
                    <c:if test="${not (r.ID==v.customer_id)}">
                        <option value="${r.ID}">${r.fio}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="input">
            <label for="date">Дата покупки</label>
            <input type="datetime-local" name="date" id="date" value="${v.purchase_date}"  required>
        </div>
        <button class="btn btn-primary"  style="width: 50%" type="submit">Изменить</button>
        <button class="btn btn-primary"  style="width: 50%" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AllPurchaseServlet';">
            Отменить
        </button>
    </form>
</c:forEach>

</body>
</html>
