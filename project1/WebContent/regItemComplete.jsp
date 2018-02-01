<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>HOME</title>
</head>
<body>
	<header><a href='<s:url action="GoHomeAction" />'>project1</a>
			<ul>
				<li><s:property value="session.userName" />さん</li>
				<li><a href = '<s:url action = "GoHomeAction" />' >ホーム</a></li>
				<li><a href = '<s:url action = "MyPageAction" />' >マイページ</a></li>
				<li><a href = '<s:url action = "LogoutAction" />' >ログアウト</a></li>
			</ul>
	</header>
	<div id="main">
		<h3>商品登録が完了しました！</h3>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>