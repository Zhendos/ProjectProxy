package org.bot.frame;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bot.proxyserver.ProxyServer;



public class MainFrame {
	private ProxyServer ps;
	
	
	
	public static void main(String[] args){
		
		
		
		
		JFrame frame = new JFrame("Opties");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);


		
		/**
		 * 
		 * Button met actie.
		 * 
		 */
		JButton button = new JButton("Klik hier!");
		button.setBounds(5,5,5,5);
		button.addActionListener(new ButtonActie());
		panel.add(button);
		
		/**
		 * 
		 * TextField 1 voor Proxy IP
		 * 
		 */
		
		JTextField pf = new JTextField(5);
		pf.setSize(100, 100);
		panel.add(pf);
	
		frame.add(panel);
		
	}
	
	/**
	 * 
	 * Button actie
	 * @author youri
	 *
	 */
	static class ButtonActie implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ProxyServer.Proxy();
				ProxyServer.class.
			} catch(Exception e1){
				System.out.println("Kan vanuit de MainFrame niet de Proxy method starten in");
				e1.printStackTrace();
			}
	
		} 
		
	}

}
