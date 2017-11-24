<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.employee.model.*"%>

<%
  EmployeeVO empVO = (EmployeeVO) request.getAttribute("empVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>���u��Ʒs�W - addEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
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

<style>
  table {
	
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>

<!-- ���include -->
<jsp:include page="/back/backend/backend_page.jsp" flush="true" />
<!-- ���include -->

<body bgcolor='white'>
<!-- �@�w�n�d��<div> ================================================================================== -->
<div class="col-xs-12 col-sm-10 maincontext">
	<!-- �@�w�n�d��<div> ================================================================================== -->
	<!-- �H�U�O�A�i�H�񪺤��e ================================================================================== -->

<h3>���u��Ʒs�W - addEmp.jsp</h3>
<h4><a href="<%=request.getContextPath()%>/back/employee/select_page.jsp"><img src="<%=request.getContextPath()%>/back/employee/images/back_btn.jpg" width="auto" height="100" border="0">�^�޲z���u</a></h4>
	

<h3>�s�W���u�b��:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message.value}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="emp.do" name="form1">
<table>
	<tr>
		<td>���u�m�W:</td>
		<td><input type="text" name="emp_name" size="45" 
			 value="${param.emp_name}"/></td><td>${errorMsgs.emp_name}</td>
	</tr>
	<tr>
		<td>���u�b��:</td>
		<td><input type="email" name="emp_id" size="45"
			 value="${param.emp_id}"/></td><td>${errorMsgs.emp_id}</td>
	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" id="insertBtn" value="�e�X�s�W" onclick="submitFunction()"></FORM><h3 id="dataID" style="color:red"></h3>
<script>
function submitFunction() {
	
    document.getElementById("dataID").innerHTML = "��Ʒs�W��";
}
</script>
	<!-- �H�W�O�A�i�H�񪺤��e =========================================================================== -->

	<!-- �@�w�n�d��</div> ============================================================================ -->
</div>
<!-- �@�w�n�d��</div> ================================================================================ -->
</body>

</html>