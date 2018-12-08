<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<footer id="footer">
	<section class="container">
		<div class="">
			<h4 class="hLh30">
				<span class="fsize18 f-fM c-999">友情链接</span>
			</h4>
			<ul class="of flink-list">
				<c:forEach items="" var="friendLinkNavigate">
					<li><a href="" title="" <c:if test="">target="_blank"</c:if>></a></li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="b-foot">
			<section class="fl col-7">
				<section class="mr20">
					<section class="b-f-link">
						<c:forEach items="" var="indexNavigate" varStatus="index">
							<a href="" title="" <c:if test="">target="_blank"</c:if>></a>|
								</c:forEach>
						<span></span> <span></span>
					</section>
					<section class="b-f-link mt10">
						<span></span>
					</section>
				</section>
			</section>
		
		</div>
	</section>
</footer>

