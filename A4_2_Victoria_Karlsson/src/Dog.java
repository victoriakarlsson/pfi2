
public class Dog extends Mammal  {
	
	
	private boolean stupid;
	
	public Dog ( String latinName, int gestationTime, boolean stupid){
		super(latinName, gestationTime);
		this.stupid = stupid;
		
		
	}
	
	public Dog ( String latinName, int gestationTime, boolean stupid, String friendlyName){
		super(latinName, gestationTime);
		this.stupid = stupid;
		super.setFriendlyName(friendlyName);
		
	}
	
	public boolean isStupid ( ){
		return stupid;
	
	}

	@Override
	public String getInfo() {
		String stupid = "is stupid" ;
		String notStupid = "is not stupid";
		
		String info = "The Dog, " + this.getLatinName() + " called " + getFriendlyName()  + ", has the gestation time  "+ this.getGestationTime() +" days " + "and " ;
		if (isStupid() == true){
			return info + stupid;
			
		}else{
			
		return info + notStupid;
		
	}
	
	}
		
	

}
