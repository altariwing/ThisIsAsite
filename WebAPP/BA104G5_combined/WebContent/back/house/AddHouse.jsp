<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.house.model.*"%>

<%
	HouseVO houseVO = (HouseVO) request.getAttribute("houseVO"); //EmpServlet.java (Concroller), �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>


<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�Ыθ�ƭק� - update_emp_input.jsp</title>

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
	width: 450px;
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

.img_of_td {
	height: 200px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�s�W�Ыθ��~~</h3>
				<h4>
					<a
						href="<%=request.getContextPath()%>/house/back/house_select_page.jsp"><img
						src="<%=request.getContextPath()%>/house/imgs/Houselogo1.png"
						width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<jsp:useBean id="houseSvc" scope="page"
		class="com.house.model.HouseService" />
	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/house/houseServlet.do"
		name="form1" enctype="multipart/form-data">
		<table>
			<tr>
				<td>�Ыνs��:<font color=red><b>*</b></font></td>
				<td><input type="hidden" name="house_no" size="45"
					value="${houseVO.house_no}" />${houseVO.house_no}</td>
			</tr>
			<tr>
				<td>�ЫΩ���:</td>
				<td><input type="TEXT" name="re_no" size="45"
					value="${houseVO.re_no}" /></td>
			</tr>
			<tr>
				<td>���ݧǸ�:</td>
				<td><input type="TEXT" name="house_serial_number" size="45"
					value="${houseVO.house_serial_number}" /></td>
			</tr>
			<tr>
				<td>���D:</td>
				<td><input type="text" name="title" size="45"
					value="${houseVO.title}"></td>
			</tr>
			<tr>
				<td>��m:</td>
				<td><input type="text" name="location" size="45"
					value="${houseVO.location}" /></td>
			</tr>
			<tr>
				<td>�Ы�����:</td>
				<td><input type="text" name="house_type" size="45"
					value="${houseVO.house_type}" /></td>
			</tr>
			<tr>
				<td>����:</td>
				<td><input type="TEXT" name="price" size="45"
					value="${houseVO.price}" /></td>
			</tr>
			<tr>
				<td>�`�W��:</td>
				<td><input type="TEXT" name="total_pings" size="45"
					value="${houseVO.total_pings}" /></td>
			</tr>
			<tr>
				<td>�D�ت��W��:</td>
				<td><input type="TEXT" name="main_pings" size="45"
					value="${houseVO.main_pings}" /></td>
			</tr>
			<tr>
				<td>�@���ت��W��:</td>
				<td><input type="TEXT" name="amenity_pings" size="45"
					value="${houseVO.amenity_pings}" /></td>
			</tr>
			<tr>
				<td>���ݫت��W��:</td>
				<td><input type="TEXT" name="accessory_pings" size="45"
					value="${houseVO.accessory_pings}" /></td>
			</tr>
			<tr>
				<td>�Ӽh:</td>
				<td><input type="TEXT" name="floor" size="45"
					value="${houseVO.floor}" /></td>
			</tr>
			<tr>
				<td>����:</td>
				<td><input type="TEXT" name="age" size="45"
					value="${houseVO.age}" /></td>
			</tr>
			<tr>
				<td>�槽:</td>
				<td><input type="TEXT" name="pattern" size="45"
					value="${houseVO.pattern}" /></td>
			</tr>
			<tr>
				<td>�¦V:</td>
				<td><input type="TEXT" name="orientation" size="45"
					value="${houseVO.orientation}" /></td>
			</tr>
			<tr>
				<td>�ا�:</td>
				<td><input type="TEXT" name="building_materials" size="45"
					value="${houseVO.building_materials}" /></td>
			</tr>
			<tr>
				<td>����:</td>
				<td><input type="TEXT" name="parking_space" size="45"
					value="${houseVO.parking_space}" /></td>
			</tr>
			<tr>
				<td>�g�a���ݤ���:</td>
				<td><input type="TEXT" name="classification_of_land" size="45"
					value="${houseVO.classification_of_land}" /></td>
			</tr>
			<tr>
				<td>�g�a�W��:</td>
				<td><input type="TEXT" name="land_pings" size="45"
					value="${houseVO.land_pings}" /></td>
			</tr>
			<tr>
				<td>�ЫΥD�Ϥ�:</td>
				<td><img id="blah" class="img_of_td"
					src="<%=request.getContextPath()%>/house/ImageReader/${houseVO.house_no}">
					<input id="imgInp" type="file" name="main_img" size="45" /></td>
			</tr>

			<tr>
				<td>��l�Ӷ�:</td>
				<td><textarea name="data_info" Cols="47" Rows="5" Wrap="off">${houseVO.data_info}</textarea></td>
			</tr>

			<tr>
				<td>�g��:</td>
				<td><input type="TEXT" name="lat" size="45"
					value="${houseVO.lat}" /></td>
			</tr>
			<tr>
				<td>�n��:</td>
				<td><input type="TEXT" name="lng" size="45"
					value="${houseVO.lng}" /></td>
			</tr>
			<tr>
				<td>�W�[���A:<font color=red><b>*</b></font></td>
				<td><select size="1" name="house_states">
						<option value="selling"
							${('selling'==houseVO.house_states)?'selected':'' }>�W�[</option>
						<option value="not_sold"
							${('not_sold'== houseVO.house_states)?'selected':'' }>�U�[</option>
				</select></td>
			</tr>





		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="hidden" name="house_no" value="${houseVO.house_no}"> <input
			type="submit" value="�e�X�ק�">
	</FORM>
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/build/jquery.datetimepicker.full.min.js"></script>
<script>
	$('#imgInp').change(function() {
		readURL(this);
	});
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>



</html>