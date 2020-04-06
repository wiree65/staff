
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SearchEmployee</title>
</head>
<body>

<table>
    <tr>
        <td>Firstname :</td>
        <td></td>
        <td>${employee.getFirstname()}</td>
    </tr>
    <tr>
        <td>lastname :</td>
        <td></td>
        <td>${employee.getLastname()}</td>
    </tr>
    <tr>
        <td>birth date :</td>
        <td></td>
        <td>${employee.getBirthDate()}</td>
    </tr>
    <tr>
        <td>Gender :</td>
        <td></td>
        <td>${employee.getGender()}</td>
    </tr>
    <tr>
        <td>hire_date :</td>
        <td></td>
        <td>${employee.getHire_date()}</td>
    </tr>
    <tr>
        <td>salary :</td>
        <td></td>
        <td>${employee.getSalary()}</td>
    </tr>
    <tr>
        <td>Department name :</td>
        <td></td>
        <td>${employee.getDept_name()}</td>
    </tr>
    <tr>
        <td>Title :</td>
        <td></td>
        <td>${employee.getTitle()}</td>
    </tr>
</table>
</body>
</html>
