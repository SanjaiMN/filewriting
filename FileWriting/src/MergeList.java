import java.util.*;

public class MergeList 
{

	public static void main(String[] args) 
	{
	 	List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 3, 4, 5);
        List<Integer> list3 = Arrays.asList(4, 5, 6);
        List<Integer> list4 = Arrays.asList(6, 7);
        List<Integer> mergedList = merge(list1, list2, list3, list4);
        System.out.println(mergedList);
	}
	
	 public static List<Integer> merge(List<Integer> list1, List<Integer> list2, List<Integer> list3, List<Integer> list4) 
	 {
	        Set<Integer> set = new LinkedHashSet<>(); // use LinkedHashSet to maintain order
	        set.addAll(list1);
	        set.addAll(list2);
	        set.addAll(list3);
	        set.addAll(list4);
	        return new ArrayList<>(set);
	 }
}
