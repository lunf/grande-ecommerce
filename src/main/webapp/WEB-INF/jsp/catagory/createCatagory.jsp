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
			<c:when test="${catagory['new']}">
				<c:set var="method" value="post" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put" />
			</c:otherwise>
		</c:choose>
		<h2>
			<c:if test="${catagory['new']}">New </c:if>
			Catagory
		</h2>

		<form:form modelAttribute="catagory" method="${method }"
			class="form-horizontal" id="add-owner-form">
			<petclinic:inputField label="Catagory" name="name"></petclinic:inputField>
			<petclinic:inputField label="Descriptions" name="catagoryDescription"></petclinic:inputField>
			<div class="form-actions">
				<c:choose>
					<c:when test="${catagory['new']}">
						<button type="submit">Add Catagory</button>
					</c:when>
					<c:otherwise>
						<button type="submit">Update Catagory</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form:form>
		<h2>Catagory</h2>
		<c:if test="${!empty catagories }">
			<datatables:table id="catagories" data="${catagories}" cdn="true"
				row="catagory" theme="bootstrap2" cssClass="table table-striped"
				paginate="false" info="false">
				<datatables:column title="Name">
					<c:out value="${catagory.name}"></c:out>
				</datatables:column>
				<datatables:column title="Description">
					<c:out value="${catagory.catagoryDescription}"></c:out>
				</datatables:column>
				<datatables:column cssStyle="width: 80px;">
					<spring:url value="/catagory/{catagoryId}/edit.html"
						var="editCatagoryUrl">
						<spring:param name="catagoryId" value="${catagory.id}" />
					</spring:url>
					<a href="${fn:escapeXml(editCatagoryUrl)}"><img
						alt="Edit Catagory" src="${edit}"
						style="width: 30px; height: 30px;" title="Edit Catagory" /></a>
					<spring:url value="/catagory/{catagoryId}/delete.html"
						var="deleteCatagoryUrl">
						<spring:param name="catagoryId" value="${catagory.id}" />
					</spring:url>
					<a href="${fn:escapeXml(deleteCatagoryUrl)}"><img
						alt="Edit Catagory" src="${delete}"
						style="width: 30px; height: 30px;" title="Delete Catagory" /></a>
				</datatables:column>
			</datatables:table>
		</c:if>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>