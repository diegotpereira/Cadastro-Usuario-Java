package br.com.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.java.UsuarioDao;
import br.com.java.modelo.Usuario;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioGui extends JFrame {
	
	
	private JFrame frame;  
    private JTextField textNome;
	private JTextField textCpf;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JButton btn_salvar;
	private JButton btn_sair;
	private JButton btn_limpar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGui window = new UsuarioGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsuarioGui() {
		
		initialize(); 
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();  
        frame.setBounds(100, 100, 570, 300);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.getContentPane().setLayout(null);
        
        
        JLabel lblNewLabel = new JLabel("Cadastro de Usu\u00E1rios");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(118, 11, 274, 14);
        frame.getContentPane().add(lblNewLabel);
        
        
        JLabel jLabel2 = new JLabel("Nome:");
        jLabel2.setBounds(10, 65, 46, 14);
        frame.getContentPane().add(jLabel2);
        
        JLabel jLabel3 = new JLabel("CPF:");
        jLabel3.setBounds(10, 90, 46, 14);
        frame.getContentPane().add(jLabel3);
        
        JLabel jLabel4 = new JLabel("Email:");
        jLabel4.setBounds(10, 115, 80, 14);
        frame.getContentPane().add(jLabel4);
        
        JLabel jLabel5 = new JLabel("Telefone:");
        jLabel5.setBounds(10, 140, 96, 14);
        frame.getContentPane().add(jLabel5);
        
        textNome = new JTextField();
        textNome.setBounds(167, 65, 147, 20);
        frame.getContentPane().add(textNome);
        textNome.setColumns(10);
        
        textCpf = new JTextField();
        textCpf.setBounds(167, 90, 147, 20);
        frame.getContentPane().add(textCpf);
        textCpf.setColumns(10);
        
        textEmail = new JTextField();
        textEmail.setBounds(167, 115, 147, 20);
        frame.getContentPane().add(textEmail);
        textEmail.setColumns(10);
        
        textTelefone = new JTextField();
        textTelefone.setBounds(167, 140, 147, 20);
        frame.getContentPane().add(textTelefone);
        textTelefone.setColumns(10);
        
        JButton btn_salvar = new JButton("Cadastrar");
        btn_salvar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Usuario usuarios = new Usuario();
        		usuarios.setNome(textNome.getText());
        		usuarios.setCpf(textCpf.getText());
        		usuarios.setEmail(textEmail.getText());
        		usuarios.setTelefone(textTelefone.getText());
        		
        		// fazendo a validação dos dados
        		if ((textNome.getText().isEmpty()) || (textCpf.getText().isEmpty()) || (textEmail.getText().isEmpty()) || (textTelefone.getText().isEmpty())){
        			JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
        			
				} else {
					
					// instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
					UsuarioDao dao  = new UsuarioDao();
					dao.adicionar(usuarios);
					
					JOptionPane.showMessageDialog(null, "Usuário" + textNome.getText() + "Inserido com sucesso");
				}
        	}
        });
        btn_salvar.setBounds(81, 190, 89, 23);
        frame.getContentPane().add(btn_salvar);
        
        JButton btn_limpar = new JButton("Limpar");
        btn_limpar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		textNome.setText("");
        		textCpf.setText("");
        		textEmail.setText("");
        		textTelefone.setText("");
        	}
        });
        btn_limpar.setBounds(208, 190, 89, 23);
        frame.getContentPane().add(btn_limpar);
        
        JButton btn_sair = new JButton("Sair");
        btn_sair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btn_sair.setBounds(327, 190, 89, 23);
        frame.getContentPane().add(btn_sair);
        
        
		
	}
}
