<%@ include file="/jogo/inc/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="/jogo/inc/taghead.jsp" %>

<body>

<div class="container">

	<%@ include file="/jogo/inc/playerHeader.jsp" %>
			
		<div class="divconteudo float-left">
			<h2>Laborat�rio</h2>
	
            
           <div class="pistas"> 
 
                	<h3>Pista 1 : <span class="verde">Pen Drive</span></h3>			
     

             </div>
            
         <form action="" method="get">
      	
            <div class="height1x">
				<input type="button" class="botao_azul" onclick="javascript:document.location.replace('casos.html')"  value="Processar Pistas"/>
                <input type="button" class="botao_azul" onclick="javascript:document.location.replace('casos.html')"  value="Tomar Caf�"/>			
			</div>
           </form>
 
		</div><!-- fim conteudo-->		
	
	<div class= "clear"></div><!-- fix bug altura atom�tica-->

	<%@ include file="/jogo/inc/playerFooter.jsp" %>

</div><!-- fim container -->
	


</body>
</html>
