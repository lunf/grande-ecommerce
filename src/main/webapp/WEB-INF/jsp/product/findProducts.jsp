<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="../fragments/bodyHeader.jsp"/>

    <h2>Find Products</h2>

    <spring:url value="/products.html" var="formUrl"/>
    <form:form modelAttribute="product" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-product-form">
        <fieldset>
            <div class="control-group" id="name">
                <label class="control-label">Name </label>
                <form:input path="lastName" size="30" maxlength="80"/>
                <span class="help-inline"><form:errors path="*"/></span>
            </div>
            <div class="form-actions">
                <button type="submit">Find Product</button>
            </div>
        </fieldset>
    </form:form>

    <br/>
    <a href='<spring:url value="/products/new" htmlEscape="true"/>'>Add Product</a>

    <jsp:include page="../fragments/footer.jsp"/>

</div>
</body>

</html>
