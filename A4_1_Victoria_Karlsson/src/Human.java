
public class Human {

	private Dog dog;
	private String name;
	private String errorText;

	
	
	public Human ( String name){
		if (name.length() > 3){
			this.name = name; 
		}else{
			this.errorText="för kort namn!!";
	
		}
		
	}
	public String getName(){
		return this.name; 
		
	}
	public String getError(){
		return this.errorText; 
		
	}
	
	public Dog buyDog (Dog dog){
		
		return this.dog = dog; 
		
		
	}
	public String getInfo(){
		return getName() + " äger en hund som heter " + dog.getName() ;
	
		
	}
}
