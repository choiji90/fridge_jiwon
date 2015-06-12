<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
${sessionScope.mvo.name} 님 . . . .
정말 탈퇴하시겠습니까? <br>
<form action="${initParam.root}member_passwordCheck_delete.do">
비밀번호 <input type="text"  name="password"> 
<input type="hidden" name="id" value="${sessionScope.mvo.id}">
<input type="submit" value="탈퇴하기">
</form>
