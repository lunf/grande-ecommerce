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
			<c:when test="${material['new']}">
				<c:set var="method" value="post" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put" />
			</c:otherwise>
		</c:choose>
		<h2>
			<c:if test="${material['new']}">New </c:if>
			Material
		</h2>

		<form:form modelAttribute="material" method="${method }"
			class="form-horizontal" id="add-owner-form">
			<petclinic:inputField label="Name" name="name"></petclinic:inputField>
			<petclinic:inputField label="Descriptions" name="materialDescription"></petclinic:inputField>
			<div class="form-actions">
				<c:choose>
					<c:when test="${material['new']}">
						<button type="submit">Add Material</button>
					</c:when>
					<c:otherwise>
						<button type="submit">Update Material</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form:form>
		<h2>Materials</h2>
		<c:if test="${!empty materials }">
			<datatables:table id="materials" data="${materials}" cdn="true"
				row="material" theme="bootstrap2" cssClass="table table-striped"
				paginate="false" info="false">
				<datatables:column title="Name">
					<c:out value="${material.name}"></c:out>
				</datatables:column>
				<datatables:column title="Description">
					<c:out value="${material.materialDescription}"></c:out>
				</datatables:column>
				<datatables:column cssStyle="width: 80px;">
					<spring:url value="/material/{materialId}/edit.html"
						var="editMaterialUrl">
						<spring:param name="materialId" value="${material.id}" />
					</spring:url>
					<a href="${fn:escapeXml(editMaterialUrl)}"><img
						alt="Edit Catagory" src="${edit}"
						style="width: 30px; height: 30px;" title="Edit Material" /></a>
					<spring:url value="/material/{materialId}/delete.html"
						var="deleteMaterialUrl">
						<spring:param name="materialId" value="${material.id}" />
					</spring:url>
					<a href="${fn:escapeXml(deleteMaterialUrl)}"><img
						alt="Edit Catagory" src="${delete}"
						style="width: 30px; height: 30px;" title="Delete Material" /></a>
				</datatables:column>
			</datatables:table>
		</c:if>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>