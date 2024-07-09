<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Добавление клиента</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>
<body>
        <form action="AddCustomerServlet" method="post">
            <h1>Добавьте нового клиента</h1>
            <div class="input">
                <label for="fio">ФИО</label>
                <input type = "text" name = "fio" id = "fio" pattern="^[А-Яа-яЁё\s]+$" required>
            </div>
            <div class="input">
                <label for="number">Номер телефона</label>
                <input type="number" name="number" id="number" pattern="^[ 0-9]+$"required>
            </div>
            <div class="input">
                <label for="email">"Электронная почта"</label>
                <input type="email" name="email" id="email" pattern="\w+@[a-zA-Z_]+?\.[a-zA-Z]{2-8}" required>
            </div>
                <button class="btn btn-primary" style="width: 50%" type="submit">Добавить</button>
                <button class="btn btn-primary" style="width: 50%" onclick="window.location.href = 'http://localhost:8082/WallpaperStore_war/AllCustomerServlet';">Отменить</button>
        </form>
</body>
</html>

