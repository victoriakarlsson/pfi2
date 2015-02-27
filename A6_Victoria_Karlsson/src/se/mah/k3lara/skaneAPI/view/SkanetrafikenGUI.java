package se.mah.k3lara.skaneAPI.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SkanetrafikenGUI extends JFrame {

	private JPanel contentPane;
	JTextField txtSk = new JTextField();
	JTextField txtTill = new JTextField();
	JTextField txtFrn = new JTextField();
	private Parser p = new Parser();
	JTextArea textArea = new JTextArea();
	Thread T = new ThradJourney( p, this);
	Thread T2 = new ThreadStation(p,this);
	SkanetrafikenGUI gui = this;
	JTextArea textArea_1 = new JTextArea();
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkanetrafikenGUI frame = new SkanetrafikenGUI();
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
	public SkanetrafikenGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 28, 211, 233);
		contentPane.add(panel);
		panel.setLayout(null);

		
		txtSk.setBounds(6, 4, 134, 28);
		txtSk.setText("Sök");
		panel.add(txtSk);
		txtSk.setColumns(10);

		
		textArea.setBounds(6, 44, 188, 113);
		panel.add(textArea);

		JButton btnSk = new JButton("Sök");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textArea.setText("söker\n");
				Thread T2 = new ThreadStation(p,SkanetrafikenGUI.this );
				T2.start();
				
			/**	searchStation.addAll(Parser.getStationsFromURL(txtSk.getText()));
				for (Station s : searchStation) {
					textArea.append(s.getStationName() + " number:"
							+ s.getStationNbr() + "\n");
				}*/

			}
		});
		
		btnSk.setBounds(137, 5, 75, 29);
		panel.add(btnSk);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(229, 28, 211, 233);
		contentPane.add(panel_1);

		txtTill = new JTextField();
		txtTill.setText("Till");
		txtTill.setColumns(10);
		txtTill.setBounds(6, 4, 134, 28);
		panel_1.add(txtTill);
		

		txtFrn = new JTextField();
		txtFrn.setText("Från");
		txtFrn.setBounds(6, 37, 134, 28);
		panel_1.add(txtFrn);
		txtFrn.setColumns(10);

	
		textArea_1.setBounds(6, 77, 188, 113);
		panel_1.add(textArea_1);

		JButton button = new JButton("Sök");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
				Thread T = new ThradJourney(p, SkanetrafikenGUI.this);
				T.start();

			/**	String searchURL = Constants.getURL(txtFrn.getText() + "",
						txtTill.getText(), 1);
			
				Journeys journeys = Parser.getJourneys(searchURL);

				
				textArea_1.setText(null);
				
				for (Journey journey : journeys.getJourneys()) {
					textArea_1.append(journey.getStartStation() + " - "
							+ journey.getEndStation());
					String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
							+ ":" + journey.getDepDateTime().get(Calendar.MINUTE);
					textArea_1.append(" Departs " + time + " that is in "
							+ journey.getTimeToDeparture() + " minutes. And it is "
							+ journey.getDepTimeDeviation() + " min late");
				

				}*/

			}
		});
		button.setBounds(137, 5, 75, 29);
		panel_1.add(button);

	}
}
