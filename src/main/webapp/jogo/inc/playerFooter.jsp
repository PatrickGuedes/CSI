<c:set var="url" value="${pageContext.request.requestURL}"/>

<!-- ##################################RODAP�##################################### -->	
<div class= "divrodape clear">

        <div class="menu">
			<ul>
				<c:if test="${fn:contains(url, 'traces.jsp') || fn:contains(url, 'lab.jsp')}">
					<li><a href="/jogo/locations.action" class="float-right">Locais</a></li>
				</c:if>
				<c:if test="${fn:contains(url, 'locations.jsp') }">
					<li><a href="/jogo/lab.action" class="float-right">Laborat�rio</a></li>
				</c:if>
                <!--item menu a esquerda -->
                <li><a href="/jogo/logout.action" class="float-left">Sair</a></li>
			</ul>
           
		</div><!-- fim menu -->

</div><!-- fim rodap�-->	
