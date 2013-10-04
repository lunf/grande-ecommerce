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
		<h2>Create New Catagory</h2>

		<form:form modelAttribute="catagory" method="post"
			class="form-horizontal" id="add-owner-form">
			<petclinic:inputField label="Catagory" name="name"></petclinic:inputField>
			<petclinic:inputField label="Descriptions" name="catagoryDescription"></petclinic:inputField>
			<div class="form-actions">
				<button type="submit">Add Catagory</button>
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
			</datatables:table>
		</c:if>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>