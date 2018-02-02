package thirdMidterm_BACKTRACK;

import java.util.*; //LinkedList

public class KnapsackBacktrackSimple {
	private static double maxValue;
	private static double K; // knapsack capacity
	private static double[] s; // array of sizes
	private static double[] v; // array of values (both ordered by value
								// density)
	private static List<Integer> bestList; // members of solution set for
											// current best value
	private static int numItems; // number of items in set to select from (first
									// item is not dummy 0

	private static void knapsack(int index, double currentSize,
			double currentValue, List<Integer> cList) {

		if (index == numItems) { // we are at N+1
			if (currentValue > maxValue) {
				maxValue = currentValue;
				bestList = new LinkedList<Integer>(cList);
			}
		} else {
			if ((currentSize + s[index]) <= K) { // include the element
				LinkedList<Integer> leftList = new LinkedList<Integer>(cList);
				leftList.add(new Integer(index));
				knapsack(index + 1, currentSize + s[index], currentValue
						+ v[index], leftList);
			}
			// do not include the element
			LinkedList<Integer> rightList = new LinkedList<Integer>(cList);
			if (index < numItems) {
				knapsack(index + 1, currentSize, currentValue, rightList);
			}
		}
	}

	public static void main(String args[]) {
		maxValue = 0.0;
		bestList = null;

		List<Integer> currentList = new LinkedList<Integer>(); // create an
																// empty list

		K = 16;
		numItems = 4;
		v = new double[numItems + 1]; // add one element so that indexes don't
										// overflow
		s = new double[numItems + 1];
		v[0] = 45;
		v[1] = 30;
		v[2] = 45;
		v[3] = 10;
		s[0] = 3;
		s[1] = 5;
		s[2] = 9;
		s[3] = 5;
		// ordered by value density v/s

		knapsack(0, 0, 0, currentList);

		System.out.println("The solution set is:  ");
		for (int i = 0; i < bestList.size(); i++) {
			System.out.print("  " + bestList.get(i));
			System.out.println();
			System.out.println("The value contained in the knapsack is:  $"
					+ maxValue);
		}

	}

}