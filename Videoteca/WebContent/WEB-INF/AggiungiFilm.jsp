<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi</title>
</head>
<body>
    <form action="AggiungiFilm?val=add" method="POST">
        <p>titolo</p>

        <input type="text" name="titolo" id="" placeholder="titolo">
        <br>
        <p>durata</p>
      
        <input type="text" name="durata" id="" placeholder="durata">
        <p>numero copie</p>
        
        <input type="text" name="copie" id="" placeholder="numero copie">
        <br>
        <input type="submit" value="aggiungi">
    </form>
    <a href="ListaFilmAdmin"> vai alla lista</a>
</body>
</html>