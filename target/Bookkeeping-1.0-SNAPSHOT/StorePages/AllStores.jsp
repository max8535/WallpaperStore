<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Филиалы</title>
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>
<body>
<div style="height: 100%; overflow:auto;">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <span class="navbar-brand mb-0 h1">Продажа обоев</span>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="AllItemsServlet">Товары</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllCategoryServlet">Категории</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllPurchaseItemServlet">Купленные товары</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllPurchaseServlet">Покупки</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllManufactureServlet">Производители</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllCustomerServlet">Клиенты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllStoreServlet">Филиалы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllStockServlet">Склады</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllDeliveryServlet">Поставки</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllPriceChangeServlet">Изменения цены товаров</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllReviewServlet">Отзывы</a>
                </li>
            </ul>
        </div>
    </nav>
    <div>
        <table style="width: 100%" class="table">
            <tr>
                <th >ID</th>
                <th >Название</th>
                <th >Номер</th>
                <th >Адрес</th>
                <th >Час открытия</th>
                <th >Час закрытия</th>
                <th ></th>
                <th ></th>
            </tr>
            <c:forEach items="${All}" var="s">
                <tr>
                    <td>${s.ID}</td>
                    <td>${s.name}</td>
                    <td>
                            ${s.number}
                    </td>
                    <td>${s.address}</td>
                    <td>${s.open_time}</td>
                    <td>${s.close_time}</td>
                    <td><a href="UpdateStoreServlet?id=${s.ID}">Изменить</a></td>
                    <td><a href="DeleteStoreServlet?id=${s.ID}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>


        <button class="btn btn-primary" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AddStoreServlet';">Добавить новый филиал</button>
        <br>
        <!--<button style="margin-left: 800px; align :center;margin-top: 50px" class="btn btn-primary" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/QueryStoreServlet';">Получить результаты запроса</button>

        <table style="width: 20%; justify-content: center" class="table">
            <tr>
                <th >ID</th>
                <th >Название</th>
                <th >Номер</th>
                <th >Адрес</th>
                <th >Час открытия</th>
                <th >Час закрытия</th>
            </tr>
            <c:forEach items="${getStore}" var="c">
                <tr>
                    <td>${c.ID}</td>
                    <td>${c.name}</td>
                    <td>
                            ${c.number}
                    </td>
                    <td>${c.address}</td>
                    <td>${c.open_time}</td>
                    <td>${c.close_time}</td>
                </tr>
            </c:forEach>
        </table> -->
    </div>
</div>
</body>
</html>