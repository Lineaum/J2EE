<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Chat</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/Affichage.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<table border=0 width="100%" height="100%">
	<tr>
		<td>
			<table border=0>
				<tr>
					<td>
						<p><a href="Connexion?Salon=Test1#Envoyer">Test1</a></p>
					</td>
				</tr>
				<tr>
					<td>
						<p><a href="Connexion?Salon=Test2#Envoyer">Test2</a></p>
					</td>
				</tr>
				<tr>
					<td>
						<p><c:out value="${ LoginSession}"/></p>
					</td>
				</tr>
			</table>
		</td>
		<td>
			<table border=0 width="100%" height="100%">
				<tr>
					<td>
						<ul id="UL" style="padding-left: 0px; ">
					        <c:forEach items="${ messages }" var="message" varStatus="boucle">
            					<li>${ message }</li>
        					</c:forEach>
							<br/>
							<form method="post" action="SendMessage">
								<input type="text" id="Message" name="Message" maxlength="150"/>
								<button type="submit" id="Envoyer" name="Envoyer" >Envoyer</button>
							</form>
							<a href="Connexion#Envoyer" ><input type="submit" value="refresh"/></a>
						</ul>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>