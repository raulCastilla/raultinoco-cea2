<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@
taglib uri="http://java.sun.com/jsp/jstl/fmt-rt" prefix="fmt" %> 
<%@
taglib uri="/simpleTag" prefix="ex" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${applicationScope.bean.valor2}
<hr>
<c:if test="${!empty param.nombre}">
hola ${param.nombre}
</c:if>
<hr>
<ex:simpleTag color="green" mensaje="Texto de color verde"/>
<hr>
<ex:moneda valor="34.23" patron="&euro;"/>
<hr>
<ex:traductorMapa valor2="${applicationScope.bean.valor2}"/>
</body>
</html>