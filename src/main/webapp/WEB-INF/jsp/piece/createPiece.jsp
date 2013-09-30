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
			<c:when test="${piece['new']}">
				<c:set var="method" value="post" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put" />
			</c:otherwise>
		</c:choose>

		<h2>
			<c:if test="${piece['new']}">New </c:if>
			Piece
		</h2>
		<form:form modelAttribute="piece" method="${method}"
			class="form-horizontal" id="add-product-form">
			<table>
				<tr>
					<td style="padding-right: 20px"><petclinic:inputField
							label="Name" name="name" /> <petclinic:inputField
							label="Short Description" name="shortDescription" /> <petclinic:inputField
							label="Long Description" name="longDescription" /> <petclinic:inputField
							label="Weight" name="weight" /> <petclinic:inputField
							label="Length" name="length" /> <petclinic:inputField
							label="Height" name="height" /> 
						<petclinic:selectField label="Color" name="color" size="1" names="${colors }"></petclinic:selectField>
					</td>
					<td style="padding: 20px;"><petclinic:inputField label="Width"
							name="width" /> <petclinic:inputField label="Depth" name="depth" />
						<petclinic:inputField label="Price" name="price" /> <petclinic:inputField
							label="Key features" name="keyFeatures" /> <petclinic:inputField
							label="Bar code" name="barcode" /> <petclinic:inputField
							label="Unique Code" name="uniqueCode" />
							<petclinic:selectField label="Material" name="material" size="1" names="${materials }"></petclinic:selectField> </td>
				</tr>
			</table>
			<div class="form-actions">
				<c:choose>
					<c:when test="${piece['new']}">
						<button type="submit">Add Piece</button>
					</c:when>
					<c:otherwise>
						<button type="submit">Update Piece</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form:form>
	</div>
	<jsp:include page="../fragments/footer.jsp" />
</body>

</html>
