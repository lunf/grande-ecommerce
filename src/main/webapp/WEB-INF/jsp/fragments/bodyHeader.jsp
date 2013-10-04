<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/resources/images/banner-graphic.png" var="banner" />
<img src="${banner}" />

<div class="navbar" style="width: 650px;">
	<div class="navbar-inner">
		<ul class="nav">
			<li style="width: 100px;"><a
				href="<spring:url value="/" htmlEscape="true" />"><i
					class="icon-home"></i> Home</a></li>
			<li style="width: 120px;"><a
				href="<spring:url value="/products/find.html" htmlEscape="true" />"><i
					class="icon-th-list"></i> Products</a></li>
			<li style="width: 130px;"><a
				href="<spring:url value="/material/new.html" htmlEscape="true" />"><i
					class="icon-th-list"></i> Materials</a></li>
			<li style="width: 100px;"><a
				href="<spring:url value="/color/new.html" htmlEscape="true" />"><i
					class="icon-th-list"></i> Colors</a></li>
			<li style="width: 130px;"><a
				href="<spring:url value="/catagory/new.html" htmlEscape="true" />"><i
					class="icon-th-list"></i> Catagory</a></li>
		</ul>
	</div>
</div>

