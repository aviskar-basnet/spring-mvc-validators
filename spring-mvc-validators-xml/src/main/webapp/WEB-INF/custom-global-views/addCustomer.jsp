<!DOCTYPE html>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Customer Form</title>
<style type="text/css">
.errorblock {
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
	<f:form method="POST" modelAttribute="customer" action="">
		<f:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Customer Name :</td>
				<td><f:input path="name" /></td>
				<td><f:errors path="name" cssClass="errorblock" /></td>
			</tr>
			<tr>
				<td>Customer Age :</td>
				<td><f:input path="age" /></td>
				<td><f:errors path="age" cssClass="errorblock" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>
