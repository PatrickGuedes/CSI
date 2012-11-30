<%@ include file="/jogo/inc/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="/jogo/inc/taghead.jsp" %>

<body>

<div class="container">

	<%@ include file="/jogo/inc/playerHeader.jsp" %>
			
<!-- ##################################CONTEÚDO################################### -->				
		<div class="divconteudo float-left">
			<h2>Casos</h2>
	
            
           <c:forEach items="${Cases}" var="item">
				<div class="casos"> 
             	<a href="locais.html">
               	<h3>${item.subject}</h3>			
                	<p>${item.description }</p>
                </a>
				</div>
				
						
			</c:forEach>
 
		</div><!-- fim conteudo-->	
	
	<div class= "clear"></div><!-- fix bug altura atomática-->

	<%@ include file="/jogo/inc/playerFooter.jsp" %>

</div><!-- fim container -->
	


</body>
</html>
