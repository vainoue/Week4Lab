<%-- 
    Document   : viewnote
    Created on : Jan 30, 2023, 6:47:24 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <strong>Title:</strong> ${note.title}<br><br>
        <strong>Contents:</strong><br>
        ${note.content}<br><br>
        <a href="note?edit">Edit</a>
        <br>
    </body>
</html>
