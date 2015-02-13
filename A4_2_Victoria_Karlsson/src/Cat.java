
public class Cat extends Mammal {
	
	private int numbersOfLifes;
	
	
	public Cat (String latinName, int gestationTime, int numbersOfLifes){
		super(latinName, gestationTime );
		this.numbersOfLifes = numbersOfLifes;
	}
	
	public int getNumbersOfLifes(){
		return numbersOfLifes;
	}
	
	public int setNumbersOfLifes( int i){
		return i ; 
		
	}

	@Override
	public String getInfo() {
		String info = "The Cat, " + this.getLatinName() +" " + getFriendlyName() +  " has the gestationtime " + this.getGestationTime() +" days and has " + numbersOfLifes+ " lifes ";
		return info;
	}


}
