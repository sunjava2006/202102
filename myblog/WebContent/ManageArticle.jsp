<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, com.wangrui.myblog.bean.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <button onclick="location='/createArticle'">新建文章</button>
     
     <table style="width:400px" border="1">
     <tr>
         <th></th>
         <th>标题</th>
          <th>分类</th>
           <th>访问数</th>
           <th></th>
     </tr>
   
     
 <c:forEach items="${list}" var="item" varStatus="s">   
        <tr>
           <td>${s.count }</td>
            <td>${item.title }</td>
            <td>${item.typeID }</td>
            <td>${item.accessCount}</td>
            <td><a href="/delArticle?articleID=${item.articleID }&size=2&page=${currPage}">删除</a></td>
        </tr>
</c:forEach> 

  <tr>
  <td colspan="5">
  
  
  <c:if test="${currPage>1 }">
       <a href="manageArticle?size=2&page=${currPage-1}">上一页</a>
  </c:if>     
 <c:if test="${currPage<totalPage }">    
       <a href="manageArticle?size=2&page=${currPage+1}">下一页</a>
</c:if>
  </td>
  </tr>
 </table>
 
 
</body>
</html>