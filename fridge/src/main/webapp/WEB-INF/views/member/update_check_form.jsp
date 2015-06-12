<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="${initParam.root}member_passwordCheck_update.do">
비밀번호 <input type="text"  name="password"> 
<input type="hidden" name="id" value="${sessionScope.mvo.id}">
<input type="submit" value="수정">
</form>
 