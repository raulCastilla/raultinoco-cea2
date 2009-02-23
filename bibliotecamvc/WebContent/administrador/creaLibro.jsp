<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="/biblioteca" prefix="bb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="../include/headerAdmin.jsp"></jsp:include>
<jsp:include page="../include/menuadmin.jsp"></jsp:include>
<jsp:include page="../include/content.jsp"></jsp:include>
<c:if test="${!empty requestScope.error}">
${requestScope.error }

</c:if>

<bb:frm method="post" url="./libro?accion=create">
<bb:ft label="Referencia: " nombre="referencia"/><br>
<bb:ft label="Título: " nombre="titulo"/><br>
<bb:ft label="Autor: " nombre="autor"/><br>
<bb:ft label="Género: " nombre="genero"/><br>
<bb:ft label="Fecha de publicación: " nombre="fecha"/><br>
</bb:frm>

<jsp:include page="../include/footer.jsp"></jsp:include>