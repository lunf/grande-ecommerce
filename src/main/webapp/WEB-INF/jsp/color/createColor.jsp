<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<html lang="en">
<spring:url value="/resources/images/TextEdit.png" var="edit" />
<spring:url value="/resources/images/file_delete.png" var="delete" />
<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<c:choose>
			<c:when test="${color['new']}">
				<c:set var="method" value="post" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put" />
			</c:otherwise>
		</c:choose>
		<h2>
			<c:if test="${color['new']}">New </c:if>
			Colors
		</h2>

		<%-- 		<spring:url value="/color/new.html" var="formUrl" /> --%>
		<form:form modelAttribute="color" method="${method }"
			class="form-horizontal" id="add-owner-form">
			<petclinic:inputField label="Name" name="name"></petclinic:inputField>
			<petclinic:inputField label="Code Color" name="codeColor"></petclinic:inputField>
			<petclinic:inputField label="Descriptions" name="colorDescription"></petclinic:inputField>
			<div class="form-actions">
				<c:choose>
					<c:when test="${color['new']}">
						<button type="submit">Add Colors</button>
					</c:when>
					<c:otherwise>
						<button type="submit">Update Colors</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form:form>
		<h2>Colors</h2>
		<c:if test="${!empty colors }">
			<datatables:table id="colors" data="${colors}" cdn="true" row="color"
				theme="bootstrap2" cssClass="table table-striped" paginate="false"
				info="false">
				<datatables:column title="Name">
					<c:out value="${color.name}"></c:out>
				</datatables:column>
				<datatables:column title="Code">
					<c:out value="${color.codeColor}" />
				</datatables:column>
				<datatables:column title="Description">
					<c:out value="${color.colorDescription}"></c:out>
				</datatables:column>
				<datatables:column cssStyle="width: 80px;">
					<spring:url value="/color/{colorId}/edit.html" var="editColorUrl">
						<spring:param name="colorId" value="${color.id}" />
					</spring:url>
					<a href="${fn:escapeXml(editColorUrl)}"><img alt="Edit Color"
						src="${edit}" style="width: 30px; height: 30px;"
						title="Edit Color" /></a>
					<spring:url value="/color/{colorId}/delete.html"
						var="deleteColorUrl">
						<spring:param name="colorId" value="${color.id}" />
					</spring:url>
					<a href="${fn:escapeXml(deleteColorUrl)}"><img
						alt="Edit Catagory" src="${delete}"
						style="width: 30px; height: 30px;" title="Delete Color" /></a>
				</datatables:column>
			</datatables:table>
		</c:if>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>