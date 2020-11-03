package br.com.hdbinterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import br.com.hdbconnection.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class itf_Login extends JFrame {

    Conexao Conectarusuarios;

    
	private JPanel contentPane;
	private JTextField txt_usuario;
	private JPasswordField txt_senha;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itf_Login frame = new itf_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public itf_Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(itf_Login.class.getResource("/br/com/hdbimages/icon-first.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_login = new JButton("Login");
		btn_login.setForeground(Color.BLACK);
		btn_login.setBackground(Color.BLACK);
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hdb", "root","");
						
	                Statement exec = myConn.createStatement();
						ResultSet consulta = exec.executeQuery("select * from usuarios");
						
					
						while(consulta.next()) {
							String usuario = consulta.getString("usuario");
							String nome = consulta.getString("nome");
							String senha = consulta.getString("senha");
							
							String usuario2 = txt_usuario.getText();
							String senha2 = txt_senha.getText();
							
						if(usuario.equals(usuario2)){
							if(senha.equals(senha2))
							{
								JOptionPane.showMessageDialog(null, "Login efetuado com sucesso, Bem vindo, "+ nome);
								 new itf_Dash().show(); 
							}
						}
						else
						{
					JOptionPane.showMessageDialog(null, "Erro ao realizar o login do usuario. Tente novamente");
				}
	}
						}
					catch (Exception exc) {
						exc.printStackTrace();
					}
				}
			});

				
	
		btn_login.setBounds(313, 208, 87, 23);
		contentPane.add(btn_login);
		
		txt_senha = new JPasswordField();
		txt_senha.setBackground(new Color(204, 255, 255));
		txt_senha.setBounds(198, 162, 113, 19);
		contentPane.add(txt_senha);
		txt_senha.setColumns(10);
		
		JLabel lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setBackground(new Color(204, 255, 255));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_usuario.setBounds(134, 107, 177, 83);
		contentPane.add(lbl_usuario);
		
		txt_usuario = new JTextField();
		txt_usuario.setBackground(new Color(204, 255, 255));
		txt_usuario.setBounds(198, 134, 113, 19);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		JLabel lbl_senha = new JLabel("Senha:");
		lbl_senha.setForeground(new Color(0, 0, 0));
		lbl_senha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_senha.setBounds(134, 135, 193, 74);
		contentPane.add(lbl_senha);
		
		JLabel lbl_boasvindas = new JLabel("Bem-Vindo(a) ao HDB Management Doctor!");
		lbl_boasvindas.setForeground(new Color(0, 0, 0));
		lbl_boasvindas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_boasvindas.setBounds(10, 11, 403, 59);
		contentPane.add(lbl_boasvindas);
		
		JLabel lbl_instrucaodelogin = new JLabel("Faça o login abaixo para entrar no sistema:");
		lbl_instrucaodelogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_instrucaodelogin.setBounds(20, 72, 267, 37);
		contentPane.add(lbl_instrucaodelogin);
		
		JLabel lbl_background = new JLabel("Login[");
		lbl_background.setIcon(new ImageIcon(itf_Login.class.getResource("/br/com/hdbimages/bkg.jpeg")));
		lbl_background.setBounds(0, -25, 449, 307);
		contentPane.add(lbl_background);
	}
}
