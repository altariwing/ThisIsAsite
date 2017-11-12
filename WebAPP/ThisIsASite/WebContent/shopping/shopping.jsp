<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
 
%>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="shortcut icon" href="images/houselogo1.png" />
    <title>For House</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    

    <style type="text/css">
    body {
        font-family: Arial, Verdana, Helvetica, "LiHei Pro Medium", 微軟正黑體, sans-serif;
    }

    .imgbox {
        position: relative;
        z-index: -1;
        height: 20em;
        width: 20em;
    }

    .ina:hover {
        opacity: 0.85;
    }

    .imgbox img {
        position: relative;
        z-index: -10;
        max-height: 100%;
        box-shadow: 1px 1px 1px #bdbdbd;
    }

    .textbox {
        position: absolute;
        top: 0;
        z-index: 11;
        padding-top: 10em;
        width: 90%;
        height: 100%;
        text-align: center;
    }

    .textbackground {
        background-color: #ffd600;
        height: 3em;
        box-shadow: 1px 1px 1px grey;
        opacity: 0.8;
    }

    .textinline {
        /* height: 3em;*/
        position: relative;
        z-index: 5;
        opacity: 1;
        margin-top: -0.5em;
        line-height: 2;
    }

    .searchSRS {
        margin-top: 8em;
    }

    .furnitureAd {
        margin-top: 8em;
    }

    .furnitureAd>img {
        max-height: 100%;
        max-width: 100%;
    }

    .news {
        margin-top: 8em;
    }

    .redNote {
        position: relative;
        z-index: 3;
        height: 2em;
        width: 6em;
        margin-left: 9.7em;
        margin-right: 10em;
        background-color: red;
    }

    .newss {
        position: relative;
        z-index: 1;
        margin-top: -2.5em;
        background-color: #fff9c4;
    }

    .newss h3 {
        padding-top: 1.5em;
    }

    ul {
        list-style-type: none;
    }

    .textfix {
        margin-left: -15px;
    }
    .textfix ul{
        padding-bottom: 2em;
    }
    .mobileBar {
        margin-top: 8em;
    }
    .mobileBar>img {
        max-height: 100%;
        max-width: 100%;
    }
    .headerBar{
    	width: 95em;
    }
    
    #loginArea{
    	width: 130px;
    }

    footer {
        background-color: white;
        padding-top: 4em;
    }

    .copyri {
        margin-top: 3em;
    }
    
    .box-width{
        width:520px;
        margin-left: 50px;
    }
    .margin-top{
        margin-top: 20px;
    }
    .searchstate{
        margin-left: 50px;
    }
    #searchrequire{
        font-size: 18px;
    }
    #aggrement{
        color: #999999;
    }

    #fancy-checkbox-info {
    display: none;
    }
    
    <!-- 燈箱內容 開始-->
    .modal{
        text-align: center;
        padding: 0!important;
    }
    .modal:before{
        content: '';
        display: inline-block;
        height: 100%;
        vertical-align: middle;
        margin-right: 42em;
    }
    .modal-dialog{
        display: inline-block;
        text-align: left;
        vertical-align: middle;
    }
    .joinbtn{
    	margin: 30px;
    	width: 90%;
    }
    <!-- 燈箱內容 結束-->
    
    </style>
    <script>
        $(function(){
            $('[data-toggle="tooltipNews"]').tooltip(
                {title: "<div><a href='#'>房市新聞</a></div><div><a href='#'>促銷資訊</a></div><div><a href='#'>系統公告</a></div>",
                 html: true,
                 delay:{"show":100,"hide":1000
             }});
        });
    </script>
</head>

<body>
    <div class="container-fluid backgroundpng">
        <img class="row" src="images/fixed_bg.png">
    </div>
    
    <nav class="navbar navbar-fixed-top">
        <jsp:include page="navbar.jsp" />
    </nav>
    

</body>

</html>