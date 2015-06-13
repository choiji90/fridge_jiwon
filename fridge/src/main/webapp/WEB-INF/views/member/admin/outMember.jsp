<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="resources/jquery-1.11.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   $("#deleteBtn").click(function(){
      if(confirm("삭제하시겠습니까?")){
         location.href="${initParam.root}admin_delete.do";
      };

   });
});
</script>
<%--  <a href="${initParam.root}home.do">홈으로~</a> --%>
<!-- < !DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(confirm("탈퇴하시겠습니까?"){
	alert("탈퇴");
	}else{
		alert("ddd");
	}
</script>
</head>
<body>

</body>
</html> -->