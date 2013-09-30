<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>
    <h2>Products</h2>
    
    <datatables:table id="owners" data="${selections}" cdn="true" row="product" theme="bootstrap2" 
                      cssClass="table table-striped" paginate="false" info="false" export="pdf">
        <datatables:column title="Name" cssStyle="width: 100px;" display="html">
            <spring:url value="/products/{productId}.html" var="productUrl">
                <spring:param name="productId" value="${product.id}"/>
            </spring:url>
            <a href="${fn:escapeXml(productUrl)}"><c:out value="${product.name}"/></a>
        </datatables:column>
        <datatables:column title="Name" display="pdf">
            <c:out value="${product.name}"/>
        </datatables:column>
        <datatables:column title="Color" property="color"/>
        <datatables:column title="Weight" property="weight"/>
        <datatables:column title="Length" property="length"/>
        <datatables:column title="Height" property="height"/>
        <datatables:column title="Width" property="width"/>
        <datatables:column title="Depth" property="depth"/>
        <datatables:column title="Price" property="price"/>
        <datatables:column title="Material" property="material"/>
        <datatables:export type="pdf" cssClass="btn btn-small" />
    </datatables:table>
    
    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
