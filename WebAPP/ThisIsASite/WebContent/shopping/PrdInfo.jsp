<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.prdimg.model.*"%>


<%
	PrdVO prdVO = (PrdVO) request.getAttribute("prdVO");
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
	<div class="col-sm-8 container-fluid">
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<div class="row">
			<!-- 主區塊左側 -->
			<div class="col-xs-12 col-sm-6 row">
				<div class="col-xs-12 col-sm-10">
					<!-- 商品圖大區塊  -->
					<div>
						<a href="#"> <img class="card-img-top"
							src="<%=request.getContextPath()%>/tool/showimage.do?getImg=prdimg&prd_no=PD00000001"
							alt="Product image">
						</a>
					</div>
					<!-- 商品圖大區塊結束  -->
				</div>
				<div class="col-xs-12 col-sm-2">
					<!-- 商品圖小區塊  -->
					<div>
						<a href="#"> <img class="card-img-top"
							src="<%=request.getContextPath()%>/tool/showimage.do?getImg=prdimg&prd_no=PD00000001"
							alt="Product image">
						</a> <a href="#"> <img class="card-img-top"
							src="<%=request.getContextPath()%>/tool/showimage.do?getImg=prdimg&prd_no=PD00000002"
							alt="Product image">
						</a> <a href="#"> <img class="card-img-top"
							src="<%=request.getContextPath()%>/tool/showimage.do?getImg=prdimg&prd_no=PD00000003"
							alt="Product image">
						</a>
					</div>
					<!-- 商品圖小區塊 結束  -->
				</div>
			</div>
			<!-- 左側區塊結束 -->
			<!-- 主區塊右側 -->
			<div class="col-xs-12 col-sm-6">
				<div class="col-sx-12 col-sm-12 card">
					<br>
					<!-- 標題 -->
					<div class="row info_title">
						<h2 class="card-title">${PrdVO.prd_name}</h2>
					</div>
					<br>
					<!-- 價錢 -->
					<div class="">
						<h3 class="text-danger">$${PrdVO.prd_price}</h3>
					</div>
					<!-- 主要區塊的細節們 -->

					<div class="">
						<div class="sameRow">${PrdVO.prd_desc}</div>
					</div>
					<!-- 做到這裡 -->
					>
					<!-- 做到這裡 -->
					>
					<!-- 做到這裡 -->
					>
					<div class="card-body">
						<div class="row">
							<select class="selectpicker" name="prd_stock">


								<%
									/* for (int stock = 0; stock<10 ;stock++){
								%>
								<option value='<%=stock%>'><%=stock%></option>
								<%
									}*/
								%>


								<c:forEach var="item" begin="1" end="${PrdVO.prd_stock}">
									<option value='${item}'>${item}</option>
								</c:forEach>
								
							</select>
						</div>

						<div class="row">
							<a href="#" class="btn btn-primary ">加入購物車</a>
						</div>
						<br>
						<div class="row">
							<a href="#" class="btn btn-primary">立刻購買</a>
						</div>
					</div>
				</div>
			</div>
			<!-- 主區塊右側結束 -->
		</div>
		<!-- 主區塊第一列結束 -->
		<div></div>

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