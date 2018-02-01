<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>FavBooks | Login</title>
</head>
<body>
	<header>
		<div id="main-title"><a href='<s:url action="GoHomeAction" />'>FavBooks</a></div>
		<div id="sub-title">好きな本でつながる</div>
		<div id="top-list">
			<ul>
				<li>ゲストさん</li>
				<li><a href = '<s:url action = "GoHomeAction" />' >ホーム</a></li>
			</ul>
		</div>
	</header>
	<div id="main">
		<div id="content">
			<p>ログイン画面</p>
		</div>
		<br>
		<div id="a-box">
			<s:form action="LoginAction">
				<div id="error-message">
					<s:if test="session.loginErrorMessage != 'ok'">
						<s:property value="session.loginErrorMessage"/>
					</s:if>
				</div>
				<table id="a-form">
					<tbody>
						<tr>
							<td>
								<label>ユーザーID:</label>
							</td>
							<td>
								<input type="text" name="loginUserId" />
							</td>
						</tr>
						<tr>
							<td>
								<label>パスワード:</label>
							</td>
							<td>
								<input type="password" name="loginPassword" />
							</td>
						</tr>
					</tbody>
				</table>
				<a href='<s:url action="GoHomeAction" />' id="b-btn" >Back</a>
				<s:submit value="Login" cssClass="a-btn"/>
			</s:form>
		</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>