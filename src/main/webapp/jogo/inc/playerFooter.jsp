<c:set var="url" value="${pageContext.request.requestURL}"/>

<!-- ##################################RODAPÉ##################################### -->	
<div class= "divrodape clear">

        <div class="menu">
			<ul>
				<c:if test="${fn:contains(url, 'traces.jsp') }">
					<li><a href="locais.html" class="float-right">Locais</a></li>
				</c:if>
				<c:if test="${fn:contains(url, 'locations.jsp') }">
					<li><a href="laboratorio.html" class="float-right">Laboratório</a></li>
				</c:if>
                <!--item menu a esquerda -->
                <li><a href="/jogo/logout.action" class="float-left">Sair</a></li>
			</ul>
           
		</div><!-- fim menu -->

</div><!-- fim rodapé-->	
