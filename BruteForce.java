import java.util.*;

public class BruteForce extends Knapsack {
	
	public BruteForce(List <Item> items, int max_capacity) {
		super(items,max_capacity);
	}
	
	public BruteForce()
	{
		super();
	}
	
	@Override
	public void Solve() 
	{ 	
		// add the possible result into knapsack list
		// find the best fit from all possible sack
		// define a temporary sack and item list
		// count is to calculate the number of possible combination
		BruteForce asack = new BruteForce ();  
		BruteForce bestfit = asack;
		ArrayList <Item> packedItem = new ArrayList <Item>();
		
		// find out all possible combination without filter the weight
		List<List<Item>> aknapsack = possibleComb(items); 

		// insert the possible set of items into knapsack list , take the limitations into account
		//select the best solution among the list
		for (List<Item> a : aknapsack) 
		{

			for (Item b: a)
			{

				packedItem.add(b); 
			}

			asack.setItem(packedItem); 				
			if(asack.CalculateWeight() <= max_capacity && asack.compareTo(bestfit)>0) 
			{
				bestfit = asack;
			}
			
			packedItem.clear(); 
			asack = new BruteForce(); 
		}
		
		bestfit.result("Brute Force",max_capacity);
	}
	
	// to find out all combinations of item and return it if reach the end
	public List<List<Item>> possibleComb (List <Item> items) 
	{
		List <List<Item>> allcomb = new ArrayList <>();
		
		if(items == null || items.size()== 0) {
			return allcomb;
		}
		List<Item> subcomb = new ArrayList <>();
		findAllComb(items,allcomb,subcomb,0);
		
		return allcomb;
	}
	
	// find out each subset of item combination in each iteration.
	private void findAllComb(List <Item> items, List <List<Item>> allcomb, List <Item> subcomb, int srtindex) {
		allcomb.add(new ArrayList<>(subcomb));
		
		for(int i = srtindex; i<items.size(); i++) {
			subcomb.add(items.get(i));
			findAllComb(items,allcomb,subcomb, i+1);
			subcomb.remove(subcomb.size() -1);
		}
	}
	
	@Override
	public int compareTo(Knapsack o) {
		if(this.CalculateValue()<o.CalculateValue())
			return -1;
		else if(this.CalculateValue()==o.CalculateValue())
			return 0;
		else return 1;
	}

}
