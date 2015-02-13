import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AnimalGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalGUI frame = new AnimalGUI();
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
	public AnimalGUI() {

		Cat cat = new Cat("Felis catus", 30, 2);
		cat.setFriendlyName("katten");
		Cat cat_1 = new Cat("Felis catus", 50, 2);
		cat_1.setFriendlyName("Sigge");
		Cat cat_2 = new Cat("Felis catus", 40, 2);
		cat_2.setFriendlyName("Blixten");
		
		
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog("Canis lupus domesticus", 60, false, "per" ));// index0
		animals.add(new Snake("Anguis", true)); // index 1
		animals.add(cat);
		animals.add(new Dog("Canis lupus domesticus", 64, true, "lillen" ));
		animals.add(cat_1);
		animals.add(new Dog("Canis lupus domesticus", 60, false , "hundis " ));// index0
		animals.add(new Snake("Anguis", true)); // index 1
		animals.add(new Snake("Anguis", false ));// index0
		animals.add(cat_2);
		animals.add(new Snake("Anguis", true)); // index 1
	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 43, 314, 198);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		for (int i = 0; i < animals.size(); i++) {
			textArea.append(animals.get(i).getInfo() + "\n");
		}
	}
}
