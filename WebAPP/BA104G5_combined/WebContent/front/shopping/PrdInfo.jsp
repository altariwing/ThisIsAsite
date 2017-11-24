<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.prdimg.model.*"%>
<%@ page import=" com.product_order.model.*"%>
<jsp:useBean id="slrService" scope="session" class="com.slr.model.SlrService" />
<jsp:useBean id="pdoService" scope="page" class="com.product_order.model.Product_orderService" />
<%
	PrdVO prdVO = (PrdVO) request.getAttribute("prdVO");
	List<PrdImgVO> list = (List<PrdImgVO>) request.getAttribute("list");
%>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/houselogo1.png" />
<title>For House</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
<script src="https://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/tools/bootstrap-3.3.7-dist/css/bootstrap.min.css">


<!-- Include SmartCart CSS -->
<link href="<%=request.getContextPath()%>/front/shopping/css/smart_cart.min.css" rel="stylesheet" type="text/css" />
<!-- Include jquery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/tools/ratestar/jquery.rateyo.js"></script>

<style>
h4 {
	position: relative;
	line-height: 1.4em;
	/* 1 times the line-height to show 1 lines */
	height: 1.4em;
	overflow: hidden;
}

.mySlides {display:none}
.demo {cursor:pointer} 

.responsive-flamingo {
	width: 16%;
	height: auto;
}

section {
    display: table;
}

#mainImg {
	height: 500px;
	width: 500px;
	display: table-cell;
    vertical-align: middle;
}

#mainImg img{
	max-height: 500px;
	max-width: 500px;
}

#prdInfoDiv {
	margin-top: 130px;
	position: absolute;
	left: 25%;
}

//god will give me five star
.star-ratings {
  unicode-bidi: bidi-override;
  color: #c5c5c5;
  font-size: 50px;
  height: 50px;
  width: 250px;
  margin: 1em auto;
  position: relative;
  padding: 0;
  
  .star-ratings-top {
    color: gold;
    padding: 0;
    position: absolute;
    z-index: 1;
    display:block;
    left: 0px;
    overflow: hidden;
  }
  .star-ratings-bottom { z-index: 0; }
}
</style>
</head>



<body>

<nav class="navbar navbar-fixed-top">
	<jsp:include page="/front/navbar.jsp" />
</nav>
 
<!-- one----------------------------------------------------------------------------------------------------------- -->
<!-- one----------------------------------------------------------------------------------------------------------- -->
<!-- one----------------------------------------------------------------------------------------------------------- -->
<div class="row" id="prdInfoDiv">

	<!-- 主區塊左側 -->
	<div class="col-md-4 row">
		<div class="row">
			<!-- 商品圖大區塊  -->
			<section>
			<div id="mainImg">
				<c:forEach var="PrdImgVO" items="${list}">

					 <img class="card-img-top mySlides img-responsive"
						src="<%=request.getContextPath()%>/front/tool/showimage.do?getImg=by_img_no&img_no=${PrdImgVO.img_no}"
						alt="Responsive image" id="">
					
				</c:forEach>
			</div>
			</section>
			<!-- 商品圖大區塊結束  -->
		</div>
		<div class="row">
			<!-- 商品圖小區塊  -->
			<div class="w3-row-padding w3-section">
				<div class="item w3-col s4">

					<%int currentimg = 0; %>
					<c:forEach var="PrdImgVO" items="${list}">

						&nbsp
						<img data-name="product_image" class="responsive-flamingo demo w3-opacity w3-hover-opacity-off"
							src="<%=request.getContextPath()%>/front/tool/showimage.do?getImg=by_img_no&img_no=${PrdImgVO.img_no}"
							alt="Product image" onmouseover="currentDiv(<%=++currentimg %>)">
						

					</c:forEach>
				</div>
			</div>
			<!-- 商品圖小區塊 結束  -->
		</div>
	</div>
	<!-- 左側區塊結束 -->
	<!-- 主區塊右側 -->
	<div class="col-md-4">
		<div class="">
			<div class="row">
			<!-- 回上一頁 -->
			<div class="col-md-12"><input type ="button" class="btn btn-success" onclick="history.back()" value="回上一頁" /></div>
				
				<div class="panel panel-default">
				<!-- 商家 -->
				<div class="col-md-12"><h4>商家資訊: ${slrService.findByNo(PrdVO.slr_no).slr_name}</h4></div>
				${PrdVO.slr_no}
				
				
				
					
				<FORM METHOD="post"	ACTION="shop.do">
					<input type="hidden" name="action" value="listPrd_ByCompositeQuery">
					<input type="hidden" name="slr_no" value="${PrdVO.slr_no}">
					<a href="javascript:;" onclick="parentNode.submit();"><h4>查看賣家商品</h4></a>
				</FORM>	
				
				


				
				
				
				<c:if test= "${'0.0' != pdoService.getSlrAvgRate(PrdVO.slr_no)}" >
				<div class="star-ratings">
				<div class="star-ratings-top"><span>★</span><span>★</span><span>★</span><span>★</span><span>★</span></div>
				<div class="star-ratings-bottom"><span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span></div>
				</div>
				
				<script>
				$(document).ready(function(){
				// change this to adjust the rating display
				var bvTireRating = ${pdoService.getSlrAvgRate(PrdVO.slr_no)};
				// multiply by 20 to get percentage
				var starRating = bvTireRating*20;
				// set the width of the stars
				$('.star-ratings-top').width(starRating+'%'); 
				});
				</script>
				<style>
				.star-ratings {
  unicode-bidi: bidi-override;
  color: #c5c5c5;
  font-size: 50px;
  height: 50px;
  width: 250px;
  margin: 1em auto;
  position: relative;
  padding: 0;
  
  .star-ratings-top {
    color: gold;
    padding: 0;
    position: absolute;
    z-index: 1;
    display:block;
    left: 0px;
    overflow: hidden;
  }
  .star-ratings-bottom { z-index: 0; }
}
				</style>
				評價分數：${pdoService.getSlrAvgRate(PrdVO.slr_no)}
				
				</c:if>
				</div>
			</div>

			<!-- 標題 -->
			<div class="">
				<h2 data-name="prd_name">${PrdVO.prd_name}</h2>
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

			<div>
				<div class="">
					<h4 class="text-info">庫存: ${PrdVO.prd_stock}</h4>
				</div>
				<div class="" style="width:250px">
					數量: <select class="selectpicker" name="prd_stock">


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

					<strong class="price pull-left text-danger">${prdVO.prd_price}</strong>
					<input type="hidden" name="action" value="getOne_Product">
					<input type="hidden" name="slr_name" value="${SlrVO.slr_name}">
					<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
					<input name="prd_price" value="${PrdVO.prd_price}" type="hidden" />
					<input name="prd_no" value="${PrdVO.prd_no}" type="hidden" />
					<input name="prd_name" value="${PrdVO.prd_name}" type="hidden" />
	<%-- 						<input name="product_id" value="${prdVO.prd_no}" type="hidden" /> --%>
					<button class="sc-add-to-cart btn btn-primary btn-sm pull-right">加入購物車</button>
				</div>
			</div>
		</div>
	</div>
	
	<aside class="col-md-3">
     	<!-- Cart submit form -->
	    <form action="results.php" method="POST"> 
	         <!-- SmartCart element -->
	         <div id="smartcart"></div>
	    </form>
	</aside>
  		
	<!-- 主區塊右側結束 -->
</div>
<!-- 主區塊第一列結束 -->
<div></div>
<!-- two----------------------------------------------------------------------------------------------------------- -->
<!-- two----------------------------------------------------------------------------------------------------------- -->
<!-- two----------------------------------------------------------------------------------------------------------- -->

<div class="row border border-primary"></div>


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


    <!-- Include SmartCart -->
    <script src="<%=request.getContextPath()%>/front/shopping/js/jquery.smartCart.js" type="text/javascript"></script>
    <!-- Initialize -->
    <script type="text/javascript">
        $(document).ready(function(){
            // Initialize Smart Cart    	
            $('#smartcart').smartCart();
		});
    </script>

</body>

</html>