<%@ page language="java" contentType="text/html; charset=UTF-8" 

    pageEncoding="UTF-8" isThreadSafe="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        pageContext.setAttribute("msg", "pageData");
        request.setAttribute("msg", "reqData");
        session.setAttribute("msg", "sessionData");
        application.setAttribute("msg", "appData");
    
    
    %>
    ${msg }
    <hr>
    ${pageScope.msg }
    ${requestScope.msg}
    ${sessionScope.msg}
    ${applicationScope.msg}
    
    ${xx}
    <%=request.getAttribute("xx") %>
    <hr>
    
    ${param.name}
    ${paramValues.i[0]}
    ${paramValues.i[1]}
    
    
    <hr>
    
    <c:out value="${sessionScope.msg2}" default="没有你要的数据"></c:out>
    
     <c:set var="msg2" value="hi" scope="session"></c:set>
     <c:remove var="msg2" scope="session"/>
     <br>
     <c:out value="${sessionScope.msg2}" default="没有你要的数据"></c:out>
     
     
 <c:catch var="ex">   
  <%
     int i = 1/0;
  %>
</c:catch>
<c:out value="${ex}"></c:out>
${ex}
<br>
<c:if test="${!empty requestScope.msg  }" scope="page" var="haveMsg">
${"不为空"}
</c:if>

${pageScope.haveMsg}


<c:choose>
   <c:when test="${! empty sessionScope.msg2 }">
       ok
   </c:when>
   <c:otherwise>
       nook
   </c:otherwise>
</c:choose>

<ul>
<c:forTokens items='${"china#english#japan"}' delims="#" var="i">
<li>${i }
</c:forTokens>

</ul>

<c:url value="http://www.qq.com"  scope="page" var="myurl">
  <c:param name="a" value="1"></c:param>
</c:url>
<hr>
<a href="${myurl }">QQ</a>

</body>
</html>