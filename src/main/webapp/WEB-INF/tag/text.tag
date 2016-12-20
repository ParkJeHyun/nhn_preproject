<%@ tag pageEncoding="UTF-8"%>
<%@ tag dynamic-attributes="attrs"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="required" type="java.lang.Boolean"%>
<%@ attribute name="placeholder"%>
<%@ attribute name="defaultValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="form-group">
    <label for="${id}" class="col-md-2 control-label">${label}</label>
    <div class="col-md-10">
        <input id="${id}" name="${id}" class="form-control"
               type="text"
               <c:if test="${required}">required</c:if>
        <c:if test="${not empty placeholder}">
               placeholder="<c:out value="${placeholder}"/>"
        </c:if>
        <c:forEach items="${attrs}" var="attr">
            ${attr.key}="${attr.value}"
        </c:forEach>
        <c:if test="${not empty defaultValue}">
            value="<c:out value="${defaultValue}"/>"
        </c:if>>
    </div>
</div>
