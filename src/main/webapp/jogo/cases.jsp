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
	
            
           <div class="casos"> 
             	<a href="/jogo/openCase.action?caseId=1">
               	<h3>Caso 1</h3>			
                	<p>Lorem ipsum dolor sit amet, porta sit amet fringilla quis, semper fringilla dolor. Suspendisse metus dui, dictum in scelerisque nec, tristique id nunc. Nulla consectetur metus quis sapien malesuada pellentesque.  </p>
				</a>
             </div>
            
      <div class="casos"> 
             	<a href="#">
                	<h3>Caso 2</h3>			
                	<p>Lorem ipsum dolor sit amet, porta sit amet fringilla quis, semper fringilla dolor. Suspendisse metus dui, dictum in scelerisque nec, tristique id nunc. Nulla consectetur metus quis sapien malesuada pellentesque. a. </p>
				</a>
            </div>
            
            <div class="casos"> 
             	<a href="#">
                	<h3>Caso 3</h3>			
                	<p>Lorem ipsum dolor sit amet, porta sit amet fringilla quis, semper fringilla dolor. Suspendisse metus dui, dictum in scelerisque nec, tristique id nunc. Nulla consectetur metus quis sapien malesuada pellentesque. a. </p>
				</a>
            </div>
 
		</div><!-- fim conteudo-->	
	
	<div class= "clear"></div><!-- fix bug altura atomática-->

	<%@ include file="/jogo/inc/playerFooter.jsp" %>

</div><!-- fim container -->
	


</body>
</html>
