<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.required,.error{color:red}
td{border:#9CF dotted 1px; font-size:12px; height:30px; line-height:30px; vertical-align:middle}
.align_right{text-align:right}
</style>
</head>
<body>
 <div style=" width:800px; margin:auto; margin-top:100px; box-shadow:#069 5px 5px 5px;">
     当前位置：首页 > 个人注册
     <hr/>
     <form action="/regist" method="post">
     <table style="width:100%; border:#03C solid 1px; border-collapse:collapse">
         <tr>
            <td colspan="2" style="background:url(img/bar_1px.jpg) repeat-x; height:35px; line-height:35px; font-size:14px; font-weight:bold">用户基本信息（<font class="required">*</font>为必填信息）
            </td>
         </tr>
         <tr>
            <td class="align_right"><font class="required">*</font>用户名
            </td>
            <td><div>以字母开头，字母与数字或者下划线的组合（3-20位）</div>
              <input type="text" name="loginName" id="loginName" value="${param.loginName}"/>
              <label id="lblLoginName" class="error"></label>
            </td>
         </tr>
         <tr>
            <td class="align_right"><font class="required">*</font>密码
           </td>
            <td><div>字母与数字或者下划线的组合（6位）</div>
                <input type="password" name="pwd" id="pwd"/>
                <label id="lblPwd" class="error"></label>
            </td>
         </tr>
         <tr>
            <td class="align_right"><font class="required">*</font>确认密码
            </td>
            <td><input type="password" id="pwd2"/>
               <label id="lblPwd2" class="error"></label>
            </td>
         </tr>
         <tr>
            <td class="align_right"><font class="required">*</font>电子邮件
            </td>
            <td><input type="text" name="email" id="email"/>
               <label id="lblEmail" class="error"></label>
            </td>
         </tr>
         <tr>
            <td class="align_right"><font class="required">*</font>密码找回问题
            </td>
            <td><input type="text" name="question" id="question"/>
               <label id="lblQuestion" class="error"></label>
            </td>
         </tr>
         <tr>
            <td class="align_right"><font class="required">*</font>密码找回答案
            </td>
            <td><input type="text" name="answer" id="answer"/>
               <label id="lblAnswer" class="error"></label>
            </td>
         </tr>
         <tr>
            <td class="align_right"><font class="required">*</font>验证码
            </td>
            <td><input type="text" name="code" id="code"/>
               <label>
               <% 
                  int ran = (int)( Math.random()*10000);
                  String code = String.valueOf(ran);
                  session.setAttribute("code", code); // session在jsp文件中是内置对象。
                  out.print(code); // out在jsp文件中是内置对象。
               %>
               </label>
               <label id="lblCode" class="error"></label>
            </td>
         </tr>
     </table>
     </form>
     <div style=" width:100%; text-align:center">
         <label class="error">
          <%
            Object o =  request.getAttribute("msg");
            if(null != o){
            	out.print(o);
            }
         %>
         </label>
        
         <button type="button" onclick="window.location='reg_protocal.html'">上一步</button>
         <button type="button" onclick="toRegist();">下一步</button>
     
     </div>
     
     </div>
     <script>
             
         function toRegist(){

            var lblLoginName = document.getElementById("lblLoginName"); // 获取页面元素。根据元素的ID获取。
            lblLoginName.innerText=""; // 设置元素的文本，是这个元素的子元素。
            var lblPwd = document.getElementById("lblPwd");
            lblPwd.innerText="";
            var lblPwd2 = document.getElementById("lblPwd2");
            lblPwd2.innerText="";
            var lblEmail = document.getElementById("lblEmail");
            lblEmail.innerText = "";
            var lblQuestion = document.getElementById("lblQuestion");
            lblQuestion.innerText = "";
            var lblAnswer = document.getElementById("lblAnswer");
            lblAnswer.innerText = "";
            var lblCode = document.getElementById("lblCode");
            lblCode.innerText = "";


            // loginName校验
            var loginNameRegexp = /^[a-zA-Z][a-zA-Z0-9_]{2,19}$/; // 创建正则表达式对象
            var loginName = document.getElementById("loginName").value;
            if(!loginNameRegexp.test(loginName)){  // 用正则表达式对象进行测试，返回测试结果。
               lblLoginName.innerText="用户注册名格式不正确";
               return;
            }

            // loginName唯一校验
            var ajax = new XMLHttpRequest(); // 创建AJAX请求对象xhr
            ajax.onreadystatechange=function(){
               if(ajax.readyState==4 && ajax.status==200){
                  var msg =  ajax.responseText;
                  if(msg!='ok'){
                	  lblLoginName.innerText='注册名已经存在，请修改';
                	  return;
                  }
                  
                  // pwd校验
                  var pwdRegexp = /^[a-zA-Z_0-9]{6}$/;
                  var pwd = document.getElementById("pwd").value;
                  if(!pwdRegexp.test(pwd)){
                     lblPwd.innerText = "密码格式不正确";
                     return;
                  }

                  var pwd2 = document.getElementById("pwd2").value;
                  if(pwd != pwd2){
                     lblPwd2.innerText="密码输入不一致";
                     return;
                  }

                  // email校验
                  var emailRegexp = /^[0-9a-zA-Z_]+@[0-9a-z]+\.(com|cn)$/;
                  var email = document.getElementById("email").value;
                  if(!emailRegexp.test(email)){
                     lblEmail.innerText = "email格式不正确";
                     return;
                  }

                  // question校验
                  var question = document.getElementById("question").value.trim();
                  if(question==''){
                     lblQuestion.innerText = "不能为空";
                     return;
                  }
                  // answer校验
                  var answer = document.getElementById("answer").value.trim();
                  if(answer==''){
                     lblAnswer.innerText = "不能为空";
                     return;
                  }

                  // code校验
                  var code = document.getElementById("code").value.trim();
                  if(code==''){
                     lblCode.innerText = "不能为空";
                     return;
                  }

                  document.forms[0].submit();// 发送表单
                  
                  
               }
            };

            ajax.open("POST", "/ValidateLoginName", false);
            ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            ajax.send("loginName="+loginName);




           

           
         }


     </script>
</body>
</html>