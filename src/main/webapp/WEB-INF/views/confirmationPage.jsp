<%-- 
    Document   : confirmation
    Created on : Mar 6, 2017, 9:56:13 AM
    Author     : mervin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
    </head>
    <body style="color: green">
        <h1>New Product Added Successfully.</h1>
        <h1>The new Product Details are:</h1>
        <h2>Product Name: ${requestScope.Product.productName}</h2>
        <h2>Product Date Added: ${requestScope.Product.dateAdded}</h2>
        <h2>Product Count: ${requestScope.Product.productCount}</h2>
    </body>
</html>
