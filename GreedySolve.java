import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GreedySolve extends Knapsack {
	
	public GreedySolve(List <Item> items, int max_capacity) {
		super(items,max_capacity);
	}
	
	public GreedySolve() {
		super();
	}

	@Override
	public void Solve() {
		// Compute the ratio of value to weight of each item and store as density
		// Sort the items according to their density
		// Arrange items from largest density to lowest density
		// Store the sorted items into arrayList
		ArrayList <Item> newList = new ArrayList<Item>();
		GreedySolve knapsack = new GreedySolve();
		knapsack.setItem(newList);
		
		items = Arrangement();
		// Pick the largest value of density that does not exceed the knapsack capacity
		for(Item z: items)
		{
			if(z.getWeight() <= max_capacity - knapsack.getCapacity() && !knapsack.aDuplicateCheck(z))
			{
				newList.add(z);
				knapsack.setItem(newList);
			}
		}
		
		//Display the knapsack result
		knapsack.result("Greedy",max_capacity);	
	}
	//calculate density for each item
	// Sorting the items by density using selection sort and 
	public ArrayList<Item> Arrangement()
	{
		int i,j,pos;
		Item max, temp;
		
		for(Item itm:items) {
			float density = (float) itm.getValue()/itm.getWeight();
			itm.setDensity(density);
		}
		
		for(i = 0;i<items.size();i++ ) {
			max = items.get(i);
			pos = i;
			
			for(j = i;j<items.size();j++) {
				max= max.compareTo(items.get(j))<0?items.get(j):max;
				if(max.getDensity()==items.get(j).getDensity()) {
					
					pos = j;
				}
			}
			temp = items.get(i);
			items.set(i, max);
			items.set(pos, temp);
			
		}
		
		
		
		return new ArrayList<Item>(items);
	}

	

	@Override
	public int compareTo(Knapsack o) {
		// TODO Auto-generated method stub
		return 0;
	}
}