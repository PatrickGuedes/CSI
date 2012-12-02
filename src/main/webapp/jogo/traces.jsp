<%@ include file="/jogo/inc/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="/jogo/inc/taghead.jsp" %>

<body>

<c:if test='${NoEnergy == true}'>
<script>
alert('Você está cansado para visitar esse local!');
document.location.replace('/jogo/locations.action');
</script>
</c:if>

<div class="container">

	<%@ include file="/jogo/inc/playerHeader.jsp" %>
			
<!-- ##################################CONTEÚDO################################### -->				
		<div class="divconteudo float-left">
        	<h2>Pistas<h2>
			<h4>${Location.getName() }<h4>
			<c:set var="i" value="0" />
            <c:forEach items="${Traces}" var="pista">
				<div class="pistaslocal float-left">
					
             		<a target="_blank" class='buscaPista_${pista.id}' <c:if test='${pista.name==null}'>id="pista${i}"</c:if><c:if test='${pista.name!=null}'>id='${pista.name}'</c:if>></a>
				</div>
				<c:set var="i" value="${i+1}" />		
			</c:forEach>
           
           </div>
	<div class= "clear"></div><!-- fix bug altura atomática-->

	<%@ include file="/jogo/inc/playerFooter.jsp" %>

</div><!-- fim container -->
	


</body>
</html>
