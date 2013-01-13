<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Weather Information</title></head>
<body>
<table>
    <tr>
        <td colspan="2"><h3>Weather Information of "${weatherInfo.city}"</h3></td>
    </tr>
    <tr>
        <td><b>ZipCode : </b></td>
        <td>${weatherInfo.zipCode}</td>
    </tr>
    <tr>
        <td><b>City : </b></td>
        <td>${weatherInfo.city}</td>
    </tr>
    <tr>
        <td><b>State : </b></td>
        <td>${weatherInfo.state}</td>
    </tr>
    <tr>
        <td><b>Country : </b></td>
        <td>${weatherInfo.country}</td>
    </tr>
    <tr>
        <td><b>Temperature : </b></td>
        <td>${weatherInfo.tempData}</td>
    </tr>
</table>
</body>
</html>