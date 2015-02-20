import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;


public class DigitalClockGUI extends JFrame {


	private ClockLogic clockLogic;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_5;
	
	private JTextField textField_4= new JTextField();
	//private JTextField txtW;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
					frame.setVisible(true);
					//frame.setDefaultCloseOperation();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DigitalClockGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/victoria/Downloads/clock-3_318-11629.jpg"));
		setTitle("MORNING");
		
		clockLogic= new ClockLogic(this);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setFont(new Font("Serif", Font.ITALIC, 22));
		lblHour.setBounds(16, 19, 76, 23);
		contentPane.add(lblHour);
		
		textField = new JTextField();
		textField.setBounds(114, 17, 101, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMinute = new JLabel("Minute");
		lblMinute.setFont(new Font("Serif", Font.ITALIC, 22));
		lblMinute.setBounds(16, 68, 76, 23);
		contentPane.add(lblMinute);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 66, 101, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSetAlatm = new JButton("Set alarm");
		btnSetAlatm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.setAlarm(Integer.parseInt(textField.getText()) , Integer.parseInt(textField_1.getText()));
				//textField_4.setText(t);
				textField_4.setText(textField.getText() +":" + textField_1.getText());
				
				
			}
		});
		btnSetAlatm.setFont(new Font("Serif", Font.ITALIC, 16));
		btnSetAlatm.setBounds(16, 111, 110, 28);
		contentPane.add(btnSetAlatm);
		
		JButton btnClearAlarm = new JButton("Clear alarm");
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.clearAlarm();
				textField.setText(" ");
				textField_1.setText(" ");
				textField_4.setText(" ");
				textField_5.setText(" ");
			}
		});
		btnClearAlarm.setBackground(Color.GRAY);
		btnClearAlarm.setFont(new Font("Serif", Font.ITALIC, 16));
		btnClearAlarm.setBounds(124, 113, 110, 25);
		contentPane.add(btnClearAlarm);
		
		textField_3 = new JTextField();
		textField_3.setBounds(37, 169, 134, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);	
		
		
		textField_4.setBounds(270, 43, 134, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAlarmTid = new JLabel("Alarm Tid");
		lblAlarmTid.setBounds(296, 23, 61, 16);
		contentPane.add(lblAlarmTid);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("SansSerif", Font.PLAIN, 48));
		textField_5.setBounds(16, 202, 218, 70);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Helvetica", Font.ITALIC, 14));
		lblNewLabel.setIcon(new ImageIcon("/Users/victoria/Downloads/___good_morning____by_rare_pearl-d5b5f8f.jpg"));
		lblNewLabel.setBounds(0, 0, 464, 278);
		contentPane.add(lblNewLabel);
		
		
	}
	
	public void setTimeOnLabel (String time){
		textField_3.setText(time);
	}
	

	
	
}

