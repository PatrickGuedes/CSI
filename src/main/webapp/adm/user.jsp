<%@ include file="/jogo/inc/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<%@ include file="/adm/inc/taghead.jsp" %>
</head>
<%
Map<String, Object> model = (Map<String,Object>) request.getAttribute("model");

String flashMessage = (String) model.get("FlashMessage");
%>

<body>
    <div id="container">
		<%@ include file="/adm/inc/header.jsp" %>
    </div>
    <h2>Usuários - ${flashMessage} - <%= flashMessage %></h2>
			
			<c:forEach items="${Users}" var="usu">
				<div class='locais'> 
             	
               	<h3>${usu.id} - ${usu.login}</h3>			
               
				</div>
				
						
			</c:forEach>
</body>
</html>