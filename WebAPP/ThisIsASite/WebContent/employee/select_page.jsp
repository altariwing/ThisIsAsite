<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
<title>IBM Emp: Home</title>

<style>
table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

</head>
<body bgcolor='white'>
	<h3>員工資料查詢:</h3>

	<ul>
		<li><a href="listAllEmp.jsp"> List</a> all Emps
			<h4>(post方法).</h4> <br> <br> <br></li>
	</ul>

	<h3>員工管理</h3>
	<ul>
		<li><a href='addEmp.jsp'>Add</a> a new Emp.</li>
	</ul>


</body>
</html>