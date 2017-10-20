<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat Room</title>
 <link type="text/css" rel="stylesheet" href="<c:url value='Style.css' ></c:url>" />
</head>
<body>
<fieldset>
<form action="<c:url value='/Connexion'></c:url>" method="Post">
<p><label for="email"> Adress email : </label>
<input type="text" id="email" name="email" value="${auth.email}"> <span class="erreur">${mp['email']}</span></p>
<p><label for="password"> mot de pass  : </label>
<input type="password" id="password" name="password"  value="${auth.mot_de_pass}"><span class="erreur">${mp['password']}</span></p>
<input type="submit" value="Connexion" >
<input type="reset" value="Reset">
</form>
<form action="<c:url value='/Inscription'></c:url>" method="Get">
<input type="submit" value="Inscription">
</form>
</fieldset>
</body>
</html>