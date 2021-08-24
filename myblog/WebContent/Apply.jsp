<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
#bg{width:800px;height:400px; margin:auto}
#li{width:100%;border:#006 solid 1px}
#left{width:30%;height:100%}
#right{width:70%;height:100%}
#co{color:red}
#footer{widtt:100%;height:50px; text-align:center}
td{ border:#09F solid 1px}
</style>
</head>

<body>
  <div id="bg">
  <form action="/applyBlog" method="post" enctype="multipart/form-data">
    <table id="li"  style=" border-collapse:collapse">
      <tr  >
        <td  id="left"><font id="co">*</font>博客名称
        </td>
         <td id="right"><input type="text" name="blogName"/>
        </td>
      <tr>
      <tr>
        <td>昵称</td>
         <td><input type="text"  name="nickName"/>
        </td>
      <tr>
      <tr>
        <td >个人头像</td>
         <td><input type="file" name="photo"/>
        </td>
      <tr>
    </table>
    </form>
    <div id="footer">
      <input onclick="document.forms[0].submit();" style="background:url(img/bar_1px.jpg) repeat-x; width:100px; height:38px; border-radius:5px; border:#999 ridge 2px;" type="button" value="确定" />
    </div>
  </div>
</body>
</html>