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
		<c:choose>
			<c:when test="${file['new']}">
				<c:set var="method" value="post" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put"></c:set>
			</c:otherwise>
		</c:choose>
		<h2>
			<c:if test="${file['new']}">New </c:if>
			File
		</h2>
		<form:form modelAttribute="Jmfile" method="${method}"
			class="form-horizontal" id="add-product-form"
			enctype="multipart/form-data">
			<table>
				<tr>
					<th>Extension</th>
					<td><input type="text" name="extension"></td>
				</tr>

			</table>
			<input type="file" name="file" id="file">
			<input type="submit" value="Add File">
		</form:form>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
