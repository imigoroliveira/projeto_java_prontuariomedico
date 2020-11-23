package br.com.hdbinterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class itf_Dash extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itf_Dash frame = new itf_Dash();
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
	public itf_Dash() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(itf_Dash.class.getResource("/br/com/hdbimages/icon-first.png")));
		getContentPane().setBackground(new Color(30, 144, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 336);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Prontuario");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Manutenção");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new itf_Prontuario().show();
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("Pacientes");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Manutenção");
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel_1 = new JLabel("-------------------------------------------------------------------------");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.WHITE);
		menuBar.add(lblNewLabel_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sair");
		menuBar.add(mntmNewMenuItem_2);
	}
}
