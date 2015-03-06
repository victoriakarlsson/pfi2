package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import java.awt.Font;
import java.awt.Color;

public class SkaneTrafikenGUI extends JFrame {

	private JPanel contentPane;
	static private Parser p = new Parser();
	//static Thread T = new ThreadLine( p);
	public JTextArea textArea = new JTextArea();
	public JTextArea textArea_1 = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkaneTrafikenGUI frame = new SkaneTrafikenGUI();
					frame.setVisible(true);
				//Thread T = new ThreadLine (p);
					//T.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SkaneTrafikenGUI() {
		Thread t = new ThreadLine(p);
		t.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLine = new JLabel("Line");
		lblLine.setForeground(Color.WHITE);
		lblLine.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblLine.setBounds(30, 47, 61, 16);
		contentPane.add(lblLine);
		
		JLabel lblNewLabel = new JLabel("Destination");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblNewLabel.setBounds(121, 47, 124, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAvgng = new JLabel("Avgår");
		lblAvgng.setForeground(Color.WHITE);
		lblAvgng.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblAvgng.setBounds(336, 39, 61, 33);
		contentPane.add(lblAvgng);
		
		JLabel lblDelays = new JLabel("Delays");
		lblDelays.setForeground(Color.WHITE);
		lblDelays.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblDelays.setBounds(476, 45, 61, 21);
		contentPane.add(lblDelays);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.ORANGE);
		
	
		textArea.setBounds(26, 75, 201, 175);
		contentPane.add(textArea);
		textArea_1.setBackground(Color.BLACK);
		textArea_1.setForeground(Color.ORANGE);
	
		textArea_1.setBounds(336, 75, 201, 175);
		contentPane.add(textArea_1);
	}
	
	public class ThreadLine extends Thread{

		private Parser par;
		//private SkaneTrafikenGUI gui;	
		public ThreadLine (Parser p){
			this.par = p;
			
		}
		public void run(){		

			//while (ThreadLine) {
			//	try {
			//	System.out.println("hejsan start thread");
			//	c = Calendar.getInstance();
				
			//	SkaneTrafikenGUI.update(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
			//	Thread.sleep(54000);
				
			//	} catch (Exception e) {
			//		System.out.println(" thread");
			//		e.printStackTrace();
			//	}	
		//	}
	//	}
		
		System.out.println("// Busses departing from Ub�tshallen stationsnummer 80046 ");
		Lines lines = Parser.getStationResults(new Station("80046"));
		for (Line l : lines.getLines()) {
			textArea.append( l.getLine() +" " +  l.getDestination() + "\n");
		}
		
		System.out.println("// Busses departing from Ub�tshallen stationsnummer 80046 ");
		Lines lines1 = Parser.getStationResults(new Station("80046"));
		for (Line l : lines1.getLines()) {
			textArea_1.append(l.getDepTime().get(Calendar.HOUR_OF_DAY)+":"+l.getDepTime().get(Calendar.MINUTE)+
					" and is "+l.getDepTimeDeviation()+" minutes late"+ "\n" );
		}
		
		
		}
		
		
		
	}
		
	
	
}
