package autocar.veiculos.sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import autocar.veiculos.objetos.Carro;
import autocar.veiculos.objetos.Marca;
import autocar.veiculos.objetos.Relatorio;
import autocar.veiculos.status.StatusVeiculo;


public class Principal {
	static List<Carro> carros = new ArrayList<Carro>(); 
	static List<Relatorio> finan = new ArrayList<Relatorio>();
	static HashMap<String, List<Carro>> separaCarro = new HashMap<String, List<Carro>>();
	
	public static void main(String[] args) { 
		loginAcesso();		
	}
	private static void loginAcesso() {
		for(int i = 0;i<3;i++){
				
			String user = JOptionPane.showInputDialog("Digite seu usuario");
			String senha = JOptionPane.showInputDialog("Digite sua senha");
			
			if(user.equalsIgnoreCase("adm") && senha.equalsIgnoreCase("1234")) {
				acessaMenu();
				break;
			  }else {
				  JOptionPane.showMessageDialog(null, "Usuario ou senha icorretos!", "Erro login", 0);

			  }
		 }
		}

	public static void acessaMenu() {
		int escolha = 0;
		while(escolha != 8) {
			
		   escolha = Integer.parseInt(JOptionPane.showInputDialog(null, 
				   			 "-- Bem vindo ao AutoCar --"
							  + "\nEscolha a opção"
                              + "\n1 >>> Cadastrar veiculo"
							  + "\n2 >>> Remover veiculo"
							  + "\n3 >>> Alugar carro"
                              + "\n4 >>> Fecha aluguel"
                              + "\n5 >>> Listar veiculos alugados"
                              + "\n6 >>> Listar veiculos"
                              + "\n7 >>> Listar baixas"                             
                              + "\n8 >>> Sair", "AutoCar Veiculos", 3)); 
		   switch (escolha) {
		   
		   /*METODO DE CADASTRO DE VEICULOS*/
		case 1:	
			
			String nome = JOptionPane.showInputDialog("Nome veiculo:");
			String modelo = JOptionPane.showInputDialog("Modelo do veiculo:");
			String cor = JOptionPane.showInputDialog("Cor do veiculo:");
			String marcaV = JOptionPane.showInputDialog("Marca do veiculo:");
			String placa = JOptionPane.showInputDialog("Placa do veiculo:");
			int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de fabricação:"));
			double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do aluguel:"));
			
			//seta no objeto carro//
			Carro carro = new Carro();
			carro.setNome(nome);
			carro.setModelo(modelo);
			carro.setCor(cor);
			carro.setValor(valor);
			carro.setPlaca(placa);
			carro.setAno(ano);
			
			//seta no objeto marca//
			 Marca marca = new Marca();
			 marca.setNome(marcaV);
			
			//adiciona na lista de marcas//
			 carro.getMarca().add(marca);
		    // adiciona na lista de carros//
			carros.add(carro);
			JOptionPane.showMessageDialog(null, "Veiculo salvo com sucesso!");
			
			break;
			
		case 2:
			boolean vf = false;
			String buscaPlaca = JOptionPane.showInputDialog("Informe a placa do veiculo:");
			if(vf == false) {
			for(int b=0; b<carros.size(); b++) {
				Carro carroRemove = carros.get(b);
				for(int c=0; c<carros.size(); c++) {
					if(carroRemove.getPlaca().equalsIgnoreCase(buscaPlaca)) {
						if (carroRemove.isAlugado()) {
						vf = false;
					}else {						
						carros.remove(b);
				        JOptionPane.showMessageDialog(null, "Veiculo removido!", "Remoção", 1);
				        for(int a=0; a<finan.size(); a++) {
				        	Relatorio baixas = finan.get(a);
				        	for(int bs=0; bs<finan.size(); bs++) {
				        		if(baixas.getPlaca().equals(carroRemove.getPlaca())) {
				        			finan.remove(bs);
				        		}
				        	}
				         }
				        vf = true;
					}
				   }
				  }
				 }
			    }
			if (vf == false) {
				JOptionPane.showMessageDialog(null, "Erro ao realizar a operação! Verifique se o veiculo possui cadastro, ou se está alugado.", "Atenção", 0);
			}
			break;
			/* METODO DE ALUGUEL DE VEICULO */
		case 3:
			String buscaCarro = JOptionPane.showInputDialog("Informe a placa do carro:");
			
			if(!buscaCarro.isEmpty()) {	
				
			for(int pos=0; pos<carros.size(); pos++) {
			/*Armazena o objeto carregado em memoria*/	
			Carro alugacaro = carros.get(pos);
		
			  for(int procura=0; procura < carros.size(); procura++) {
				  /*Valida o objeto se contem a placa de busca*/			
				  if(alugacaro.getPlaca().equalsIgnoreCase(buscaCarro)){
					  if(alugacaro.isAlugado() == false) {
					     alugacaro.setAlugado(true);					     
					JOptionPane.showMessageDialog(null, "Veiculo alugado R$"+alugacaro.getValor()+" por dia!");
				    break;
				    }else{
						  	JOptionPane.showMessageDialog(null, "Esse veiculo já está alugado!");
						  	break;
				       }
				    }
			     }
			
			   }
			}else {
				JOptionPane.showMessageDialog(null, "Veiculo não cadastrado!");
				break;
			}

			break;
			/* METODO DE BAIXAS DE ALUGUEL*/
	    case 4:
	    	/* String para a busca do veiculo na lista de Objetos de veiculos */
	    	String placaF = JOptionPane.showInputDialog("Buscar veiculo informe a placa");
	    	/*Loop para pegar o Index do objeto buscado na String*/
	    	for(int busca=0; busca < carros.size(); busca++) {
	            /*Variavel tipo objeto para armazenar a lista de carros cadastrados*/
	    		Carro carroBuscado = carros.get(busca);
	    		/*Loop para indetificar dentro da Variavel tipo Objeto*/
	    		for(int i=0; i<carros.size(); i++) {
	    			/*Para o Loop caso encontre a placa buscada*/
	    			if(carroBuscado.getPlaca().equalsIgnoreCase(placaF)) {
	    				if(carroBuscado.isAlugado()==false) {
	    					JOptionPane.showMessageDialog(null, "Este veiculo já está no patio!", "Atenção", 0);
	    					break;
	    				}else {
	    					//1º pgt
	    					int baix = JOptionPane.showConfirmDialog(null, "Carro: "+carroBuscado.getNome()+"\nModelo: "+carroBuscado.getModelo()+"\nCor: "+carroBuscado.getCor()+"\nDeseja realizar a baixa desse veiculo?");
	    					// if da pgt
	    					if(baix == 0) {
	    					int dias = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de dias:"));
	    					//2º pgt
	    					int esc = JOptionPane.showConfirmDialog(null, "Deseja realizar a baixa e finalizar?", "Confirma", 0);
	    					double totalAluguel = (dias*carroBuscado.getValor());
	    					//if da pgt
	    					if(esc == 0) {
	    						
	    						/*Seta o status do veiculo para False deixando livre*/
	    						carroBuscado.setAlugado(false);	    						
	    						/*Parte de adicionar na lista de baixa de um carro ou mais*/
	    						Relatorio vazia = new Relatorio();	    						
	    						/*variavel de verificar se o carro existe*/
	    						boolean v = false;
	    						/*se a lista estiver vazia adiciona o veiculo na lista de baixas*/
	    						if(finan.isEmpty()) {
	    							  
	    							  vazia.setCarro(carroBuscado.getNome());
		    					      vazia.setValor(totalAluguel);
		    					      vazia.setPlaca(carroBuscado.getPlaca());
		    					      vazia.setCor(carroBuscado.getCor());
		    					      vazia.setModelo(carroBuscado.getModelo());		    					      
		       						  finan.add(vazia); 
		       						/*senão se existir uma baixa para a placa só adiciona no valor das baixas*/  
	    						}else {
	    							for(Relatorio achou : finan) {
	    								if(achou.getPlaca().equalsIgnoreCase(carroBuscado.getPlaca())) {
	    									achou.adicionaValor(totalAluguel);
	    									/*seta para true para a baixa existente*/
	    									v = true;
	    								}		
	    							  }
	    							}
	    						/*verifica o valor da variavel se tiver false faz a busca na lista comparando com a placa da buscada*/
	    						if(v == false) {	
	    							for(int e=0; e<finan.size(); e++) {
		    							Relatorio novo = finan.get(e);
		    							for(int f=0; f<finan.size();f++) {
		    						if(!novo.getPlaca().equalsIgnoreCase(carroBuscado.getPlaca())) {
		    							Relatorio novoV = new Relatorio();
										novoV.setCarro(carroBuscado.getNome());
										novoV.setValor(totalAluguel);
										novoV.setPlaca(carroBuscado.getPlaca());
										novoV.setCor(carroBuscado.getCor());
										novoV.setModelo(carroBuscado.getModelo());
										finan.add(novoV);										
										break;
										}
		    						  }
		    						} 
	    						  }  
	    						double valorD=0;
	    						String tpgto;
	    						StringBuilder imp = new StringBuilder();
	    					  
	    					  for(int cont=0; cont<4; cont++) {
	    					  int tpbx = Integer.parseInt(JOptionPane.showInputDialog(null,"Diarias: "+dias+"\nValor total R$: "+totalAluguel+"\nEscolha o recebimento\n1 >>> Dinheiro\n2 >>> Cartão"));
	    					  if(tpbx == 1) {
	    						  tpgto = "Dinheiro";
	    						  valorD = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor em dinheiro:"));
	    						  
	    						  double troco = (valorD-totalAluguel);
	    						  
	    						  imp.append("-----------Demonstrativo de baixa---------------");
	    						  imp.append("\n-----------------------------------------------");
	    						  imp.append("\nValor do aluguel R$: "+carroBuscado.getValor());
	    						  imp.append("\nValor total R$: "+totalAluguel);
	    						  imp.append("\nTotal diarias: "+dias);
	    						  imp.append("\nTroco R$: "+troco);
	    						  imp.append("\nTipo de pagamento: "+tpgto);
	    						  imp.append("\n---------------------------------------------");
	    						  imp.append("\nObrigado! att. AutoCar.");
	    						  imp.append("\n---------------------------------------------");
    						  
	    						  JOptionPane.showMessageDialog(null, imp.toString(),"Recibo", 1);
	    						  break;
	    						 
	    						  
	    					  }else if (tpbx == 2) {
	    						  valorD = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para passar:"));
	    						  tpgto = "Cartão"; 
	    						  imp.append("-----------Demonstrativo de baixa---------------");
	    						  imp.append("\n-----------------------------------------------");
	    						  imp.append("\nValor em R$:"+valorD);
	    						  imp.append("\nValor do aluguel R$: "+carroBuscado.getValor());
	    						  imp.append("\nValor total R$: "+totalAluguel);
	    						  imp.append("\nTotal diarias: "+dias);
	    						  imp.append("\nTipo de pagamento: "+tpgto);
	    						  imp.append("\n---------------------------------------------");
	    						  imp.append("\nObrigado! att. AutoCar.");
	    						  imp.append("\n---------------------------------------------");
	    						  
	    						  JOptionPane.showMessageDialog(null, imp.toString(), "Recibo", 1);
	    						  break;
	    					  }else if (cont == 4) {
	    						  carroBuscado.setAlugado(true);
	    						 for(int b=0; b<finan.size(); b++) {
	    							 Relatorio rmv = finan.get(b);
	    						  for(int f=0; f<finan.size(); f++) {
	    							  if(rmv.getPlaca().equalsIgnoreCase(placaF)) {
	    								  finan.remove(f);
	    								  break;
	    							  }
	    						  }
	    						 }
	    						 JOptionPane.showMessageDialog(null, "Operação cancelada por erros do usuario", "Atenção", 0);
	    						 break;
	    						  //
	    					   }else {
	    						   JOptionPane.showMessageDialog(null, "Opção invalida!", "Atenção", 0);
	    					   }
	    					  }
	    						
	    				      
	    				      //3º pgt

	    				    int comp = JOptionPane.showConfirmDialog(null, "Imprimir resumo do veiculo?");
	    				      //if da pgt
	    				      if(comp == 0) {
	    				    	  imp.append("------------------------------------------\n");
	    				    	  imp.append("Veiculo: "+carroBuscado.getNome());
	    				    	  imp.append("\nPlaca: "+carroBuscado.getPlaca());
	    				    	  imp.append("\nModelo: "+carroBuscado.getModelo());
	    				    	  imp.append("\nCor: "+carroBuscado.getCor());
	    				    	  imp.append("\nDiarias: "+dias);
	    				    	  imp.append("\nValor diaria R$: "+carroBuscado.getValor());
	    				    	  imp.append("\nValor totaL: R$"+totalAluguel);
	    				    	  imp.append("-------------------------------------------");
	    					      JOptionPane.showMessageDialog(null,imp.toString(), "Resumo do aluguel", 1);
	    						break;
	    				       }
	    					  }
	    					}else {
	    						JOptionPane.showMessageDialog(null, "Operação cancelada!");
	    					}
	    				}
	    				    				
	    			}
	    		}	    		
	    		
	    	}
	    	
	    	break;
	    case 5:
	    	if(!carros.isEmpty()) {
	    	 separaCarro.put(StatusVeiculo.ALUGADO, new ArrayList<Carro>());
	    	 for (Carro carro2 : carros) {
	    		 if(carro2.AlugaCarro().equalsIgnoreCase(StatusVeiculo.ALUGADO)) {
				separaCarro.get(StatusVeiculo.ALUGADO).add(carro2);		
	    		 }
			}
	    	 
	    	 for(Carro imprime : separaCarro.get(StatusVeiculo.ALUGADO)) {
	    		 int m =0;
	    		 JOptionPane.showMessageDialog(null, "Veiculo: "+imprime.getNome()
	    		 									+"\nPlaca: "+imprime.getPlaca()
	    		 									+"\nModelo: "+imprime.getModelo()
	    		 									+"\n"+imprime.getMarca().get(m)
	    		 									+"\nAno: "+imprime.getAno()
	    		 									+"\nValor aluguel: "+imprime.getValor()
	    		 									+"\nCor: "+imprime.getCor()
	    		 									+"\nSituação: "+imprime.AlugaCarro()
	    		 									, "Carros Alugados", 1);
	    	  m++;
	    	 }
	    	}else {
	    		JOptionPane.showMessageDialog(null, "Não existe veiculo alugado ainda!", "Atenção", 0);
	    	}	    	
	    	break;
		case 6:
			if(carros.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não existe veiculo alugado ainda!", "Atenção", 0);
			}else {
			for (Carro carro2 : carros) {
				int i=0;
				JOptionPane.showMessageDialog(null,"Nome: "+carro2.getNome()
				                                 +"\nModelo: "+carro2.getModelo()
				                                 +"\nPlaca: "+carro2.getPlaca()
												 +"\nAno: "+carro2.getAno()
				                                 +"\nValor aluguel: "+carro2.getValor()
				                                 +"\nSituação: "+carro2.AlugaCarro()
				                                 +"\n"+carro2.getMarca().get(i));
												
				i++;
			 }
			}
			break;
		case 7:
			 for (Relatorio report : finan) {
				JOptionPane.showMessageDialog(null, "-----------------------"+"\nCarro: "+report.getCarro()+"\nModelo: "+report.getModelo()+"\nPlaca: "+report.getPlaca()+"\nTotal geral: R$"+report.getValor()+"\n-----------------------", "Baixas", 1);
			}
			break;
		case 8:
			JOptionPane.showMessageDialog(null, "Sistema finalizado!");
			break;

		default:
			 JOptionPane.showMessageDialog(null, "Opção invalida");
			break;
		
		   }
		   
  
     }
  }

}