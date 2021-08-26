<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="/Error.jsp"
    pageEncoding="UTF-8" isThreadSafe="false"%>
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
    
</body>
</html>