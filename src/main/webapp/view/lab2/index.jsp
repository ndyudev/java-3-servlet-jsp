<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="header.jsp"%>

<h3>Hello, ${username}</h3>
<p>${message}</p>
<p>${age}</p>
<p>${list}</p>
<input type="checkbox" ${gioitinh ? 'checked' : '' }>
<ul>
  <li>${list[0].name}</li>
  <li>${list[1]}</li>
  <li>${list.add(list[1])}</li>
</ul>
<p></p>

<!-- include footer bằng jsp:include -->
<jsp:include page="footer.jsp">
	<jsp:param name="extra" value="Included via jsp:include ✅" />
</jsp:include>
