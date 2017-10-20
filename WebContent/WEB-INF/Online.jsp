<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<c:url value='Style1.css' >
</c:url>" />
</head>
<body>
 <form action="/chat_room/Online" method="post">    
 <fieldset> 
 <legend>Un chat en jQuery</legend>      
   <div id="conversation">
   <c:forEach items="list" var="param">
   <c:out value='"${param.Key}"+" : "+" ${param.Value}"'></c:out>
   </c:forEach>
   </div><br />
   <c:forEach items="${list}" var="news">
   <p> <c:out value="${news}"></c:out></p>
     </c:forEach>
   <input type="text" id="message" name="message" size="27">       
   <input type="submit" id="envoyer"  value="envoyer" >     
 </fieldset>
 </form>
 <form action="/chat_room/Refreche" method="get">    
 <input type="submit" id="Refreche" value="Refreche" >     
 </form>
</body>
</html>