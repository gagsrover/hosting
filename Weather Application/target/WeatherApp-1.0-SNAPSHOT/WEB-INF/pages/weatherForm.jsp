<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather Application</title>
    <style>

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }

    </style>
</head>
<body>
<form:form method="POST" commandName="weatherInfo">
    <form:errors path="*" cssClass="errorblock" element="div"/>
    <table>
        <tr>
            <td>Enter valid U.S. zip code :</td>
            <td><form:input path="zipCode"/></td>
        <tr>
            <td colspan="2"><input type="submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>