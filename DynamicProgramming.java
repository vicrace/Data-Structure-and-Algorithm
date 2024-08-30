import java.util.ArrayList;

public class DynamicProgramming extends Knapsack {

	Item[] items;
	int max_capacity;
	
	public DynamicProgramming(Item[] items, int max_capacity)
	{
		this.items = items;
		this.max_capacity = max_capacity;
	}
	
	public DynamicProgramming()
	{
		super();
	}
	
	@Override
	public void Solve()
	{
		DynamicProgramming knapsack = new DynamicProgramming ();//to store the end result of items list
		
				int numberOfItems = items.length;
				int [][]m = new int[numberOfItems +1][max_capacity+1];
				
				for(int i=0;i<= max_capacity;i++)//base case which initialise first column 0
					m[0][i]=0;
				//we iterate on the items passed in to solve
				for(int i=1;i<=numberOfItems;i++) {
					//we iterate on each capacity for the knapsack
					for(int j=0;j<= max_capacity;j++) {
						if(items[i-1].getWeight()>j)
							m[i][j] = m[i-1][j];
						else
							//find the maximum value at the current rank
							m[i][j] = Math.max(m[i-1][j],m[i-1][j-items[i-1].getWeight()]+items[i-1].getValue());
					}
				}

				int value = m[numberOfItems][max_capacity];
				int weight = max_capacity;
				ArrayList<Item> itemsSolution = new ArrayList<>();
				
				for(int i=numberOfItems;i>0 && value>0;i--) {
					if(value!=m[i-1][weight]) {
						//remove the corresponding weight and value of the item from the matrix
						itemsSolution.add(items[i-1]);
						value -= items[i-1].getValue();
						weight-=items[i-1].getWeight();
					}
				}
						
				knapsack.setItem(itemsSolution);
				knapsack.result("Dynamic Programming", max_capacity);
	}

	@Override
	public int compareTo(Knapsack o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

