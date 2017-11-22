<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.product_order.model.*"%>
<%@ page import="com.prdimg.model.*"%>



<%
	PrdVO prdVO = (PrdVO) request.getAttribute("prdVO");

	List<PrdImgVO> list = (List<PrdImgVO>) request.getAttribute("list");
%>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/houselogo1.png" />
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

.mySlides {display:none}
.demo {cursor:pointer} 

.responsive-flamingo {
	width: 16%;
	height: auto;
}
</style>
</head>



<body>

<div class="container-fluid backgroundpng">
        <img class="row" src="<%=request.getContextPath()%>/images/fixed_bg.png">
    </div>

<div>
<nav class="navbar navbar-fixed-top">
        <jsp:include page="/front/navbar.jsp" />
</nav>
</div>


	<div class="col-sm-8 container-fluid">
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<!-- one----------------------------------------------------------------------------------------------------------- -->
		<div class="row">
			<!-- 主區塊左側 -->
			<div class="col-xs-12 col-sm-6 row">
				<div class="row">
					<!-- 商品圖大區塊  -->
					<div>
						<c:forEach var="PrdImgVO" items="${list}">


								 <img class="card-img-top mySlides"
									src="<%=request.getContextPath()%>/front/tools/showimage.do?getImg=by_img_no&img_no=${PrdImgVO.img_no}"
									alt="Product image" id="">
								

							</c:forEach>
					</div>
					<!-- 商品圖大區塊結束  -->
				</div>
				<div class="row">
					<!-- 商品圖小區塊  -->
					<div class="w3-row-padding w3-section">
						<div class="item w3-col s4">

							<%int currentimg = 0; %>
							<c:forEach var="PrdImgVO" items="${list}">


								 <img class="responsive-flamingo demo w3-opacity w3-hover-opacity-off"
									src="<%=request.getContextPath()%>/front/tools/showimage.do?getImg=by_img_no&img_no=${PrdImgVO.img_no}"
									alt="Product image" onmouseover="currentDiv(<%=++currentimg %>)">
								

							</c:forEach>
						</div>
					</div>
					<!-- 商品圖小區塊 結束  -->
				</div>
			</div>
			<!-- 左側區塊結束 -->
			<!-- 主區塊右側 -->
			<div class="col-xs-12 col-sm-6">
				<div class="col-sx-12 col-sm-12 card">
					<div>
						<!-- 商家 -->
Product_orderService product_orderService = new Product_orderService();
	LIST<Product_orderVO> list = product_orderService.getAllBySlrRate(slr_no);
						${PrdVO.slr_no}
					</div>

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

					<div class="card-body">
						<div class="row">
							數量:<select class="selectpicker" name="prd_stock">


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
							<a href="#" class="btn btn-primary">馬上購買</a>
						</div>
					</div>
				</div>
			</div>
			<!-- 主區塊右側結束 -->
		</div>
		<!-- 主區塊第一列結束 -->
		<div></div>
		<!-- two----------------------------------------------------------------------------------------------------------- -->
		<!-- two----------------------------------------------------------------------------------------------------------- -->
		<!-- two----------------------------------------------------------------------------------------------------------- -->

		<div class="row border border-primary"></div>
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

		<script>
			var slideIndex = 1;
			showDivs(slideIndex);

			function plusDivs(n) {
				showDivs(slideIndex += n);
			}

			function currentDiv(n) {
				showDivs(slideIndex = n);
			}

			function showDivs(n) {
				var i;
				var x = document.getElementsByClassName("mySlides");
				var dots = document.getElementsByClassName("demo");
				if (n > x.length) {
					slideIndex = 1
				}
				if (n < 1) {
					slideIndex = x.length
				}
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				for (i = 0; i < dots.length; i++) {
					dots[i].className = dots[i].className.replace(
							" w3-opacity-off", "");
				}
				x[slideIndex - 1].style.display = "block";
				dots[slideIndex - 1].className += " w3-opacity-off";
			}
			
			$(document).ready(function(){
				$(".w3-hover-opacity-off").mouseenter(function(){
					$(this).css("border","1px solid #efefef");
					$(this).css("box-shadow","2px 2px 2px gray");
				    
				});
				$(".w3-hover-opacity-off").mouseleave(function(){
					$(this).css("border","none");
					$(this).css("box-shadow","none");
				});
			});
		</script>
	</div>
</body>

</html>