<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/chat_room/Inscription" method="post">
<fieldset>

<label for="name"> nom : </label>
<input type="text" id="name" name="name">

<label for="prenom"> prenom : </label>
<input type="text" id="prenom" name="prenom">

<label for="nickname"> nickname : </label>
<input type="text" id="nickname" name="nickname">

<label for="email"> email : </label>
<input type="text" id="email" name="email">

<label for="password"> mot de pass : </label>
<input type="password" id="password" name="password">

<label for="repassword"> Confirme : </label>
<input type="password" id="repassword" name="repassword">

<input type="submit" value="inscription">
<input type="reset" value="Reset">

</fieldset>
</form>
</body>
</html>