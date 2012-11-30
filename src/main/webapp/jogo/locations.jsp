<%@ include file="/jogo/inc/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="/jogo/inc/taghead.jsp" %>

<body>

<div class="container">

	<%@ include file="/jogo/inc/playerHeader.jsp" %>
			
<!-- ##################################CONTEÚDO################################### -->				
		<div class="divconteudo float-left">
			<h2>Locais</h2>
	
            
           <div class="locais"> 
             	<a href=pistas.html>
					<h3>Laboratório de Informática</h3>		
			 </a>
             </div>
            
	      <div class="locais"> 
             	<a href="#">
                	<h3>Sala de Reunião</h3>	
				</a>
            </div>
            
            <div class="locais"> 
             	<a href="#">
                	<h3>Sala de Jogos</span></h3>
				</a>
            </div>
 
		</div><!-- fim conteudo-->	
	
	<div class= "clear"></div><!-- fix bug altura atomática-->

	<%@ include file="/jogo/inc/playerFooter.jsp" %>

</div><!-- fim container -->
	


</body>
</html>
