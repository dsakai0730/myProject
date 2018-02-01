<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録確認</title>
</head>
<body>
	<header>priject1</header>
	<div id="main">
		<h3>以下の内容で商品を登録します。</h3>
		<div>
			<s:form action="RegItemCompleteAction">
			<table>
					<tr id="box">
						<td>
							<label>タイトル:</label>
						</td>
						<td>
							<s:property value="session.itemName" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>カテゴリー:</label>
						</td>
						<td>
							<s:property value="session.itemCategory" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>単価:</label>
						</td>
						<td>
							<s:property value="session.itemPrice" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>個数:</label>
						</td>
						<td>
							<s:property value="session.itemCount" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>合計金額:</label>
						</td>
						<td>
							<s:property value="session.itemTotalPrice" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>検索ワード:</label>
						</td>
						<td>
							<s:property value="session.itemSearchWord" escape="false" />
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="完了" />
						</td>
					</tr>
			</table>
			</s:form>
		</div>
	</div>
</body>
</html>