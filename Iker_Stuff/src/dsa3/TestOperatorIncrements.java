package dsa3;
public class TestOperatorIncrements {

	public static void main(String[] args) {

		String[] myarray = {"aa", "bb", "cc", "dd", "ee"};
		int i=0;
		while (i < myarray.length-1){ // guess why there are runtime errors
			
			// option 1.  Pre Increment operator ++i (and Pre Decrement --i)
			System.out.println(myarray[++i]); 
			System.out.println(i);
			// equivalent to 
			i = i +1;
			System.out.println(myarray[i]);

			
			// option 2.  Post Increment operator (and Post Decrement i--)
			System.out.println(myarray[i++]);
			System.out.println(i);
			// equivalent to 
			System.out.println(myarray[i]);
			i = i +1;
		}
		
	}
}