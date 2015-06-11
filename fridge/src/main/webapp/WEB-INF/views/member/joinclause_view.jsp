<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkForm(){
	var agreeComp1=document.checkBoxForm.agree1;
	var agreeComp2=document.checkBoxForm.agree2;
	var flag=false;
	if(agreeComp1.checked&&agreeComp2.checked){
		flag=true;
		location.href="${initParam.root}member_registerForm.do";
	}
	if(flag==false)
				alert("동의하셔야 가입가능한디");
}
</script>
</head>
<body>
약관내용 
쭉
쭉
쭉<br>
<form name="checkBoxForm">
	<input type="checkbox"  name="agree1" value="약관1동의"> 동의합니당1 <br>
	약관내용2
	쭉
	쭉
	쭉<br>
	<input type="checkbox"  name="agree2" value="약관1동의"> 동의합니당2 <br>
	<input type="button" value="확인" onclick="checkForm()">
</form>

</body>
</html>