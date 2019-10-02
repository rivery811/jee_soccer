<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"/>
플레이어메인
<c:choose>
	<c:when test="${word eq 'main'}">
		<jsp:include page="2_positions_q.jsp"/>
		<jsp:include page="4_find_by_teamid_position.jsp"/>
		<jsp:include page="5_find_by_teamid_height_name.jsp"/>
	</c:when>
	<c:when test="${word eq 'find2'}">
		<jsp:include page="2_positions_a.jsp"/>
	</c:when>
	<c:when test="${word eq 'find4'}">
		<jsp:include page="4_find_by_teamid_position_a.jsp"/>
	</c:when>
	<c:when test="${word eq 'find5'}">
		<jsp:include page="5_find_by_teamid_height_name_a.jsp"/>
	</c:when>

</c:choose>
<script>
app.init('${ctx}');
</script>

<jsp:include page="../common/foot.jsp"/>