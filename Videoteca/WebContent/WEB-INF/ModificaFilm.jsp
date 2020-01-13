<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Film" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica</title>
</head>
<body>
<%Film filmOld=(Film) request.getAttribute("filmOld"); %>
  <form action="AggiungiFilm?val=modifyAdd&idSet=<%=filmOld.getId() %>" method="POST">
        <p>titolo</p>

        <input type="text" name="titolo"  value="<%=filmOld.getTitolo() %>" placeholder="titolo">
        <br>
        <p>durata</p>
      
        <input type="text" name="durata" value="<%=filmOld.getDurata() %>" placeholder="durata">
        <p>numero copie</p>
        
        <input type="text" name="copie" value="<%=filmOld.getCopie() %>" placeholder="numero copie">
        <br>
        <input type="submit" value="modifica">
      
    </form>
    <a href="ListaFilmAdmin"> vai alla lista</a>
</body>
</html>