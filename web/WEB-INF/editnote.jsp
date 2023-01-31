<%-- 
    Document   : editnote
    Created on : Jan 30, 2023, 6:47:42 PM
    Author     : vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="view">
            Title: 
            <input type="text" name="title" value="${note.title}"><br>
            Contents: 
            <textarea name="contents">${note.content}</textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
