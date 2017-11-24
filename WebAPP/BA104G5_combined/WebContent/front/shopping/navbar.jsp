<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mem.model.*"%>
<%
  MemVO memVO = (MemVO) session.getAttribute("memVO");
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/Houselogo1.png" />

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
    <script src="https://code.jquery.com/jquery.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">

    <style type="text/css">
    body {
        font-family: Arial, Verdana, Helvetica, "LiHei Pro Medium", 微軟正黑體, sans-serif;
    }
	
	#headerBar {
		height: 80px;
	}
    
    #left, #center, #right { 
	   display: inline-block;
	   
	   text-align:center;
	}
	#left {
		margin-left: 160px;
		padding-top: 55px;
		
	}
	#right { 
	  font-size: 15px;
	}
	
	#center { 
		font-size: 22px;
	}

    </style>

</head>

<body>





<nav class="navbar navbar-expand-lg navbar-light rounded" id="headerBar">
<div class="collapse navbar-collapse justify-content-md-center">
    <div class="col-xs-11 col-sm-2" id="left">
        <a class="navbar-brand" href="<%= request.getContextPath()%>/front/index.jsp"><img class="navshadow" src="<%=request.getContextPath()%>/images/For House logo.png" width="120px"></a>
    </div>
    <div class="col-xs-12 col-sm-7" id="center">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="#" data-toggle="tooltipNews" data-placement="bottom" style="color:#00ADEE">&nbsp&nbsp最新消息&nbsp</a></li>
            <li class="nav-item"><a class="nav-link" href="#" style="color:#00ADEE">&nbsp常見問題&nbsp</a></li>
            <li class="nav-item"><a class="nav-link" href="#" style="color:#00ADEE">&nbsp看房去&nbsp</a></li>
            <li class="nav-item"><a class="nav-link" href="#" style="color:#00ADEE">&nbsp找房仲&nbsp</a></li>
            <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/front/shopping/listAllPrd.jsp" style="color:#00ADEE">&nbsp安家商城&nbsp</a></li>
            <c:if test="${memVO==null}"> <!-- 判斷如果會員登入了就不顯示 "加入我們" -->
            	<li class="nav-item"><a class="nav-link" href="<%=request.getRequestURI()%>#joinUs" data-toggle="modal" style="color:#00ADEE">&nbsp加入我們</a></li>
            </c:if>
        </ul>
    </div>
    <div class="col-sm-3" id="right">
        <ul class="navbar-nav logina">
        <c:if test="${memVO==null}">
            <li class="nav-item"><a class="nav-link" href='<%=request.getContextPath()%>/front/register.jsp' style="color:#00ADEE"><span class="glyphicons glyphicons-edit"></span> 註冊</a></li>
            <li class="nav-item"><a class="nav-link" href='<%=request.getContextPath()%>/front/login.jsp' style="color:#00ADEE"><span class='glyphicons glyphicons-log-in'></span> 登入</a></li>
        </c:if>
        <c:if test="${memVO!=null}">
        	<li><a class="nav-link" href='<%= request.getContextPath()%>/front/member/memdata.jsp' style="color:#00ADEE"><span class='glyphicon glyphicon-user'>.<%= memVO.getMem_name()%></span></a></li>
        	
            <li><a class="nav-link" href='<%= request.getContextPath()%>/front/logout.do' style="color:#00ADEE"><span class='glyphicon glyphicon-log-out'></span>.登出</a></li>
        </c:if>
        </ul>
    </div>
</div>
</nav>
    
</body>
</html>