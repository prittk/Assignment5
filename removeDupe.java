import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//https://www.geeksforgeeks.org/preconditions-guava-java/# where preconditon came from
public class removeDupe {
	
	public static void main(String[] args)
	{
		//Create a list to test remove duplicates
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(2);
		numbers.add(3);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(1);
		
		System.out.println("List size = "+ numbers.size() + " List = "+numbers+ "\n");
		
		removeDuplicates(numbers);
		
		//Create another list that is null and send it to removeDuplicates
		List<Integer> numbers_Null = new ArrayList<>();
		removeDuplicates(numbers_Null);
		
		
	}

	public static void removeDuplicates(List lst) 
	{
		if (lst == null || lst.size() <= 1) 
			{
				throw new IllegalArgumentException("List is Null or equal to 1, method cannot remove duplicates");
			}
		lst.sort(null);//Sort the list first since the the remover only removes if the duplicates are next to each other 
		
		List copy = new ArrayList(lst);
		Iterator elements = copy.iterator();
		Object pre = elements.next();
		
		while(elements.hasNext()) 
		{
		Object nex = elements.next();
		
			if (pre.equals(nex))
			{
				lst.remove(nex);
			}
			else
			{
				pre = nex;
			}
		}
		System.out.println("List after dupliates removed "+lst);
		}

}
