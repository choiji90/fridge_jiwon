<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="resources/jquery-1.11.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#findMyInfo").click(function() {
			 location.href = "${initParam.root}member_findMyInfo.do";
		});
	});
</script>
<form action="${initParam.root}login.do">
	아이디 <input type="text" name="id"><br> 
	패스워드 <input type="text" name="password"><br>
	 <input type="submit" value="로그인">
</form>
<br>
<input type="button" value="아이디/비밀번호 찾기" id="findMyInfo">
