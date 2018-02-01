<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">

<title>FavBooks 好きな本でつながる</title>
</head>
<body>
	<header>
		<div id="title-box">
			<div id="main-title"><a href='<s:url action="GoHomeAction" />'>FavBooks</a></div>
			<div id="sub-title">好きな本でつながる</div>
		</div>
		
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
		<div id="search-form">
			<h1>Search Books!</h1>
				<s:form action="SearchBookAction">
						<input id ="search-box" type="text" name="searchWord" placeholder="タイトル/著者"/>
							<s:submit value="Search" cssClass="sr-btn"/>
				</s:form>

			<br>
			<s:if test="bookErrorMessage != null ">
				<s:property value="bookErrorMessage" />
			</s:if>
			<s:if test="bookErrorMessage == null ">
				<s:if test="session != null">
					<s:iterator value="session.searchBookDTOList" status="st">
						<s:form action="CheckAction">
							<table id="book">
								<tbody>
								<tr>
									<td id="book-img">
										<img src="<s:property value="img" />" width="128">
									</td>
									<td id="book-info">
										<p id="book-title">タイトル:&nbsp;<s:property value="title"/></p>
												<p>著者:&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;<s:iterator value="authorsList">
													<s:property />
												</s:iterator></p>
												<p>発刊日:&nbsp;&nbsp;<s:property value="publishedDate" /></p>
												説明:<div id="des"><s:property value="description"/></div>
										<div id="card-back">
										</div>
										<br>
										<a id="check-btn" href='<s:url action="CheckAction"><s:param name="checkNum" value="#st.index" /></s:url>' >check!</a>
									</td>
								</tr>
								</tbody>
							</table>
						</s:form>
					</s:iterator>
				</s:if>
			</s:if>
		</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>