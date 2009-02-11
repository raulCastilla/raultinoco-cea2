<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="/form" prefix="fml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set scope="request" var="var1" value="no se que pasa con java"></c:set>
<hr>
<c:if test="${fn:contains(requestScope.var1,'se')}">
Contiene "se"
</c:if>
<hr>
<c:set scope="request" var="var2" value="        NO se que pasa con java          "></c:set>
<c:if test="${fn:containsIgnoreCase(requestScope.var2,'no')}">
Contiene "no"
</c:if>
<hr>
<c:set scope="request" var="var3" value="fichero.jpg"></c:set>
<c:if test="${fn:endsWith(requestScope.var3,'.jpg')}">
Termina en .jpg
</c:if>
<hr>
${fn:escapeXml("<b>hola</b>") }
<b>hola</b>
<hr>
${fn:indexOf("hola","la")}
<hr>
<jsp:useBean id="arreglo" scope="request" class="es.cea.Arreglo" />

${fn:join(requestScope.arreglo.array,'--') }

<hr>
${fn:length(requestScope.arreglo.array) }
<hr>
${fn:replace(requestScope.var2," ", "..")}
<hr>
<ul>
<c:forEach items="${fn:split(requestScope.var2 ,' ')}" var="x">
<li>${x}</li>
</c:forEach>
</ul>
<hr>
<c:if test="${fn:startsWith(requestScope.var3,'fi')}">
Empieza por fi
</c:if>
<hr>
${fn:substring(requestScope.var2,2,7)}
<hr>
${fn:substringAfter(requestScope.var2, "q")}
<hr>
${fn:substringBefore(requestScope.var2, "j")}
<hr>
${fn:toLowerCase(requestScope.var2)}
<hr>
Original: ${requestScope.var2 }<br>
En mayuscula: ${fn:toUpperCase(requestScope.var2 ) }
<hr>
${fn:trim(requestScope.var2)}
<fml:frm url="funciones.jsp" method="get">
<fml:ft nombre="texto1" label="Texto1"/>
<fml:ft nombre="texto2" label="Texto1"/>
<fml:ft nombre="texto3" label="Texto1"/>
<fml:ft nombre="texto4" label="Texto1"/>
<fml:pwd nombre="texto5" label="Texto5"/>
</fml:frm>
</body>
</html>