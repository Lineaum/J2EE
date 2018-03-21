<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Connexion#Envoyer">
<label>Nom de login</label>
<input type="text" id="login" name="login"/><br />
<label>Mot de passe</label>
<input type="password" id="Mdp" name="Mdp"/><br />
<button type="submit" >Valider la connexion</button>
</form>
<p> ${ erreurs.login } </p>
<p> ${ erreurs.Mdp } </p>
</body>
</html>