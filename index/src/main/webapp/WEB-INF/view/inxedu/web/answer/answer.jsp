<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>测试</title>
</head>
<body>

   <%
                String courseId=request.getParameter("courseId");
        %>
<!-- /无数据提示 开始-->
                
	<div id="aCoursesList" class="bg-fa of">
		<section class="container">
			<section class="i-article">
			<form action="${ctx}/an/testanswer/<%=request.getAttribute("courseId")%>" method="post" id="form1">
				<div class="fl col-7">
					<section class="mr30">
						<header class="comm-title all-article-title">
							<h2 class="fl tac">
								<span class="c-333">测试</span>
							</h2>
							<section class="c-tab-title">
								<a href="javascript: void(0)">&nbsp;</a>
							</section>
						</header>					
						<c:if test="${empty answerList }">
							<section class="no-data-wrap">
								<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
							</section>
						</c:if>	
						<!-- /无数据提示 结束
						<article class="i-article-list">
						-->
							<!-- /文章列表 开始-->
							<ul>
								<c:if test="${not empty answerList }">
									<c:forEach var="answer" items="${answerList}" varStatus="status">
										<li id = "url${answer.id}" style="margin:15px;border-bottom:dashed 1px #3e3e3e;padding:15px 0px">
												<%-- <input type="hidden" name="id" value="${answer.id}" /> --%>
												<p>
													<span  id = "${answer.id}" ;class="c-999 f-fA" style="color:#080808;font-size:20px">${answer.subject}( )</span>
												</p>
												<p>
					
										
												正确<input style="margin:10px" type="radio" name = "${answer.id}"   value = "A"></input> 
												错误<input type="radio" name = "${answer.id}"  value = "B"></input>
												</p>
											
										</li>
										
									</c:forEach>
								</c:if>
								<%-- <input type="hidden" name = "courseId" value ="<%=request.getAttribute("courseId")%>"></input> --%>
								<input style="float:right;margin-top:20px;padding:10px 25px;border-radius:10px" type = "button" onclick="submitAnswer()"  value = "提交" ></input>
							</ul>
							<!-- /文章列表 结束
						</article>
						-->
						<!-- 公共分页 开始 -->
					
					</section>
				</div>
				</form>

				<div class="clear"></div>
				<div style="margin-top:20px">
				  <sapn id ="score";class="c-999 f-fA" style="color:#080808;font-size:30px">最终得分：</sapn>
				  <sapn id ="finally";class="c-999 f-fA" style="color:#FF0000;font-size:30px"></sapn>
				</div>
			</section>
		</section>
		<!-- /文章列表 结束 -->
	</div>
	<script src="${ctx }/static/inxweb/acticle/acticle.js" type="text/javascript"></script>
	<script>
var courseId = <%=request.getAttribute("courseId")%> 
function json(data) {  
    data=data.replace(/&/g,"\",\"");  
    data=data.replace(/=/g,"\":\"");  
    data="{\""+data+"\"}";  
    return data;  
 }
	function submitAnswer(){
		
		//console.log("1"+json($('#form1').serialize()));
	//	console.log("1"+$('#form1').serialize());
		$.ajax({
			 url:baselocation+'/an/testanswer/'+courseId, 
		/*	url:baselocation+'/an/testanswer',*/
			type:'post',
			//async:$('#form1').serialize(),
			dataType:'json',
		//	data: json($('#form1').serialize()),
			data:$('#form1').serialize(),
			success:function(result){
				 
			//	parseInt(result["score"]);
				if(parseInt(result["score"]) >= 70){
					var ht1 = '<span id ='+i+' style="color:#FF0000">（考核通过）</span>'
					$('#finally').append(ht1);
				}
				else{
					var ht2 = '<span id ='+i+' style="color:#FF0000">（考核不通过）</span>'
					$('#finally').append(ht2);
					
				}
		    for(var i in result){
		    	 var ht = '<span id ='+i+' style="color:#FF0000">'+result[i]+'</span>'
		    	
		    	 $('#'+i).append(ht);
		    }		
		
			}

		});
	}

	
	   var message = '<%=session.getAttribute("message")%>'
		
    
	     if(message != "null"){
   	 
	    	 alert("答案错误！");
	    	
	     }
	
	
	/*
		$(function() {
			articleRecommend();//好文推荐
			scrollLoad(); //响应滚动加载课程图片
		});
	*/
	</script>
</body>
</html>