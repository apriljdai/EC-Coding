import java.util.ArrayList;


public class UniqueElement {
	/*
	Write, efficient code for extracting unique elements from a sorted list of array. 
	e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9) -> (1, 3, 5, 9).
	Cannot use hashtable
	*/
	public static ArrayList<Integer> uniqueElement(ArrayList<Integer> num){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = 0;
		while (i < num.size()){
			int element = num.get(i);
			if (i == num.size() - 1){
				res.add(element);
				return res;
			}
			int j = i + 1; 
			if (j < num.size()){
				while (num.get(j) == element)
					j++;
				res.add(element);
				i = j;
			}
			else
				break;
		}
		return res;
	}
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(10);
		ArrayList<Integer> res = uniqueElement(list);
		for (Integer r: res)
			System.out.println(r);
	}
}
