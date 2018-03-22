<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Inscription">
<label>Nom de login</label>
<input type="text" id="loginInsc"/><br />
<label>Adresse mail</label>
<input type="text" id="AdrMail"/><br />
<label>Mot de passe</label>
<input type="password" id="Mdp"/><br />
<button type="submit" >Valider le formulaire d'inscription</button>
</form>
</body>
</html>