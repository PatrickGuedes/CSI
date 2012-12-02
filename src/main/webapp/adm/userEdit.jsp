<%@ include file="/adm/inc/init.jsp" %>
<%@page import="br.com.projeto.entity.User" %>
<%
Map<String, Object> model = (Map<String,Object>) request.getAttribute("model");

User user = (User) model.get("User");
%>

Login do Usuario: <%= user.getLogin() %>

