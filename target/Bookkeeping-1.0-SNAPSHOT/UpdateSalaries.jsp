<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Изменение зарплаты</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>

<body>
        <c:forEach items="${findSalaryById}" var="v">
            <form action="update_salary?id=${v.ID}" method="post">
                <h1>Изменить зарплату</h1>
                <div>
                    <input type="text" hidden value="${v.ID}" id="id" name="id" required>
                    <label for="employee">Работник</label>
                    <select name="employee" id="employee">
                        <c:forEach items="${getAllEmployee}" var="c">
                            <c:if test="${c.ID==v.employee_id}">
                                <option value="${c.ID}" selected>${c.fio}</option>
                            </c:if>
                            <c:if test="${not (c.ID==v.employee_id)}">
                                <option value="${c.ID}">${c.fio}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="input">
                    <input type="datetime-local" name="date" id="date" value="${v.salary_date}"required>
                </div>
                <div>
                    <label for="tax">Налог</label>
                    <select name="tax" id="tax">
                        <c:forEach items="${getAllTax}" var="c">
                            <c:if test="${c.ID==v.tax_id}">
                                <option value="${c.ID}" selected>${c.tax_name}</option>
                            </c:if>
                            <c:if test="${not (c.ID==v.tax_id)}">
                                <option value="${c.ID}">${c.tax_name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                    <button class="btn btn-primary" style="width: 50%" type="submit">Изменить</button>
                    <button class="btn btn-primary" style="width: 50%"
                            onclick="window.location.href = 'http://localhost:8081/Bookkeeping_war/AllSalariesServlet';">
                        Отменить
                    </button>
            </form>
        </c:forEach>
</body>
</html>