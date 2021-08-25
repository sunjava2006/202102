<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.wangrui.myblog.bean.User,com.wangrui.myblog.bean.Blog"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/blog.css" rel="stylesheet"></link>
</head>

<body>


    <div id="page">
        <div id="head">
            <div id="menu_bar">
                <div id="menu_bar_img">
                        <img src="img/dot.jpg"  style="margin:6px;float:left"/>
                        
                        <ul id="logon">
                        
<%
                 Object userInfo = session.getAttribute("userInfo");
                 if(null == userInfo){
%>                        
                            <li><a href="reg_protocal.html">注册</a></li>
                            <li><label>|</label></li>
                            <li><a href="/Logon.jsp">登录</a></li>
                            <li><label>|</label></li>
                            
<%
                 }else{
                	  User u = (User)userInfo;
%>
                            <li><a>你好
                               <%=u.getLoginName() %>
                               <% out.print(u.getLoginName()); %></a>
                            </li>
                            <li><label>|</label></li>
                            <li><a href="/logout">退出</a></li>
                            <li><label>|</label></li> 
<%                	 
                 }

%>                            
                            
                            
                            
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
<%
           if(userInfo!=null){
        	   
%>                
               
<%
               Object blogInfo = session.getAttribute("blogInfo");
               if(blogInfo!=null){
            	   Blog b = (Blog)blogInfo;
%>                
                    <a href="/myBlog?blogID=<%=b.getBlogID() %>">我的博客</a>
<%
               }else{
%>                    
                    <a href="/Apply.jsp">申请博客</a>
                
<%
               }
           }
%>                
              </div>  
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
            访问数：<%=application.getAttribute("accessCount") %>
     当前用户数：${currentCount}      
           
当前在线会员：${loginUsers}
        </div>
        
    </div>




</body>
</html>