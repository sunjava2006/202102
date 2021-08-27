<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.List, com.wangrui.myblog.bean.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="/publishArticle" method="post">
     <table>
         <tr>
             <td>文章标题</td>
             <td><input type="text" name="title"></td>
         </tr>
         <tr>
             <td>文章分类</td>
             <td>
                 <select name="typeID">
<%
        Object o =  request.getAttribute("typeList");
        if(null!=o){
        	List<Type> list = (List<Type>)o;
        	for(Type t : list){

%>
                    <option value="<%=t.getTypeID()%>"> <%=t.getTypeName()%> </option>
                    
<%
        	}
        }

%>                    
                    
                 </select>

             </td>
         </tr>
         <tr>
             <td>正文</td>
             <td><textarea name="content" id="" cols="30" rows="10"></textarea></td>
         </tr>
     </table>
      <input type="submit" value="发表文章">
 
 
 </form>
</body>
</html>