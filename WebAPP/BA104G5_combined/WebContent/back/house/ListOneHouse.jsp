<%@ page contentType="text/html; charset=Big5"%>
<%@ page import="com.house.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
	HouseVO houseVO = (HouseVO) request.getAttribute("houseVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>���u��� - listOneEmp.jsp</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
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
				<h3>�Ыθ�� ~ �浧</h3>
				<h4>
					<a
						href="<%=request.getContextPath()%>/house/back/house_select_page.jsp"><img
						src="<%=request.getContextPath()%>/house/imgs/Houselogo1.png"
						width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>�Ыνs��</th>
			<th>�������</th>
			<th>���ݧǸ�</th>
			<th>���D</th>
			<th>��m</th>
			<th>�Ы�����</th>
			<th>����</th>
			<th>�`�W��</th>
			<th>�D�ت��W��</th>
			<th>�@���ت��W��</th>
			<th>���ݫت��W��</th>
			<th>�Ӽh</th>
			<th>����</th>
			<th>�槽</th>
			<th>�¦V</th>
			<th>�ا�</th>
			<th>����</th>
			<th>�g�a���ݤ���</th>
			<th>�g�a�W��</th>
			<th>��l�Ӷ�</th>
			<th>�ЫΥD�Ϥ�</th>
			<th>�g��</th>
			<th>�n��</th>
			<th>�W�[���A</th>
			<th>�s�W�ɶ�</th>
			<th>�̫�ק�ɶ�</th>
			<th colspan=2>�s��</th>

		</tr>
		<tr>
			<td>${houseVO.house_no}</td>
			<td>${houseVO.re_no}</td>
			<td>${houseVO.house_serial_number}</td>
			<td>${houseVO.title}</td>
			<td>${houseVO.location}</td>
			<td>${houseVO.house_type}"</td>
			<td>${houseVO.price}</td>
			<td>${houseVO.total_pings}</td>
			<td>${houseVO.main_pings}</td>
			<td>${houseVO.amenity_pings}</td>
			<td>${houseVO.accessory_pings}</td>
			<td>${houseVO.floor}</td>
			<td>${houseVO.age}</td>
			<td>${houseVO.pattern}</td>
			<td>${houseVO.orientation}</td>
			<td>${houseVO.building_materials}</td>
			<td>${houseVO.parking_space}</td>
			<td>${houseVO.classification_of_land}</td>
			<td>${houseVO.land_pings}</td>
			<td>${houseVO.data_info}</td>
			<td><img class="img_of_td"
				src="<%=request.getContextPath()%>/house/ImageReader/${houseVO.house_no}"></td>
			<td>${houseVO.lat}</td>
			<td>${houseVO.lng}</td>
			<td>${houseVO.house_states}</td>
			<td>${houseVO.insert_time}</td>
			<td>${houseVO.final_update_time}</td>
			<td>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/house/houseServlet.do"
					style="margin-bottom: 0px;">
					<input type="submit" value="�ק�"> <input type="hidden"
						name="house_no" value="${houseVO.house_no}"> <input
						type="hidden" name="action" value="GetOndHouseInfoForUpdate">
				</FORM>
			</td>
			<td>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/house/houseServlet.do"
					style="margin-bottom: 0px;">
					<input type="submit" value="�R��"> <input type="hidden"
						name="house_no" value="${houseVO.house_no}"> <input
						type="hidden" name="action" value="delete">
				</FORM>
			</td>
		</tr>
	</table>

</body>
</html>