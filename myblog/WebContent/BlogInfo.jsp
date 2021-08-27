<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table>
       <tr>
           <td>总文章数：</td>
           <td>${totalArticleCount}</td>
       </tr>
       <tr>
           <td>文章引用的分类：</td>
           <td>${types}</td>
       </tr>
       <tr>
           <td>文章总浏览数：</td>
           <td>${articleTotalAccessCount}</td>
       </tr>
       <tr>
           <td>文章总评论数：</td>
           <td>${articleTotalReviewCount}</td>
       </tr>
    
    </table>
</body>
</html>