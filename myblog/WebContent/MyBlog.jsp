<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.wangrui.myblog.bean.User,com.wangrui.myblog.bean.Blog"
    pageEncoding="UTF-8"%>
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
        <div id="head">
           ${blogInfo.blogName}
             </div>
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
                            <li><a>${sessionScope.userInfo.loginName}</a>
                            </li>
                            <li><label>|</label></li>
                            <li><a href="/logout">退出</a></li>
                            <li><label>|</label></li> 
<%                	 
                 }

%>                            
                            
                            
                            
                        </ul>
                
                
                </div>
               
            </div>
       
      
        <!-- =============== end of  head ============================================================ -->
        
        <div id="content">
            <div id="left">
                <div class="list" style="height:50%">
                     <img alt="头像" src="/photos/${blogInfo.photo}" style="width:200px;position:relative; left:25px">
                     <label>${blogInfo.nickName }</label>
                     <ul class="none_list">
                         <li><a >修改个人信息</a></li>
                         <li><a >修改密码</a></li>
                         <li><a >维护文章分类</a></li>
                         <li><a href="/manageArticle?page=1&size=2" target="main" >文章维护</a></li>
                     </ul>
                </div>
                <div class="list" style="height:50%">
                    <label>我的关注</label>
                    <ul class="decimal_list">
                         <li><a>关注的博客</a></li>
                         <li><a>收集的文章</a></li>
                         
                     </ul>
                </div>
            </div>
           <iframe id="main" src="/blogInfo" name="main"></iframe>
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