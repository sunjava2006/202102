<%@ page language="java" contentType="text/html; charset=UTF-8"
    
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>小点点专业技术博客首页</title>
<link href="css/blog.css" rel="stylesheet"></link>
</head>

<body>
<%
System.out.println(application.getRealPath("/"));
%>

    <div id="page">
        <div id="head">小点点专业技术博客
        </div>
            <div id="menu_bar">
                <div id="menu_bar_img">
                        <img src="img/dot.jpg"  style="margin:6px;float:left"/>
                        
                        <ul id="logon">
                        
<c:choose>   
    <c:when test="${empty userInfo}">                   
                            <li><a href="reg_protocal.html">注册</a></li>
                            <li><label>|</label></li>
                            <li><a href="/Logon.jsp">登录</a></li>
                            <li><label>|</label></li>
    </c:when>
    <c:otherwise>
                            <li><a>你好${userInfo.loginName}
                               </a>
                            </li>
                            <li><label>|</label></li>
                            <li><a href="/logout">退出</a></li>
                            <li><label>|</label></li> 
   </c:otherwise>
</c:choose>                            
                            
                            
                            
                        </ul>
                
                
                </div>
                <div id="select">
                   
                    <select name="selectType" style="margin-top:5px;" >
                        <option>文章名</option>
                        <option>文章分类</option>
                        <option>博客名</option>
                    </select>
                    <input type="text" name="key"/>
                    <input type="button" value="检索"/>
                </div>
                 <div id="about_blog">
                 
 <c:if test="${! empty userInfo }">                

      <c:choose>
          <c:when test="${! empty blogInfo }">


                    <a href="/myBlog">我的博客</a>
           </c:when>
           <c:otherwise>
                   
                    <a href="/Apply.jsp">申请博客</a>
           </c:otherwise>
     </c:choose>           
</c:if>
               
              </div>  
            </div>
        
      
        <!-- =============== end of  head ============================================================ -->
        
        <div id="content">
            <div id="left">
                <div class="list" style="height:50%">
                     <label>文章分类</label>
                     <ul class="none_list">
                         <li><a >编程技巧</a></li>
                         <li><a >数据库知识</a></li>
                         <li><a >Java Web开发</a></li>
                     </ul>
                </div>
                <div class="list" style="height:50%">
                    <label>博客排名</label>
                    <ul class="decimal_list">
                         <li><a>鸟叔的Linux之门</a></li>
                         <li><a>Java编程随笔</a></li>
                         <li><a>Java教学知识点集汇</a></li>
                     </ul>
                </div>
            </div>
           <iframe id="main" src="index_content.html"></iframe>
        </div>
        <!-- =============== end of  content ======================================================== -->
        <div id="foot">
            访问数：${accessCount}
     当前用户数：${currentCount}      
           
当前在线会员：${loginUsers}
        </div>
        
    </div>




</body>
</html>