<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <jsp:include page="common/header.jsp" /> --%>
<img src="${path.img}/resources/img/loading.gif" 
     alt="" />     
<script>
alert('home.jsp 에서 script 진입');
app.path.init("${path.ctx}");
/* app.path.init("${ctx}"); */
</script>