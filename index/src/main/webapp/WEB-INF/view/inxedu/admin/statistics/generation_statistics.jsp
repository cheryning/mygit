<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加试题</title>
<script src="${ctximg}/static/common/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.js"></script>
<script src="${ctximg}/static/common/jquery-ui-1.10.4/js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="${ctximg}/static/common/jquery-ui-1.10.4/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${ctximg}/static/common/jquery-ui-1.10.4/js/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript">
	$(function(){
		  $( "#startTime,#endTime" ).datepicker(
		    		{regional:"zh-CN",
		    		changeMonth: true,
		    		dateFormat:"yy-mm-dd "
		    		});
		
	});
	function doSubmit(){
		var startTime=$("#problems").val();
		var endTime=$("#answer").val();
		var operate=$("#operate").val();
		var url='';
		if(operate==0){
			alert("请选择操作");
			return;
		}
		
		url='/admin/statistics/create/answer';
		/*
		else if(operate==1){
			url='/admin/statistics/create/batch';
		}else if(operate==2){
			url='/admin/statistics/del/batch';
		}
		*/
		if(startTime==null||startTime==''){
			alert("请输入题目");
			return;
		}
		if(endTime==null||endTime==''){
			alert("请输入正确答案");
			return;
		}
		/*
		var begin=new Date($("#startTime").val().replace(/-/g,"/"));
	    var end=new Date($("#endTime").val().replace(/-/g,"/"));
		if(begin>end){
			alert("结束日期必须大于开始日期");
			return;
		}
		var date = new Date();
		date.setDate(date.getDate()-1);
		if(date<end){
			alert("结束日期不能大于等于当前时间");
			return;
		}
		*/
		$.ajax({
			url:'${ctx}'+url,
			type:"post",
			data:{"startTime":startTime,"endTime":endTime,"operate":operate},
			dataType:"json",
			success:function(result){
				if(result.message=='true'){
					alert("添加成功！");
				}else if (result.message=='exists'){
					alert("添加失败！");
				}
			}
		})
	}
</script>
</head>
<body>
<fieldset>
	<legend>
		<span>试题管理</span>
		&gt;
		<span>添加试题</span>
	</legend>
	<div>
	<form action="" method="post" id="statisticsForm">
		<table width="100%" cellspacing="0" cellpadding="0" border="0" class="commonTab01">
			<tbody>
				<tr>
					<td align="center"><font color="red">*</font>&nbsp;题目</td>
					<td>
						<input type="text"   id="problems" />
					</td>
				</tr>
				<tr>
					<td align="center"><font color="red">*</font>&nbsp;正确答案</td>
					<td>
						<input type="text"   id="answer" class="AS-inp"/>
					</td>
				</tr>
				<tr>
					<td align="center"><font color="red">*</font>&nbsp;课程</td>
					<td>
						<select id="operate">
							<option value="0">--请选择--</option>
							<option value="27">java</option>
							<option value="28">oracle</option>
							<option value="29">高等数学</option>
							<option value="30">四级英语</option>
							<option value="31">计算机二级</option>
							<option value="32">大学生创新与创业</option>
							<option value="33">游戏制作</option>
							<option value="34">机器人学习</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<a class="button tooltip" title="执行" href="javascript:doSubmit()">添加</a>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</fieldset>
</body>
</html>