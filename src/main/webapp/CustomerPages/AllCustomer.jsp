<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Клиенты</title>
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
                <th >ФИО</th>
                <th >Номер</th>
                <th >Электронная почта</th>
                <th ></th>
                <th ></th>
            </tr>
            <c:forEach items="${All}" var="s">
                <tr>
                    <td>${s.ID}</td>
                    <td>${s.fio}
                    </td>
                    <td>
                            ${s.number}
                    </td>
                    <td>${s.mail}</td>
                    <td><a href="UpdateCustomerServlet?id=${s.ID}">Изменить</a></td>
                    <td><a href="DeleteCustomerServlet?id=${s.ID}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>


        <button class="btn btn-primary" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AddCustomerServlet';">Добавить нового клиента</button>
<br>
        <button style="margin-left: 600px; align :center;margin-top: 30px;width:660px" class="btn btn-primary" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/QueryCustomerServlet?id=${1}';">Клиент,купивший наибольшее количество обоев за последний месяц</button><br>
        <button style="margin-left: 600px; align :center;margin-top: 30px;width:660px" class="btn btn-primary" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/QueryCustomerServlet?id=${2}';">Клиенты, не купившие товаров за последний год</button><br>
        <button style="margin-left: 600px; align :center;margin-top: 30px;width:660px" class="btn btn-primary" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/QueryCustomerServlet?id=${3}';">Клиент,оставивший наибольшее количество отзывов</button><br>
        <button style="margin-left: 600px; align :center;margin-top: 30px; width:660px" class="btn btn-primary" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/QueryCustomerServlet?id=${4}';">Клиенты, совершившие только одну покупку за всё время</button><br>
        <button style="margin-left: 600px; align :center;margin-top: 30px; width:660px" class="btn btn-primary" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/QueryCustomerServlet?id=${5}';">Клиенты,покупающие товары уже более 5 лет</button>


        <table style="width: 20%; justify-content: center" class="table">
            <tr>
                <th >ID</th>
                <th >ФИО</th>
                <th >Номер</th>
                <th >Электронная почта</th>
            </tr>
            <c:forEach items="${getCustomer}" var="c">
                <tr>
                    <td>${c.ID}</td>
                    <td>${c.fio}
                    </td>
                    <td>
                            ${c.number}
                    </td>
                    <td>${c.mail}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
