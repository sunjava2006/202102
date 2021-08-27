<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, com.wangrui.myblog.bean.*"
    pageEncoding="UTF-8"%>
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
         <th>标题</th>
          <th>分类</th>
           <th>访问数</th>
           <th></th>
     </tr>
<%
int totalPage = (Integer)request.getAttribute("totalPage");
int currPage = (Integer)request.getAttribute("currPage");
     Object o = request.getAttribute("list");
	if(null != o){
		List<Article> list = (List)o;
		for(Article a : list){
	
%>     
     
     
        <tr>
            <td><%=a.getTitle() %></td>
            <td><%=a.getTypeID() %></td>
            <td><%=a.getAccessCount() %></td>
            <td><a href="/delArticle?articleID=<%=a.getArticleID()%>&size=2&page=<%=currPage%>">删除</a></td>
        </tr>

<%
		}
	}
%>

  <tr>
  <td colspan="4">
  <%
    if(currPage>1){
  %>
       <a href="manageArticle?size=2&page=<%=currPage-1%>">上一页</a>
       
 <%
    }
   if(currPage<totalPage){
 %>      
       <a href="manageArticle?size=2&page=<%=currPage+1%>">下一页</a>
 <%
   }
 %>
  </td>
  </tr>
 </table>
 
 
</body>
</html>