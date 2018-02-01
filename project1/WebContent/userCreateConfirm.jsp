<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>FavBooks | SubscribeConfirm</title>
</head>
<body>
	<header>
		<div id="main-title"><a href='<s:url action="GoHomeAction" />'>FavBooks</a></div>
		<div id="sub-title">好きな本でつながる</div>
	</header>
	<div id="main">
		<h3>以下の内容で登録します。</h3>
		<div id="a-box">
			<s:form action="UserCreateCompleteAction">
				<table id="a-form">
					<tr>
						<td>
							<label>ログインID:</label>
						</td>
						<td id="left-text">
							<s:property value="loginUserId" />
						</td>
					</tr>
					<tr>
						<td>
							<label>ユーザー名:</label>
						</td>
						<td id="left-text">
							<s:property value="userName" />
						</td>
					</tr>
					<tr>
						<td>
							<label>ログインパスワード:</label>
						</td>
						<td id="left-text">
							<s:property value="loginPassword" />
						</td>
					</tr>
				</table>
				<a href='<s:url action="UserCreatePageAction" />' id="b-btn" >Back</a>
				<s:submit value="Complete" cssClass="a-btn"/>
			</s:form>
		</div>
	</div>
</body>
</html>