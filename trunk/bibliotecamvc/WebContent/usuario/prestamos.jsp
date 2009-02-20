<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="/biblioteca" prefix="bb" %>

<jsp:include page="../include/header.jsp"></jsp:include>
<jsp:include page="../include/menuregister.jsp"></jsp:include>
<jsp:include page="../include/content.jsp"></jsp:include>
<bb:prestamolibro prestamo="${requestScope.libroPrestamo"/>
<jsp:include page="../usuario/error.jsp"></jsp:include>
<jsp:include page="../include/footer.jsp"></jsp:include>