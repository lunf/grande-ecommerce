<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h2>Create File</h2>
		<table>
			<tr>
				<th>Extension</th>
				<td><input type="text" name="extension"></td>
			</tr>
			<tr>
				<th>Extension</th>
				<td><input type="text" name="contentType"></td>
			</tr>
			
		</table>
		 <input type="file"
			name="data"> <input type="submit" value="Add File">
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
