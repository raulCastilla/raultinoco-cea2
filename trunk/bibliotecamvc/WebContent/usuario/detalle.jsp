<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalle de su libro</title>
</head>
<body>
<jsp:include page="../include/header.jsp"></jsp:include>
<jsp:include page="../include/menuser.jsp"></jsp:include>
<jsp:include page="../include/content.jsp"></jsp:include>
<c:if test="${requestScope.error}">
${requestScope.error}
</c:if>
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>