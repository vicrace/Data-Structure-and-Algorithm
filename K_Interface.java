import java.util.List;

public interface K_Interface <E> extends Comparable <E>{
	// calculate weight of items in current sack
	public int CalculateWeight();
	
	// calculate total value of items in current sack
	public int CalculateValue();
	
	// to check if the current sack contains duplicate item
	public boolean aDuplicateCheck(Item item);
	
	// to print the best knapsack for each solution
	public void result(String solution, int max_capacity);

}
