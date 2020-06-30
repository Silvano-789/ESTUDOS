package escola.modulo10.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import escola.modulo10.funcoes.FuncaoAutenticao;
import escola.modulo10.objetos.Secretario;
import escola.modulo10.sistema.Sistema;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
    private JPanel painel = new JPanel(new GridBagLayout());
    
    private JLabel descNome = new JLabel("Usuario");
    private JTextField nome = new JTextField();
    
    private JLabel descEmail = new JLabel("Senha");
    private JPasswordField senha = new JPasswordField();
    
    private JButton logar = new JButton("Entrar");
    private JButton cancelar = new JButton("Cancelar");
	
   public Login() {
	   /*construção da tela*/
		setTitle("Login");
		setSize(240, 240);
		setLocationRelativeTo(null);
		//setResizable(false);
		
		
		/*controlador de componentes*/
		GridBagConstraints tabela = new GridBagConstraints();
		tabela.gridx = 0;
		tabela.gridy = 0;
		tabela.gridwidth = 2;
		tabela.insets = new Insets(5, 10, 5, 5);
		
		
/******************* Campos de textos e descrição ***********************/		
		
		/*Ajusta componentes no painel*/
		descNome.setPreferredSize(new Dimension(200,25));
		/*adiciona componente no painel com controlador*/
		painel.add(descNome, tabela);
		nome.setPreferredSize(new Dimension(200, 25));
		tabela.gridy ++;
		painel.add(nome, tabela);
		
/****************************** DIVIDE COMPONENTES ******************************/	
		
		descEmail.setPreferredSize(new Dimension(200,25));
       tabela.gridy ++;
		/*adiciona componente no painel com controlador*/
		painel.add(descEmail, tabela);
		senha.setPreferredSize(new Dimension(200, 25));
		tabela.gridy ++;
		painel.add(senha, tabela);
/*************************** fim campos ********************************/		
		
/******************************Acões dos Botões *********************************/	
		/*ação do botão add*/
		
		logar.addActionListener(new ActionListener() {			
		    @SuppressWarnings({ "unlikely-arg-type", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {
				int cont=0;
				if(nome.getText().isEmpty() || senha.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null, "Existe campos vazio!", "Atenção", 0);
				}else {
			      Sistema s = new Sistema();
			      if(new FuncaoAutenticao(new Secretario(nome.getText(), senha.getText())).autenticarUsuario()) {
			    	  dispose();	
			    	  s.Menu();
			           
			    	}else {
			    		JOptionPane.showMessageDialog(null, "Usuario ou senha invalido!", "Atenção", 0);
			    		cont++;
			    	}
			      
				  }
			     if(cont == 3) {
			    	 JOptionPane.showMessageDialog(null, cont+" Tentativas erradas \nSistema será fechado por segurança!", "Erro Usuario ou Senha", 0);
			    	 System.exit(0);
			     }
				}		
			}
		);		
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
				
			}
		});
				
/*****************************  Fim acões dos Botoes ****************************/	
		
/***************************** Inicio dos Botões ***********************************/
		tabela.gridwidth = 1;
		logar.setPreferredSize(new Dimension(92, 25));
		tabela.gridy++;
		painel.add(logar,tabela);
		
		cancelar.setPreferredSize(new Dimension(92, 25));
		tabela.gridx++;
		painel.add(cancelar,tabela);
/******************************** Fim dos botões *****************************/
		/*mostra painel na tela*/
		add(painel, BorderLayout.WEST);
		/*Mostra a tela ao usuario*/
		setVisible(true);
  }
}