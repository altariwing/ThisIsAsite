<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.house.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
	HouseService houseSvc = new HouseService();
	List<HouseVO> list = houseSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>�Ҧ��Ыθ�� - listAllHouse</title>

<style>.

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
	width: 800px;
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
				<h3>�Ҧ��Ыθ��</h3>
				<h4>
					<a
						href="<%=request.getContextPath()%>/house/back/house_select_page.jsp"><img
						src="<%=request.getContextPath()%>/house/imgs/Houselogo1.png"
						width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

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



		<%@ include file="/back/house/page1.file"%>

		<c:forEach var="houseVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${houseVO.house_no}</td>
				<td>${houseVO.re_no}</td>
				<td>${houseVO.house_serial_number}</td>
				<td>${houseVO.title}</td>
				<td>${houseVO.location}</td>
				<td>${houseVO.house_type}</td>
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
				<td><fmt:formatDate value="${houseVO.insert_time}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${houseVO.final_update_time}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
							type="hidden" name="action" value="delete"></td>
				
				</FORM>

				</tr>
		</c:forEach>
	</table>
	<%@ include file="/back/house/page2.file"%>
</body>
</html>