/*eu n�o jogo mais para o .jsp direto
sempre passa pelo .action
seguinte
nos locais... faz um link para "/jogo/traces.action?locationId=X"*/
 $(document).ready(function(){
		
		$('#frmLogin').validate({
            rules:{
                login:{
                    required: true,
                    minlength: 3
                },
                password: {
                    required: true,
                    minlength: 3
                }
                
            },
            messages:{
                login:{
                    required: "O campo login � obrigatorio.",
                    minlength: "O campo login deve conter no m�nimo 3 caracteres."
                },
				
                password: {
                    required: "O campo senha � obrigatorio.",
					minlength: "O campo senha deve conter no m�nimo 3 caracteres."
                }
            }
 			
        });
        
		
		$('#frmCad').validate({
            rules:{
                username:{
                    required: true,
                    minlength: 3
                },
                password: {
                    required: true,
					minlength: 6
                    //email: true
                }
                
            },
            messages:{
                username:{
                    required: "O campo login � obrigatorio.",
                    minlength: "O campo login deve conter no m�nimo 3 caracteres."
                },
				password:{
                    required: "O campo senha � obrigatorio.",
                    minlength: "O campo senha deve conter no m�nimo 6 caracteres."
                },
				
                termos: "Para se cadastrar voc� deve aceitar os termos de uso."
            }
 			
        });
		
		$('a[class^="buscaPista"]').click(function(){
			var b = $(this).attr("class");
			var l = b.split("_");
			var ln = l[1];
			var lnk = "/jogo/foundTrace.action?traceId="+b;
			var nome = $(this).attr("id");
			
			$.ajax({
				type: "POST",
                url: "/jogo/foundTrace.action?traceId="+ln,
                
				success: function(r){ 
					if(r=="P"){
						alert("Pista Encontrada!: "+nome);
						$(this).css("display","none");
						location.reload();
					}
					if(r=="N"){
						
						alert("Nenhuma pista encontrada");
					}
				    
				    
				},
				error: function(){  
				  
				}
			});
		});
		
		$('input[name="btCafe"]').click(function(){
			
			$.ajax({
				type: "POST",
                url: "/jogo/drinkCoffee.action",
                
				success: function(r){ 
					if(r=="E"){
						alert("Voc� bebeu caf�!");
						
						location.reload();
					}
					if(r=="W"){
						
						alert("Acabou o caf�");
					}
				    
				    
				},
				error: function(){  
				  
				}
			});
			
		});
		
		$('input[name="btProcessar"]').click(function(){
			
			$.ajax({
				type: "POST",
                url: "/jogo/processTraces.action",
                
				success: function(r){ 
					if(r=="R"){
						alert("Caso Resolvido!");
						window.location = '/jogo/cases.action';
					}
					if(r=="F"){
						
						alert("Pista Processada");
						location.reload();
					}
					if(r=="E"){
						alert("Pista N�O FOI processada!");
						//window.location = '/jogo/cases.action';
						location.reload();
					}
					
				    
				},
				error: function(){  
				  
				}
			});
			
		});

    });