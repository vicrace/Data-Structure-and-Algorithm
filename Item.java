public class Item implements Comparable<Item>{

	private String name;
	public String getName() {
		return name;
	}
	
	public void setName(String newName){
		if(newName.matches("^[ A-Za-z]+$") && newName != "" ) {
			this.name = newName;
		}
		else
			throw new IllegalArgumentException(String.format("\n\nItem name must consist at least 1 letter and letters only\nError input: " + newName));
	}
	
	private int weight;
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int newWeight) {
		if(newWeight > 0) {
			this.weight = newWeight;
		}
		else
			throw new IllegalArgumentException(String.format("\n\nItem weight must be greater than 0\nError input: " + newWeight));
	}
	
	private int value;
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int newValue) {
		if(newValue > 0) {
			this.value = newValue;
		}
		else
			throw new IllegalArgumentException(String.format("\n\nItem value must be greater than 0\nError input: " + newValue));
	}

	private float density;
	public float getDensity(){
		return density;
	}
	
	public void setDensity(float density){
		this.density = density;
	}
	
	public Item(String name, int weight, int value) {
		setName(name);
		setWeight(weight);
		setValue(value);
		
	}
	
	public String ToString() {
		return name + "\t\tWeight = " + weight + "\tValue = " + value;
	}
	
	@Override
	public int compareTo(Item o) {
		if((this.density>o.getDensity()))
			return 1;
		else if(this.density==o.getDensity())
			return 0;
		else return -1;
	}
}



