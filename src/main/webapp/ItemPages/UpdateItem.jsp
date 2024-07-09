<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Изменение Товара</title>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>

<body>
        <c:forEach items="${findItemById}" var="v">
            <form action="UpdateItemServlet?id=${v.ID}" method="post">
                <h1>Изменить Товар</h1>
                <input type="text" hidden value="${v.ID}" id="id" name="id" required>
                <div>

                    <label for="category">Категория</label>
                    <select name="category" id="category">
                        <c:forEach items="${getAllCategory}" var="c">
                            <c:if test="${c.ID==v.category_id}">
                                <option value="${c.ID}" selected>${c.name}</option>
                            </c:if>
                            <c:if test="${not (c.ID==v.category_id)}">
                                <option value="${c.ID}">${c.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="manufacture">Производитель</label>
                    <select name="manufacture" id="manufacture">
                        <c:forEach items="${getAllManufacture}" var="r">
                            <c:if test="${r.ID==v.manufacture_id}">
                                <option value="${r.ID}" selected>${r.name}</option>
                            </c:if>
                            <c:if test="${not (r.ID==v.manufacture_id)}">
                                <option value="${r.ID}">${r.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="input">
                    <label for="price">Цена</label>
                    <input type="text" name="price" id="price" value="${v.price}" pattern="\d+(\.\d{1})?" disabled required>
                </div>
                    <button class="btn btn-primary"  style="width: 50%" type="submit" onClick="this.form.price.disabled=0">Изменить</button>
                    <button class="btn btn-primary"  style="width: 50%" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AllItemsServlet';this.form.price.disabled=0">
                        Отменить
                    </button>
            </form>
        </c:forEach>

</body>
</html>