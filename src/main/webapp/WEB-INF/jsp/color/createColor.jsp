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

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<h2>Create New Color</h2>

		<%-- 		<spring:url value="/color/new.html" var="formUrl" /> --%>
		<form:form modelAttribute="color" method="post"
			class="form-horizontal" id="add-owner-form">
			<petclinic:inputField label="Name" name="name"></petclinic:inputField>
			<petclinic:inputField label="Code Color" name="codeColor"></petclinic:inputField>
			<petclinic:inputField label="Descriptions" name="colorDescription"></petclinic:inputField>
			<div class="form-actions">
				<button type="submit">Add Color</button>
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
			</datatables:table>
		</c:if>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>