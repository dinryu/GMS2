<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <jsp:include page="common/header.jsp" /> --%>
<img src="resources/img/loading.gif" 
     alt="" />     
<script>
alert('app.path.init 진입');
app.path.init("<%=application.getContextPath() %>");
/* app.path.init("${ctx}"); */
</script>