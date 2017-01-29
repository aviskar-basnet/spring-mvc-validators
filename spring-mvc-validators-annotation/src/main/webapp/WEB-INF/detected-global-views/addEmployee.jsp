<!DOCTYPE html>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Employee Form</title>
<style type="text/css">
.errorblock {
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
	<f:form method="POST" modelAttribute="employee" action="">
		<f:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Employee Name :</td>
				<td><f:input path="name" /></td>
				<td><f:errors path="name" cssClass="errorblock" /></td>
			</tr>
			<tr>
				<td>Employee Working Hr. :</td>
				<td><f:input path="workingHr" /></td>
				<td><f:errors path="workingHr" cssClass="errorblock" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>
