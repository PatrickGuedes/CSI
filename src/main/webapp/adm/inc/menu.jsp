<%@ include file="/jogo/inc/init.jsp" %>
<c:set var="navArr" value="${fn:split(nav, '#')}"/>

<ol>
	<li><a <c:if test="${fn:contains(navArr[0], 'menu1')}"> class="selected"</c:if> href="/adm/user.action" title="menu1">Menu1</a></li>
	<li><a <c:if test="${fn:contains(navArr[0], 'menu2')}"> class="selected"</c:if> href="/adm/exclui.action" title="menu2">Menu2</a></li>
	<li><a <c:if test="${fn:contains(navArr[0], 'menu2')}"> class="selected"</c:if> href="menu3" title="menu3">Menu3</a></li>		
</ol>

<c:choose>
	<c:when test="${navArr[0] eq 'menu1'}">
		<ul id="submenu" class="left">
			<li <c:if test="${navArr[1] eq 'subMenu1'}">class="selected"</c:if>>
				<a href="/adm/user" title="subMenu1">SubMenu1</a>
			</li>
			<li <c:if test="${navArr[1] eq 'subMenu2'}">class="selected"</c:if>>
				<a href="/adm/exclui" title="subMenu2">SubMenu2</a>
			</li>			
		</ul>
	
	</c:when>
</c:choose>