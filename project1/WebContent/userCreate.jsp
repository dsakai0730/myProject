<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>FavBooks | UserSubscribe</title>
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
			<p>新規ユーザー登録</p>
		</div>
		<br>

		<div class="user-create-form">
			
				<div id="error-message">
					<s:if test="userErrorMessage != ''">
						<s:property value="userErrorMessage" escape="false"/>
					</s:if>
				</div>
			<div id="a-box">
				<p>※ログインIDは登録後変更することができません。</p>
				<s:form action="UserCreateConfirmAction">
					<table id="a-form">
						<tbody>
							<tr>
								<td>
									<label>ログインID:</label>
								</td>
								<td>
									<input type="text" name="loginUserId" value="">
								</td>
							</tr>
							<tr id="box">
								<td>
									<label>ユーザー名:</label>
								</td>
								<td>
									<input type="text" name="userName" value="">
								</td>
							</tr>
							<tr id="box">
								<td>
									<label>パスワード:</label>
								</td>
								<td>
									<input type="password" name="loginPassword" value="">
								</td>
							</tr>
						</tbody>
					</table>
					<a href='<s:url action="GoHomeAction" />' id="b-btn" >Back</a>
					<s:submit value="Subscribe" cssClass="a-btn"/>
				</s:form>
			</div>
		</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>