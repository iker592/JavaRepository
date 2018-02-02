package dsa;
import java.util.Arrays;

public class BinarySearchArrayIntegers {

	public static void main(String[] args) {

		int[] arrayofints = new int[]{0,9,888,8,83,666,6,2,345,4,55,77,88,7,5};
		int target = 8;
		System.out.println(arrayofints.length);
		Arrays.sort(arrayofints);
		  for (int a=0; a < arrayofints.length; a++) {
			   System.out.print(arrayofints[a]+" ");} System.out.println();

		boolean found = false;
		int low = 0;
		int high = arrayofints.length-1;
		int midpoint;

		while (!found & low <= high) {
			midpoint = (low + high)/2;
			System.out.println(arrayofints[midpoint]);

			if (arrayofints[midpoint]== target) {found= true;}
			else if (arrayofints[midpoint]<target) {low = midpoint +1;}
			else {high = midpoint -1;}
		}

		System.out.println(found);
	}

}