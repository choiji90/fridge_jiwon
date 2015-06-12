<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script type="text/javascript" src="resources/jquery-1.11.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#findMyId").click(function() {
			alert($("#findMyIdForm").serialize());
			$.ajax({
				type:"POST",
				url:"member_findMyId.do",
				data:$("#findMyIdForm").serialize(),	
				success:function(data){						
					if(data=="fail"){
						$("#findMyIdView").html("정보無");
					}else{						
						$("#findMyIdView").html("회원님의 아디는 '"+data+"' 입니다");		
					}					
				}//callback			
			});//ajax
		});//keyup
		
		
		
		$("#findMyPassBtn").click(function(){
	         alert($("#findMyPasswordForm").serialize());
	         $.ajax({
	            type:"post",
	            url:"member_findMyPassword.do",
	            data:$("#findMyPasswordForm").serialize(),
	            success:function(data){                  
	                     if(data=="fail"){
	                        $("#findMyPassView").html("정보無");
	                     }else{                  
	                        $("#findMyPassView").html("회원님의 비밀번호 '"+data+"' 입니다");      
	                     }               
	                  }//callback      
	         });//ajax
	      });
	});
</script>
<form action="${initParam.root}findMyId.do" id="findMyIdForm">
	  이  름 : <input type="text" name="name"><br>
	 이메일: <input type="text" name="email"><br>
	 가장 좋아하는 음식은? <br>
	    답  : <input type="text" name="answer"><br>
	  <input type="button"  id="findMyId" value="아이디 찾기">
</form>
<hr>
<form action="${initParam.root}findMyPassword.do" id="findMyPasswordForm">
   아이디 : <input type="text" name="id" id="id"><br>
     이  름 : <input type="text" name="name"><br>
    이메일: <input type="text" name="email"><br>
    가장 좋아하는 음식은? <br>
       답  : <input type="text" name="answer"><br>
     <input type="button" id="findMyPassBtn" value="비밀번호 찾기">
</form>

<span id="findMyPassView"></span>
   <span id="findMyIdView"></span><br>  