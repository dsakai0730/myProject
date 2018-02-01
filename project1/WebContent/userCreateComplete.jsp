<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>FavBooks | SubscribeComplete</title>
</head>
<body>
	<header>
		<div id="main-title"><a href='<s:url action="GoHomeAction" />'>FavBooks</a></div>
		<div id="sub-title">好きな本でつながる</div>
		<div id="top-list">
			<ul>
				<li><s:property value="session.userName" />さん</li>
				<li><a href = '<s:url action = "GoHomeAction" />' >ホーム</a></li>
				<li><a href = '<s:url action = "MyPageAction" />' >マイページ</a></li>
				<li><a href = '<s:url action = "LogoutAction" />' >ログアウト</a></li>
			</ul>
		</div>
	</header>
	<div id="main">
		<h3>ユーザー登録が完了しました！</h3>
		<div id="a-link">
			<a href = '<s:url action = "GoHomeAction" />' >ホームへ</a>
			<br>
			<br>
			<a href = '<s:url action = "MyPageAction" />' >マイページへ</a>
		</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>