import java.util.Stack;


public class Subtraction {
	/*Suppose you want to do the subtraction of two numbers. 
	Each digit of the numbers is divided and put in an array. 
	Like A=[1, 2, 3, 4, 5], B=[4, 5, 3, 5]. 
	You should output an array C=[7, 8, 1, 0]. 
	Remember that your machine can’t hand numbers larger than 20.
	*/
	public static int[] subtraction(int[] a, int[] b){
		int alen = a.length;
		int blen = b.length;
		//System.out.println("The length of two array are " + alen + " and " + blen);
		boolean carry = false;
		int count = 0;
		Stack<Integer> s = new Stack<Integer>();
		while (blen > 0){
			if (carry){
				a[alen - 1] --;
				carry = false;
			}
			int temp = a[alen - 1] - b[blen - 1];
			//System.out.println("temp is " + temp);
			if (temp < 0){
				temp += 10;
				carry = true;;
			}
			s.push(temp);
			//System.out.println("the number push into stack is " + s.peek());
			count ++;
			blen--;
			alen--;
		}
		while (alen > 0){
			if (carry){
				a[alen - 1]--;
				carry = false;
			}
			if (alen == 1 && a[0] == 0)
				break;
			else{
				if (a[alen - 1] < 0){
					a[alen - 1] += 10;
					carry = true;
				}
			}
			s.push(a[alen - 1]);
			count ++;
			alen--;
		}
		int[] res = new int[count];
		for (int i = 0; i < count; i++){
			res[i] = s.pop();
			System.out.println(res[i]);
		}
		return res;
	}
	public static void main(String[] args){
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {4, 5, 3, 5};
		int[] res = subtraction(a, b);
	}
}

