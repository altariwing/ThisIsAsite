<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.prdimg.model.*"%>
<jsp:useBean id="pcService" scope="session"
	class="com.prdcategory.model.PcService" />
<jsp:useBean id="slrService" scope="session"
	class="com.slr.model.SlrService" />

<%
	List<PrdVO> list = (List<PrdVO>) request.getAttribute("listEmps_ByCompositeQuery");
	if (list == null) {
		PrdService prdService = new PrdService();
		list = prdService.getAll();
		pageContext.setAttribute("list", list);

	} else {
		pageContext.setAttribute("list", list);
	}
	
	
%>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/images/houselogo1.png" />
<title>For House</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
<script src="https://code.jquery.com/jquery.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/tools/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<!-- Bootstrap CSS -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" -->
<!-- 	crossorigin="anonymous"> -->

<!-- Include SmartCart CSS -->
<link
	href="<%=request.getContextPath()%>/front/shopping/css/smart_cart.min.css"
	rel="stylesheet" type="text/css" />


<style>
body {
	font-family: Arial, Verdana, Helvetica, "LiHei Pro Medium", 微軟正黑體,
		sans-serif;
}

h4 {
	position: relative;
	line-height: 1.4em;
	/* 1 times the line-height to show 1 lines */
	height: 1.4em;
	overflow: hidden;
}

#marketDiv {
	margin-top: 130px;
}

#searchOption {
	margin-left: 70px;
}

#priceRange {
	padding: 4px;
}

#eachProduct img {
	max-height: 300px;
}
</style>
</head>



<body>

	<div class="container-fluid backgroundpng">
		<img class="row"
			src="<%=request.getContextPath()%>/images/fixed_bg.png">
	</div>

	<nav class="navbar navbar-fixed-top">
		<jsp:include page="/front/navbar.jsp" />
	</nav>


	<div class="row" id="marketDiv">


		<div class="col-md-2 col-sm-6" id="searchOption">
			<h3 class="">
				<b>搜尋商品</b>
			</h3>
			<!-- ul開始 -->
			<FORM METHOD="post" ACTION="shop.do">
				<input type="hidden" name="action" value="listPrd_ByCompositeQuery">


				<b>輸入查詢字串:</b> <input type="text" name="prd_name">
				<p>
					<!-- 選擇商品分類 -->
				<p>
					<b>商品分類:</b>
					<c:forEach var="PcVO" items="${pcService.all}">
						<input type="radio" id="${PcVO.cate_name}" name="cate_no"
							value="${PcVO.cate_no}">
						<label for="${PcVO.cate_name}">${PcVO.cate_name}</label>
					</c:forEach>
				<p>
					<b>選擇品牌:</b> <br>
					<!-- 選擇品牌 -->
					<c:forEach var="SlrVO" items="${slrService.allSlr}">
						<input type="checkbox" id="${SlrVO.slr_name}" name="slr_no"
							value="${SlrVO.slr_no}">
						<label for="${SlrVO.slr_name}">${SlrVO.slr_name}</label>
						<br>
					</c:forEach>
					<br> <b>價格區間:</b> <select name="price_range" id="priceRange">
						<option value="0">請選擇價格區間</option>
						<option value="1 1000">NT$1-NT$1,000</option>
						<option value="1001 5000">NT$1,001-NT$5,000</option>
						<option value="5001 10000">NT$5,001-NT$10,000</option>
						<option value="10001 15000">NT$10,001-NT$15,000</option>
						<option value="15001 20000">NT$15,001-NT$20,000</option>
						<option value="20000">NT$20,000以上</option>
					</select>
				<p></p>
				<br>
				<!-- ul結束-->
				<input class="btn btn-primary" type="submit" value="查詢"
					style="width: 100%">
				<p>
					<br>
					<!--reset -->
					<input class="btn btn-warning" type="reset" value="重設條件">
			</FORM>
		</div>



		<div class="col-md-7">

			<div class="row">
				<!-- BEGIN PRODUCTS -->
				<c:forEach var="prdVO" items="${list}">

					<div class="col-md-4 col-sm-6" id="eachProduct">
						<span class="sc-product-item thumbnail">

							<form action="shop.do" method="POST">
								<input type="hidden" name="action" value="getOne_Product">
								<input name="prd_no" value="${prdVO.prd_no}" type="hidden" /> <input
									type="hidden" name="requestURL"
									value="<%=request.getServletPath()%>"> <a
									href="javascript:;" onclick="parentNode.submit();"> <img
									data-name="product_image"
									src="<%=request.getContextPath()%>/front/tool/showimage.do?getImg=by_prd_no&prd_no=${prdVO.prd_no}">
								</a>
							</form>
							<div class="caption">
								<form action="shop.do" method="POST">
									<h4 data-name="prd_name" class="text-center">${prdVO.prd_name}</h4>

									<%--  <p data-name="product_desc">${prdVO.prd_desc}</p> --%>
									<div>
										<strong class="price pull-left text-danger">$${prdVO.prd_price}</strong>
										<input type="hidden" name="action" value="addToCart">
										<input type="hidden" name="slr_no" value="${SlrVO.slr_no}">
										<input type="hidden" name="requestURL"
											value="<%=request.getServletPath()%>"> <input
											name="prd_price" value="${prdVO.prd_price}" type="hidden" />
										<input name="prd_no" value="${prdVO.prd_no}" type="hidden" />
										<button
											class="sc-add-to-cart btn btn-primary btn-sm pull-right">加入購物車</button>
										<%-- <input name="product_id" value="${prdVO.prd_no}" type="hidden" /> --%>
									</div>
								</form>
								<div class="clearfix"></div>
							</div>

						</span>
					</div>

				</c:forEach>
				<!-- END PRODUCTS -->
			</div>



		</div>

		<aside class="col-md-2">

			<!-- Cart submit form -->
			<form action="results.php" method="POST">
				<!-- SmartCart element -->
				<div id="smartcart"></div>
			</form>

		</aside>
	</div>





	<!-- Include jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"
		type="text/javascript"></script>
	<!-- Include SmartCart -->
	<script
		src="<%=request.getContextPath()%>/front/shopping/js/jquery.smartCart.js"
		type="text/javascript"></script>
	<!-- Initialize -->
	<script type="text/javascript">
		$(document).ready(function() {
			// Initialize Smart Cart    	
			$('#smartcart').smartCart();
		});
	</script>


</body>

</html>