<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de Registro</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="saveOrUpdateUser">
	<s:push value="user">
		<s:hidden name="id" />
		<s:textfield name="name" label="Nombre de Usuario" />
		<s:textfield name="identification" label="Identificacion de Usuario" />
		<s:textfield name="date" label="Fecha de Nacimiento" />
		<s:select name="state" list="{'Activo','Inactivo'}" headerKey=""
			headerValue="Select" label="Seleccione un estado" />

		<s:submit />
	</s:push>
</s:form>


<form action="report">

    <input type="submit" name="Reporte" value="Reporte" /> <br/>

</form>

<s:if test="userList.size() > 0">
	<div class="content">
	<table class="userTable" cellpadding="5px">
		<tr class="even">
			<th>Nombre</th>
			<th>Identificacion</th>
			<th>Fecha Nacimiento</th>
			<th>Estado</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="userList" status="userStatus">
			<tr
				class="<s:if test="#userStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="name" /></td>
				<td><s:property value="identification" /></td>
				<td><s:property value="date" /></td>
				<td><s:url id="editURL" action="editUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>