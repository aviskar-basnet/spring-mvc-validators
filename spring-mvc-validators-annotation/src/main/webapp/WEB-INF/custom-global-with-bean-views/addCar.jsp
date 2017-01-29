<!DOCTYPE html>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Car Form</title>
<style type="text/css">
.errorblock {
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
	<f:form method="POST" modelAttribute="car" action="">
		<f:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Brand Name Of Car :</td>
				<td><f:input path="brandName" /></td>
				<td><f:errors path="brandName" cssClass="errorblock" /></td>
			</tr>
			<tr>
				<td>No. Of Seat Of Car :</td>
				<td><f:input path="noOfSeat" /></td>
				<td><f:errors path="noOfSeat" cssClass="errorblock" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</f:form>
</body>
</html>
