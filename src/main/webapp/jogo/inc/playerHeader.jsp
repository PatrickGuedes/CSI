<!-- ##################################CABEÇALHO############################## -->
	
<%@page import="br.com.projeto.entity.Player"%><div class="divcabecalho">
		<div class="marca float-left"></div>
		<div class="nome_usuario float-left">
			<h1>
            <!--Jogador-->
            	<span class="azul">Player:</span> 
                <span class="verde">${Player.getUsername()}</span><br />
            <!--XP-->  
            	<span class="azul">XP:</span> 
                <span class="verde">${Player.getXp()}</span><br />
            <!--Energia-->  
            	<span class="azul">Energia:</span> 
                <span class="verde">${Player.getEnergy()}</span><br />
            </h1>
		</div>
	</div><!-- fim cabecalho -->
