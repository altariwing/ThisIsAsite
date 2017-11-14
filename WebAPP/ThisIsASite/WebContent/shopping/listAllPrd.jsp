<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.prdimg.model.*"%>


<%
	PrdService prdService = new PrdService();
	List<PrdVO> list = prdService.getAll();
	pageContext.setAttribute("list", list);
%>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="shortcut icon" href="images/houselogo1.png" />
<title>For House</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">




<style>
h4 {
	position: relative;
	line-height: 1.4em;
	/* 1 times the line-height to show 1 lines */
	height: 1.4em;
	overflow: hidden;
}

#prd_desc {
	position: relative;
	line-height: 1.4em;
	/* 3 times the line-height to show 3 lines */
	height: 4.2em;
	overflow: hidden;
}

#prd_desc::after {
	content: "...";
	font-weight: bold;
	position: absolute;
	bottom: 0;
	right: 0;
	padding: 0 20px 1px 45px;
	background:
		url(http://css88.b0.upaiyun.com/css88/2014/09/ellipsis_bg.png)
		repeat-y;
}
</style>
</head>



<body>
	<div class="col-sm-10 container-fluid">
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<div class="row">
			<div class="col-sm-3">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Special title treatment</h4>
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<a href="#" class="btn btn-primary float-right">Go somewhere</a>
					</div>
				</div>
			</div>
			<!-- col-sm-9 -->
			<div class="col-sm-9 row">
				<!-- a product row -->
				<c:forEach var="PrdVO" items="${list}">
					<div class="col-sm-4">
						<div class="card">
							<img class="card-img-top"
								src="<%=request.getContextPath()%>/tool/showimage.do?getImg=prdimg&prd_no=${PrdVO.prd_no}"
								alt="Product image">
							<div class="card-body">

								<form action="shop.do" method="POST">
									<input type="hidden" name="prd_no" value="${PrdVO.prd_no}">
									<input type="hidden" name="requestURL"
										value="<%=request.getServletPath()%>">
									<!--送出本網頁的路徑給Controller-->
									<input type="hidden" name="action" value="getOne_Product">
									<a href="javascript:;" onclick="parentNode.submit();">
										<h4 class="card-title">${PrdVO.prd_name}</h4>
									</a>
									
									
								</form>

								<div id="prd_desc" class="card-text">${PrdVO.prd_desc}</div>
								<h4 class="card-text text-danger">$${PrdVO.prd_price}</h4>
								<a href="#" class="btn btn-primary float-right">立刻購買</a>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- end a product row -->

			</div>
			<!-- end col-sm-9 -->
		</div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
			integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
			crossorigin="anonymous"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
			integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
			crossorigin="anonymous"></script>
	</div>
</body>

</html>