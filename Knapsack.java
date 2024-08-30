import java.util.*;

public abstract class Knapsack implements K_Interface <Knapsack>{ 

	protected List<Item> items;
	public void setItem(ArrayList <Item> item)
	{
		this.items = (ArrayList<Item>) item.clone();
		capacity = CalculateWeight();
	}
	
	protected int capacity;
	public int getCapacity()
	{
		return capacity;
	}
	
	protected int max_capacity;
	public void set_max_Capacity(int max)
	{
		if(max > 0 )
			max_capacity = max;
		else 
			throw new IllegalArgumentException(String.format("\n\nMax capacity must be greater than 0\nError input: " + max));
	}
	
	public Knapsack()
	{
		items = null;
		capacity = 0;
	}
	
	public Knapsack(List <Item> items, int max_capacity) { 
		this.items = items;
		set_max_Capacity(max_capacity);
	}
	
	 // calculate the sum weight of knapsack.
	@Override
	public int CalculateWeight()
	{
		int total = 0;
		
		for(Item i: items)
		{
			total +=i.getWeight();
		}
		
		return total;
	}
	
	// to calculate the sum value of knapsack.
	@Override
	public int CalculateValue() 
	{
		int total = 0;
		
		for(Item i: items)
		{
			total +=i.getValue();
		}
		
		return total;
	}
	
	// to see if the current knapsack contains duplicate item, true contains; false does not
	@Override
	public boolean aDuplicateCheck (Item item) 
	{	
		if(items.contains(item))
			return true;
		else 
			return false;
	}
	
	// print the solution name, max capacity, items contain and the total value/weight
	@Override
	public void result(String solution, int max_capacity) {
		if(items != null && items.size() > 0) {
			System.out.println("SOLUTION : " + solution + "\n-----------------------------");
			System.out.println("Capacity: "+ CalculateWeight() + "/" + max_capacity + "\n");
			System.out.println("Items: ");
			for (Item item : items) {
				System.out.println("- " + item.ToString());
			}
			System.out.println("Total Values: " + CalculateValue() + "\n\n");
		}
	}	
	
	public abstract void Solve();

}
