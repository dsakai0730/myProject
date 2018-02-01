<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/style.css">
<title>MYPAGE</title>
</head>
<body>
	<header>FavBooks
		<ul>
			<li><s:property value="session.userName" />さん</li>
			<li><a href = '<s:url action = "GoHomeAction" />' >ホーム</a></li>
			<li><a href = '<s:url action = "MyPageAction" />' >マイページ</a></li>
			<li><a href = '<s:url action = "LogoutAction" />' >ログアウト</a></li>
		</ul>
	</header>
	<div id="main">
		<div id="content">
			<p>商品登録画面</p>
		</div>
		<br>
		<div id="register-item">
			<p>商品を登録してください</p>

			<div class="reg-item-form">
				<s:if test="itemErrorMessage != ''">
					<div id="error-message">
						<s:property value="itemErrorMessage" escape="false"/>
					</div>
				</s:if>
				<s:form action="RegItemConfirmAction">
					<table>
						<tr id="box">
						<td>
							<label>タイトル:</label>
						</td>
						<td>
							<input type="text" name="itemName" value="">
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>カテゴリー:</label>
						</td>
						<td>
							<select name="itemCategory">
								<option value="">カテゴリーを選択</option>
								<option value="書籍">書籍</option>
								<option value="家電・カメラ・AV機器">家電・カメラ・AV機器</option>
								<option value="ヘルス・ビューティー">ヘルス・ビューティー</option>
								<option value="ファッション">ファッション</option>
								<option value="食品">食品</option>
								<option value="文具">文具</option>
								<option value="スポーツ・アウトドア">スポーツ・アウトドア</option>
								<option value="DVD・ミュージック・ゲーム">DVD・ミュージック・ゲーム</option>
							</select>
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>価格:</label>
						</td>
						<td>
							<input type="text" name="itemPrice" value="">
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>個数:</label>
						</td>
						<td>
							<input type="text" name="itemCount" value="">
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>検索ワード:</label>
						</td>
						<td>
							<textarea name="itemSearchWord" cols="25" rows="10" ></textarea>
						</td>
					</tr>
					<s:submit value="登録"/>
					</table>
				</s:form>
		</div>
		</div>
	</div>
	<footer>copyright daichi sakai</footer>
</body>
</html>