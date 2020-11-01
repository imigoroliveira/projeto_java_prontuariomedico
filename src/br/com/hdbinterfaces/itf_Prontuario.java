package br.com.hdbinterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.hdbconnection.Conexao;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class itf_Prontuario extends JFrame {

	  Conexao ListarProntuarios;
	   int TratamentoNavegacao = 0;
      
	private JPanel contentPane;
	private JTextField txt_numerodoprontuario;
	private JTextField txt_datadeabertura;
	private JLabel lblNomeDoPaciente;
	private JTextField txt_nomedopaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itf_Prontuario frame = new itf_Prontuario();
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
	public itf_Prontuario() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numéro do Prontuário:");
		lblNewLabel.setBounds(10, 34, 137, 45);
		contentPane.add(lblNewLabel);
		
		txt_numerodoprontuario = new JTextField();
		txt_numerodoprontuario.setBounds(131, 46, 122, 20);
		contentPane.add(txt_numerodoprontuario);
		txt_numerodoprontuario.setColumns(10);
		
		JLabel lblDataDeAbertura = new JLabel("Data de Abertura:");
		lblDataDeAbertura.setBounds(10, 65, 147, 45);
		contentPane.add(lblDataDeAbertura);
		
		txt_datadeabertura = new JTextField();
		txt_datadeabertura.setColumns(10);
		txt_datadeabertura.setBounds(131, 77, 122, 20);
		contentPane.add(txt_datadeabertura);
		
		lblNomeDoPaciente = new JLabel("Nome do Paciente:");
		lblNomeDoPaciente.setBounds(10, 96, 137, 45);
		contentPane.add(lblNomeDoPaciente);
		
		txt_nomedopaciente = new JTextField();
		txt_nomedopaciente.setColumns(10);
		txt_nomedopaciente.setBounds(131, 108, 122, 20);
		contentPane.add(txt_nomedopaciente);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setIcon(new ImageIcon(itf_Prontuario.class.getResource("/br/com/hdbimages/ico_salvar.png")));
		btnNewButton.setBounds(10, 263, 111, 39);
		contentPane.add(btnNewButton);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(itf_Prontuario.class.getResource("/br/com/hdbimages/ico_update.png")));
		btnAlterar.setBounds(159, 264, 111, 39);
		contentPane.add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon(itf_Prontuario.class.getResource("/br/com/hdbimages/ico_apagar.png")));
		btnDeletar.setBounds(159, 314, 111, 39);
		contentPane.add(btnDeletar);
		
		JButton btnLimparCampos = new JButton("Limpar ");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimparCampos.setBounds(10, 313, 111, 39);
		contentPane.add(btnLimparCampos);
	
	
		ListarProntuarios = new Conexao();
	      
		ListarProntuarios.Conectar();
	      
		ListarProntuarios.ExecutarSQL("SELECT * from prontuarios");
		 try {
	            
	           
			 ListarProntuarios.VarResultset.first();

	                txt_numerodoprontuario.setText(ListarProntuarios.VarResultset.getString("Num_Prontuario"));
	                txt_datadeabertura.setText(ListarProntuarios.VarResultset.getString("DataAbertura_Prontuario"));
	              txt_nomedopaciente.setText(ListarProntuarios.VarResultset.getString("NomePaciente_Prontuario"));
	              
	              JButton btn_inicio = new JButton("");
	              btn_inicio.addActionListener(new ActionListener() {
	              	public void actionPerformed(ActionEvent e) {
	              	   try {
	              		   
	              		 ListarProntuarios.VarResultset.first();
	                     MostrarDadosBotoes();
	           			 } 
	              	   catch (SQLException VarErro4) {

	                       JOptionPane.showMessageDialog(null, "Erro ao conectar ao BD: " + VarErro4);

	                   }
	              		
	              	}
	              });
	              btn_inicio.setIcon(new ImageIcon(itf_Prontuario.class.getResource("/br/com/hdbimages/ico_inicio.png")));
	              btn_inicio.setBounds(307, 264, 49, 39);
	              contentPane.add(btn_inicio);
	              
	              JButton btn_anterior = new JButton("");
	              btn_anterior.addActionListener(new ActionListener() {
	              	public void actionPerformed(ActionEvent e) {
	              		try {
                  ListarProntuarios.VarResultset.previous();
	                        MostrarDadosBotoes();
	            		TratamentoNavegacao = 1;	
	            			
	                    } catch (SQLException VarErro4) {

	                        JOptionPane.showMessageDialog(null, "Erro ao conectar ao BD: " + VarErro4);

	                    }
	                    
	                }                                        

	              	}
	              );
	              btn_anterior.setIcon(new ImageIcon(itf_Prontuario.class.getResource("/br/com/hdbimages/ico_voltar.png")));
	              btn_anterior.setBounds(366, 264, 49, 39);
	              contentPane.add(btn_anterior);
	              
	              JButton btn_proximo = new JButton("");
	              btn_proximo.addActionListener(new ActionListener() {
	              	public void actionPerformed(ActionEvent e) {
	                    try {
	                       ListarProntuarios.VarResultset.next();
	                        MostrarDadosBotoes();
	            		TratamentoNavegacao = 2;	
	            		} 
	                    catch (SQLException VarErro4) {

	                        JOptionPane.showMessageDialog(null, "Erro ao conectar ao BD: " + VarErro4);

	                    }
	                    
	                    
	                }                                        

	                private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	                    // TODO add your handling code here:
	                    try {
ListarProntuarios.VarResultset.last();
	                        MostrarDadosBotoes();
	            		TratamentoNavegacao = 3;	
	                    } catch (SQLException VarErro4) {

	                        JOptionPane.showMessageDialog(null, "Erro ao conectar ao BD: " + VarErro4);

	                    }
	                    
	              	}
	              });
	              btn_proximo.setIcon(new ImageIcon(itf_Prontuario.class.getResource("/br/com/hdbimages/ico_avancar.png")));
	              btn_proximo.setBounds(428, 264, 49, 39);
	              contentPane.add(btn_proximo);
	              
	              JButton btn_ultimo = new JButton("");
	              btn_ultimo.addActionListener(new ActionListener() {
	              	public void actionPerformed(ActionEvent e) {
	              	     try {
	              	    ListarProntuarios.VarResultset.last();
	                    MostrarDadosBotoes();
	             		TratamentoNavegacao = 3;	
	             		}
	              	     catch (SQLException VarErro4) {

	                         JOptionPane.showMessageDialog(null, "Erro ao conectar ao BD: " + VarErro4);

	                     }
	              	}
	              });
	              btn_ultimo.setIcon(new ImageIcon(itf_Prontuario.class.getResource("/br/com/hdbimages/ico_final.png")));
	              btn_ultimo.setBounds(487, 264, 49, 39);
	              contentPane.add(btn_ultimo);
	      }
		 catch (SQLException VarErro4) {
	            
	        JOptionPane.showMessageDialog(null, "Erro ao conectar ao BD: " + VarErro4);
	            
	        }

	                try {
			
	            ListarProntuarios.VarResultset.first();
				//Inicia o método 
//	            MostrarDadosBotoes();
				
	        } catch (SQLException VarErro4) {
	            JOptionPane.showMessageDialog(null, "Erro ao conectar ao BD: " + VarErro4);

	        }
	    }
		
	
	 public void MostrarDadosBotoes() {

	        try {

	        	txt_numerodoprontuario.setText(ListarProntuarios.VarResultset.getString("Num_Prontuario"));
	               txt_datadeabertura.setText(ListarProntuarios.VarResultset.getString("DataAbertura_Prontuario"));
	               txt_nomedopaciente.setText(ListarProntuarios.VarResultset.getString("NomePaciente_Prontuario"));


	        } catch (SQLException VarErro4) {

	            if (TratamentoNavegacao == 1) {
	                JOptionPane.showMessageDialog(null, "Você esta no primeiro registro!");
	            } else if (TratamentoNavegacao == 2) {
	                JOptionPane.showMessageDialog(null, "Você esta no último registro!");
	            } else {
	                JOptionPane.showMessageDialog(null, "Erro ao conectar ao BD: " + VarErro4);
	            }
	            TratamentoNavegacao = 0;
	        }


	    }
	}



