<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Добавление зарплаты</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>
<body>
        <form action="AddSalariesServlet" method="post">
            <h1>Добавьте новую зарплату</h1>
            <div class="input">
                <label for="employee">Зарплата</label>
                <select name="employee" id="employee">
                    <c:forEach items="${getAllEmployees}" var="c">
                        <option value="${c.ID}">${c.fio}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input">
                <label for="date">Дата зарплаты</label>
                <input type="datetime-local" name="date" id="date" required>
            </div>
            <div class="input">
                <label for="tax">Налог</label>
                <select name="tax" id="tax">
                    <c:forEach items="${getAllTaxes}" var="c">
                        <option value="${c.ID}">${c.tax_name}</option>
                    </c:forEach>
                </select>
            </div>
                <button class="btn btn-primary" style="width: 50%" type="submit">Добавить</button>
                <button class="btn btn-primary" style="width: 50%" onclick="window.location.href = 'http://localhost:8081/Bookkeeping_war/AllSalariesServlet';">Отменить</button>
        </form>

</body>
</html>

