<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/biblioteca" prefix="bb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../include/headerAdmin.jsp"></jsp:include>
<jsp:include page="../include/menuadmin.jsp"></jsp:include>
<jsp:include page="../include/content.jsp"></jsp:include>

<bb:ft label="Titulo" nombre="titulo"/><br>
<bb:ft label="Autor" nombre="autor"/>
<bb:frm url="#" method=""></bb:frm>
<jsp:include page="../administrador/error.jsp"></jsp:include>
<jsp:include page="../include/footer.jsp"></jsp:include>