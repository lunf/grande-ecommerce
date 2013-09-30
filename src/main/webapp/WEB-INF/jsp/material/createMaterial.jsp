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
		<h2>Create New Material</h2>

		<form:form modelAttribute="material" method="post"
			class="form-horizontal" id="add-owner-form">
			<petclinic:inputField label="Name" name="name"></petclinic:inputField>
			<petclinic:inputField label="Descriptions" name="materialDescription"></petclinic:inputField>
			<div class="form-actions">
				<button type="submit">Add Material</button>
			</div>
		</form:form>
		<h2>Materials</h2>

		<datatables:table id="materials" data="${materials}" cdn="true" row="material"
			theme="bootstrap2" cssClass="table table-striped" paginate="false"
			info="false">
			<datatables:column title="Name">
				<c:out value="${material.name}"></c:out>
			</datatables:column>
			<datatables:column title="Description">
				<c:out value="${material.materialDescription}"></c:out>
			</datatables:column>
		</datatables:table>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>