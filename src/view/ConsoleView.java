package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ConsoleView extends JFrame {

	private JPanel contentPane;
	private JButton btnEnter;
	private JTextArea txtArea;

	/**
	 * Test View Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsoleView frame = new ConsoleView();
					frame.setTitle("TerminListe 1.0");					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the JFrame.
	 */
	public ConsoleView(String titel) {
		// Konsolen-Aufbau
		setTitle(titel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Helvetica", Font.BOLD, 20));
		txtArea.setLineWrap(true);
		
		// Scrollbalken zur Text-Area
		JScrollPane scrollPane = new JScrollPane(txtArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public JTextArea getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}
}
