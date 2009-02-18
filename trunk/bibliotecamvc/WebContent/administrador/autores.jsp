<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/biblioteca" prefix="bb" %>

<jsp:include page="../include/headerAdmin.jsp"></jsp:include>
<jsp:include page="../include/menuadmin.jsp"></jsp:include>
<jsp:include page="../include/content.jsp"></jsp:include>

<bb:auttable list="${requestScope.lista}"/>
<jsp:include page="../administrador/error.jsp"></jsp:include>
<jsp:include page="../include/footer.jsp"></jsp:include>