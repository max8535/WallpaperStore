<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Зарплаты</title>
    <link rel="stylesheet" href="<c:url value='/style/Main.css' />"/>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
</head>

<body>
<div style="height: 100%; overflow:auto;">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <span class="navbar-brand mb-0 h1">Бухгалтерия</span>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="AllStaffingServlet">Штатное расписание</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllEmployeeServlet">Работники</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllSalariesServlet">Зарплата</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllTaxServlet">Налог</a>
                </li>
            </ul>
        </div>
    </nav>
    <div>
        <table style="width: 90%" class="table">
            <tr>
                <th >ID</th>
                <th >Работник</th>
                <th >Дата зарплаты</th>
                <th >Чистая зарплата</th>
                <th >Налог</th>
                <th ></th>
                <th ></th>
            </tr>
            <c:forEach items="${All}" var="s">
                <tr>
                    <td>${s.ID}</td>
                    <td>
                        ФИО: ${s.employee.fio}<br>
                        ID должности: ${s.employee.staffing_id}
                    </td>
                    <td>
                            ${s.salary_date}
                    </td>
                    <td>${s.total_salary}</td>
                    <td>
                        Название налога: ${s.tax.tax_name}<br>
                        Процент налога: ${s.tax.percent_of_tax}
                    </td>
                    <td><a href="update_salary?id=${s.ID}">Edit</a></td>
                    <td><a href="delete_salary?id=${s.ID}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <button class="btn btn-primary" onclick="window.location.href = 'http://localhost:8081/Bookkeeping_war/AddSalariesServlet';">Добавьте новую зарплату</button>
    </div>
</div>
</body>
</html>
