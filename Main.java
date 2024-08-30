import java.util.*;


public class Assignment {
	public static void main (String [] args)
	{
		int max_capacity = 15;
		
		//test case 1 for value input, value <= 0 are not allowed. Ant repellent value are set to '0'
		//tem[] items = {new Item("Ant Repellent",1,0),new Item("Blanket",4,3),new Item("Brownies",3,10),new Item("Frisbese",1,6),new Item("Salad",5,4),new Item("Watermelon",10,10)};
		
		//test case 2 for weight input, value <= 0 are not allowed. Ant repellent weight are set to '0'
		//Item[] items = {new Item("Ant Repellent",0,2),new Item("Blanket",4,3),new Item("Brownies",3,10),new Item("Frisbese",1,6),new Item("Salad",5,4),new Item("Watermelon",10,10)};
		
		// MAJOR TEST CASE - test case 3 for duplication - 2 watermelon item.
		Item[] items = {new Item("Ant Repellent",1,2),new Item("Blanket",4,3),new Item("Brownies",3,10),new Item("Frisbese",1,6),new Item("Salad",5,4),new Item("Watermelon",10,10),new Item("Watermelon",10,10)};
		Item[] item = removeDuplicate(items);
		
		GreedySolve asolution = new GreedySolve(Arrays.asList(item),max_capacity);
		asolution.Solve();
		
		BruteForce bsolution = new BruteForce(Arrays.asList(item),max_capacity);
		bsolution.Solve();
		
		DynamicProgramming csolution = new DynamicProgramming(item, max_capacity);
		csolution.Solve();
		

	}
	
	public static Item[] removeDuplicate(Item [] items) { // to validate there is no duplicate items if user input .
		boolean [] isSame = new boolean[items.length];
		isSame[0] = false;
		for(int i = 0;i<items.length-1;i++) {
			Item current = items[i];
			
			for(int j = i+1; j<items.length;j++) {
				
				if(current.getName()==items[j].getName() && current.getValue()==items[j].getValue() && current.getWeight()==items[j].getWeight())
						isSame[j] =true; 
				else isSame[i] =false; 
					
				
			}
			
		}
		
		List<Item> list = new LinkedList<>();
		
		for(int i = 0;i<isSame.length;i++) {
			if(isSame[i]==false) {
				list.add(items[i]);
			}
		}
		
		Item[] newarr = new Item[list.size()];
		return list.toArray(newarr);
		
	}		
}
