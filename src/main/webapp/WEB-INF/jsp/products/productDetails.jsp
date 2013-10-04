<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>

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
				<th>Catagory</th>
				<td><c:out value="${product.catagories}" /></td>
			</tr>
			<tr>
				<td><spring:url value="{productId}/edit.html" var="editUrl">
						<spring:param name="productId" value="${product.id}" />
					</spring:url> <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit
						Product</a></td>
				<td><spring:url value="{productId}/file/new.html"
						var="addImageUrl">
						<spring:param name="productId" value="${product.id}" />
					</spring:url> <a href="${fn:escapeXml(addImageUrl)}" class="btn btn-success">Add
						New Image</a></td>
				<td><spring:url value="{productId}/piece/new.html"
						var="addPieceUrl">
						<spring:param name="productId" value="${product.id}" />
					</spring:url> <a href="${fn:escapeXml(addPieceUrl)}" class="btn btn-success">Add
						New Piece</a></td>
			</tr>
		</table>

		<h2>Pieces</h2>
		<%-- 		<c:forEach var="piece" items="${product.pieces}"> --%>
		<!-- 			<table class="table" style="width: 600px;"> -->
		<!-- 				<tr> -->
		<!-- 					<td valign="top" style="width: 120px;"> -->
		<!-- 						<dl class="dl-horizontal"> -->
		<!-- 							<dt>Name</dt> -->
		<!-- 							<dd> -->
		<%-- 								<c:out value="${piece.name}" /> --%>
		<!-- 							</dd> -->
		<!-- 							<dt>Color</dt> -->
		<!-- 							<dd> -->
		<%-- 								<c:out value="${piece.color}" /> --%>
		<!-- 							</dd> -->
		<!-- 							<dt>Width</dt> -->
		<!-- 							<dd> -->
		<%-- 								<c:out value="${piece.width}" /> --%>
		<!-- 							</dd> -->
		<!-- 						</dl> -->
		<!-- 					</td> -->
		<!-- 				</tr> -->
		<!-- 			</table> -->
		<%-- 		</c:forEach> --%>
		<c:if test="${!empty product.pieces }">
			<datatables:table id="products" data="${product.pieces}" cdn="true"
				row="piece" theme="bootstrap2" cssClass="table table-striped"
				paginate="false" info="false" export="pdf">
				<datatables:column title="Name" cssStyle="width: 100px;"
					display="html">
					<spring:url value="/products/{productId}/piece/{pieceId}/edit.html"
						var="productUrl">
						<spring:param name="productId" value="${product.id}" />
						<spring:param name="pieceId" value="${piece.id }" />
					</spring:url>
					<a href="${fn:escapeXml(productUrl)}"><c:out
							value="${piece.name}" /></a>
				</datatables:column>
				<datatables:column title="Name" display="pdf">
					<c:out value="${piece.name}" />
				</datatables:column>
				<datatables:column title="Color" property="color" />
				<datatables:column title="Weight" property="weight" />
				<datatables:column title="Length" property="length" />
				<datatables:column title="Height" property="height" />
				<datatables:column title="Width" property="width" />
				<datatables:column title="Depth" property="depth" />
				<datatables:column title="Price" property="price" />
				<datatables:column title="Material" property="material" />
				<datatables:column title="Add File">
					<spring:url
						value="/products/{productId}/piece/{pieceId}/addfile.html"
						var="addFileUrl">
						<spring:param name="productId" value="${product.id}" />
						<spring:param name="pieceId" value="${piece.id }" />
					</spring:url>
					<a href="${fn:escapeXml(addFileUrl)}">Add File</a>
				</datatables:column>

				<datatables:export type="pdf" cssClass="btn btn-small" />
			</datatables:table>
		</c:if>
		<h2>Flies</h2>
		<c:if test="${!empty product.files }">
			<c:forEach var="file" items="${product.files}">
				<table class="table" style="width: 600px;">
					<tr>
						<td valign="top" style="width: 120px;">
							<dl class="dl-horizontal">
								<dt>Name</dt>
								<dd>
									<a
										href="${pageContext.request.contextPath}/download/${file.id}.html"><c:out
											value="${file.name}" /></a>
								</dd>
								<dt>Extension</dt>
								<dd>
									<c:out value="${file.extension}" />
								</dd>
								<dt>Content Type</dt>
								<dd>
									<c:out value="${file.contentType}" />
								</dd>
							</dl>
						</td>
					</tr>
				</table>
			</c:forEach>
		</c:if>
		<jsp:include page="../fragments/footer.jsp" />
	</div>

</body>

</html>
