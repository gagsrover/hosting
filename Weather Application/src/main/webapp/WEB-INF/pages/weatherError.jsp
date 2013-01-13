<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather Error</title>
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
    <h3>Following error occurred while fetching weather information</h3>
    <div class="errorblock">${exception.message}</div>
</body>
</html>