import java.util.Calendar;
import java.util.GregorianCalendar;


public class ClockLogic implements ClockInterface{
	
	public String time= "";
	private DigitalClockGUI clockGUI;
	private int alarmMinute;
	private int alarmHour;
	public String setAlarm;
	
	
	public ClockLogic (DigitalClockGUI clockIn){
		this.clockGUI = clockIn;
		Thread t = new ClockThread(this);
		t.start();
	}

	public void setAlarm(int hours, int minutes){
		this.alarmMinute = minutes;
		this.alarmHour = hours;
	}
	
	public void clearAlarm(){
		this.alarmHour = 0;
		this.alarmMinute = 0;
		
	}

	@Override
	public void update(int hours, int minutes, int seconds) {
//		
//		Calendar cal = new GregorianCalendar();
//		hours=cal.get(Calendar.HOUR_OF_DAY);
//		minutes=cal.get(Calendar.MINUTE);
//		seconds = cal.get(Calendar.SECOND);
//		
		//this.time = DigitalClockGUI.textField_3.getText();
		System.out.println("updating");
	
		
		//clockGUI.textField_3.setText( hours+":" + minutes+":"+ seconds);
		
		String time = "";
		time += Integer.toString(hours);
		time += ":";
		time += Integer.toString(minutes);
		time += ":";
		time += Integer.toString(seconds);
		clockGUI.setTimeOnLabel(time);
		
		if (alarmHour == hours && alarmMinute == minutes){
			System.out.println("alarm");
			clockGUI.textField_5.setText("Wake up");
			
		}
		
		clockGUI.setTimeOnLabel(addzero(hours) + ":" + (addzero(minutes) + ":" + (addzero(seconds))));
		
		}

		private String addzero(int i){
		String s = String.valueOf(i);
		if (s.length() == 1){
			s = "0" + s;
		}
		return s;
		
		
		
		
	}
	public String getTime(){
		return time;
		
	}
	
	//public void getClockGUI(DigitalClockGUI clockGUI){
		//this.clockGUI = clockGUI;
	//}
	//public void setClockGUI ( DigitalClockGUI clockGUI){
	//	this.clockGUI = clockGUI ; 
	//}
}
