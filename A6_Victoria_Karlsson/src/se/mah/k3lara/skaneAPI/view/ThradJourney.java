package se.mah.k3lara.skaneAPI.view;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;


public class ThradJourney extends Thread {

	private Parser par;
	private SkanetrafikenGUI gui;

	public ThradJourney (Parser p, SkanetrafikenGUI g){
		this.par = p;
		this.gui = g;
	}

	public void run(){
		
		String searchURL = Constants.getURL(gui.txtFrn.getText() + "",
				gui.txtTill.getText(), 1);

		Journeys journeys = Parser.getJourneys(searchURL);


		gui.textArea_1.setText(null);

		for (Journey journey : journeys.getJourneys()) {
			gui.textArea_1.append(journey.getStartStation() + " - "
					+ journey.getEndStation());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
					+ ":" + journey.getDepDateTime().get(Calendar.MINUTE);
			gui.textArea_1.append("\n Departs " + time+ "\n" + " that is in "
					+ journey.getTimeToDeparture() + " minutes.\n And it is "
					+ journey.getDepTimeDeviation() + " min late");

		}
	}


	}
