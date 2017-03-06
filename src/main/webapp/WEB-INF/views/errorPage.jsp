<%-- 
    Document   : errorPage
    Created on : Mar 6, 2017, 12:29:50 PM
    Author     : mervin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1 style="color: red">Error! New Product Cannot be Added.</h1>
        <h1 style="color: red">${requestScope.messages.minNamePastDate}</h1>
        <h1 style="color: red">${requestScope.messages.violationsSize}</h1>
        <h3 style="color: red">${requestScope.messages.violations}</h3>
    </body>
</html>
