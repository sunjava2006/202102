<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a,a:visited{color: white; text-decoration:none}
.error{color:red;}
</style>
</head>
<body>
   <div style=" width:800px; height:400px; margin:auto; background:#0CC; ">
     <div style=" background-color:#399; width:400px; height:200px; margin:auto ; padding:5px; border:#069 solid 2px; position:relative; top:100px;">
      <label style=" font-family:华文彩云; color:white; font-size:32px; margin:5px;">用户登录</label>
      <hr style="border:#369 dotted 1px;"/>
      <!---------------------------------------------------------------------------->
      <form action="/login" method="post">
          <table width="400" border="0" align="center" style="font-size:14px; color:white;">
  <tr>
    <td width="77" rowspan="3"><img src="img/logon.jpg"/></td>
    <td width="59" height="27">用户名</td>
    <td width="68"><input type="text" name="loginName"/></td>
    <td width="78">&nbsp;</td>
  </tr>
  <tr>
    <td height="27">密码</td>
    <td><input type="password" name="pwd"/></td>
    <td><a href="">忘记密码？</a></td>
  </tr>
  <tr>
    <td>验证码</td>
    <td><input type="text" name="code"/></td>
    <td><img src="/codeImg" alt="验证码" style="width:70px; height:20px" onclick="flushCodeImg(this);"/></td>
  </tr>
  <tr>
    <td colspan="4" style=" text-align:center">
    <label class="error">${msg}
    <%
        Object o = request.getAttribute("msg");
        if(null != o){
        	out.print(o);
        }
    %>
    
    </label>
    <button type="button" onclick="location='/reg_protocal.html'">注册</button>
    <button type="button" onclick="document.forms[0].submit();">登录</button>
    </td>
    </tr>
</table>
</form>
 <script>
   function flushCodeImg(img){
	   console.log('33333333333333333');
	   img.src='/codeImg?'+Math.random();
   }
 </script>
      
      
      <!---------------------------------------------------------------------------->
      </div>
   
   </div>
    <div style=" width:800px; height:60px; margin:auto; background-color:#039; position:relative;padding-top:20px; padding-bottom:20px;">
         <p  style=" color:white; text-align:center; ">
              版权所有........................
         </p>
   </div>


</body>
</html>