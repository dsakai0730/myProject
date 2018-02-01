<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FavBooks | MyCheck</title>
<link rel = "stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<body>
	<header>
		<div id="main-title"><a href='<s:url action="GoHomeAction" />'>FavBooks</a></div>
		<div id="sub-title">好きな本でつながる</div>
		<div id="top-list">
			<s:if test="session == null">
				<ul>
					<li>ゲストさん</li>
					<li><a href='<s:url action="LoginPageAction" />' >ログイン</a></li>
					<li><a href='<s:url action="UserCreatePageAction" /> '>新規ユーザー登録</a></li>
				</ul>
			</s:if>
			<s:if test="session.loginUserId == null">
				<ul>
					<li>ゲストさん</li>
					<li><a href='<s:url action="LoginPageAction" />' >ログイン</a></li>
					<li><a href='<s:url action="UserCreatePageAction" /> '>新規ユーザー登録</a></li>
				</ul>
			</s:if>
			<s:if test="session.loginUserId != null">
				<ul>
					<li><s:property value="session.userName" />さん</li>
					<li><a href = '<s:url action = "MyPageAction" />' >マイページ</a></li>
					<li><a href = '<s:url action = "FriendPageAction" />' >フォロー</a></li>
					<li><a href = '<s:url action = "LogoutAction" />' >ログアウト</a></li>
				</ul>
			</s:if>
		</div>
	</header>
	<div id="main">
			<s:iterator value="session.myCheck">
				<s:form action="MyCheckAction">
					<table id="book">
					<tbody>
						<tr>
							<td id="book-img">
								<img src="<s:property value="img" />" width="128">
							</td>
							<td id="book-info">
								<p id="book-title">タイトル:&nbsp;<s:property value="title"/></p>
								<p>著者:&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;<s:iterator value="author">
									<s:property />
								</s:iterator></p>
								<p>発刊日:&nbsp;&nbsp;<s:property value="publishedDate" /></p>
								説明:<div id="des"><s:property value="description"/></div>
							<br>
						<s:if test="session.alReadCheck == 'off'">
							<a href='<s:url action="MyAlReadAction" />' id="read" >Favorite!</a>
						</s:if>
						<s:if test="session.alReadCheck == 'on'">
							<a href='<s:url action="MyOffReadAction" />' id="read-off" >Cancel Favorite</a>
						</s:if>
						<a href='<s:url action="MyPageAction" />' id="check-btn" >Back</a>
					</td>
				</tr>
				</tbody>
			</table>
		</s:form>
	</s:iterator>
	<br>
	<footer>copyright daichi sakai</footer>
	</div>
</body>
</body>
</html>