<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />

		<h2>Product Information</h2>

		<table class="table table-striped" style="width: 600px;">
			<tr>
				<th>Name</th>
				<td><b><c:out value="${product.name}" /></b></td>
			</tr>
			<tr>
				<th>Short Description</th>
				<td><c:out value="${product.shortDescription}" /></td>
			</tr>
			<tr>
				<th>Bar code</th>
				<td><c:out value="${product.barcode}" /></td>
			</tr>
			<tr>
				<th>Color</th>
				<td><c:out value="${product.color}" /></td>
			</tr>
			<tr>
				<th>Weight</th>
				<td><c:out value="${product.weight}" /></td>
			</tr>
			<tr>
				<th>Length</th>
				<td><c:out value="${product.length}" /></td>
			</tr>
			<tr>
				<th>Height</th>
				<td><c:out value="${product.height}" /></td>
			</tr>
			<tr>
				<th>Width</th>
				<td><c:out value="${product.width}" /></td>
			</tr>
			<tr>
				<th>Depth</th>
				<td><c:out value="${product.depth}" /></td>
			</tr>
			<tr>
				<th>Material</th>
				<td><c:out value="${product.material}" /></td>
			</tr>
			<tr>
				<th>Key feature</th>
				<td><c:out value="${product.keyFeatures}" /></td>
			</tr>
			<tr>
				<td><spring:url value="{productId}/edit.html" var="editUrl">
						<spring:param name="productId" value="${product.id}" />
					</spring:url> <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit
						Product</a></td>
				<td><spring:url value="{productId}/pets/new.html" var="addImageUrl">
						<spring:param name="productId" value="${product.id}" />
					</spring:url> <a href="${fn:escapeXml(addImageUrl)}" class="btn btn-success">Add
						New Image</a></td>
				<td><spring:url value="{productId}/piece/new.html" var="addPieceUrl">
						<spring:param name="productId" value="${product.id}" />
					</spring:url> <a href="${fn:escapeXml(addPieceUrl)}" class="btn btn-success">Add
						New Piece</a></td>
			</tr>
		</table>

		<h2>Images</h2>

		<%--     <c:forEach var="file" items="${product.files}"> --%>
		<!--         <table class="table" style="width:600px;"> -->
		<!--             <tr> -->
		<!--                 <td valign="top" style="width: 120px;"> -->
		<!--                     <dl class="dl-horizontal"> -->
		<!--                         <dt>Name</dt> -->
		<%--                         <dd><c:out value="${file.name}"/></dd> --%>
		<!--                         <dt>Info</dt> -->
		<%--                         <dd><c:out value="${file.data}"/></dd> --%>
		<!--                     </dl> -->
		<!--                 </td> -->
		<!--                 <td valign="top"> -->
		<!--                     <table class="table-condensed"> -->
		<!--                         <thead> -->
		<!--                         <tr> -->
		<!--                             <th>Visit Date</th> -->
		<!--                             <th>Description</th> -->
		<!--                         </tr> -->
		<!--                         </thead> -->
		<%--                         <c:forEach var="visit" items="${pet.visits}"> --%>
		<!--                             <tr> -->
		<%--                                 <td><joda:format value="${visit.date}" pattern="yyyy-MM-dd"/></td> --%>
		<%--                                 <td><c:out value="${visit.description}"/></td> --%>
		<!--                             </tr> -->
		<%--                         </c:forEach> --%>
		<!--                         <tr> -->
		<!--                             <td>  -->
		<%--                             	<spring:url value="/owners/{ownerId}/pets/{petId}/edit" var="petUrl"> --%>
		<%-- 			                        <spring:param name="ownerId" value="${owner.id}"/> --%>
		<%-- 			                        <spring:param name="petId" value="${pet.id}"/> --%>
		<%-- 			                    </spring:url> --%>
		<%-- 			                    <a href="${fn:escapeXml(petUrl)}">Edit Pet</a> --%>
		<!-- 			                </td> -->
		<!--                             <td> -->
		<%-- 			                    <spring:url value="/owners/{ownerId}/pets/{petId}/visits/new" var="visitUrl"> --%>
		<%-- 			                        <spring:param name="ownerId" value="${owner.id}"/> --%>
		<%-- 			                        <spring:param name="petId" value="${pet.id}"/> --%>
		<%-- 			                    </spring:url> --%>
		<%-- 			                    <a href="${fn:escapeXml(visitUrl)}">Add Visit</a> --%>
		<!--                             </td> -->
		<!--                        	</tr> -->
		<!--                     </table> -->
		<!--                 </td> -->
		<!--             </tr> -->
		<!--         </table> -->
		<%--     </c:forEach> --%>

		<jsp:include page="../fragments/footer.jsp" />

	</div>

</body>

</html>
