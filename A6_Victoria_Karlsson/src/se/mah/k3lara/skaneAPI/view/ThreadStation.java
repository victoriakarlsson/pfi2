
package se.mah.k3lara.skaneAPI.view;
import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;


public class ThreadStation extends Thread{

	private Parser par;
	private SkanetrafikenGUI gui;
	
	
	public ThreadStation (Parser p, SkanetrafikenGUI g){
		this.par = p;
		this.gui = g;
	}
	public void run(){
	
		
		ArrayList<Station> searchStation = new ArrayList<Station>();
System.out.println("hej");
		
		searchStation.addAll(Parser.getStationsFromURL(gui.txtSk.getText()));
		System.out.println(Parser.getStationsFromURL(gui.txtSk.getText()));
	for (Station s : searchStation) {
		System.out.println("loopar");
		gui.textArea.append(s.getStationName() + " number:"
				+ s.getStationNbr() + "\n");
		
	}
	}
}	
