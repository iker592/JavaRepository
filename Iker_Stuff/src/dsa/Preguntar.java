package dsa;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

import dsa.*;

public class Preguntar {

	public  Preguntar(){
		
	}
	public static void main (String args[]){
		int min=0;
		int max=9;
		Integer target=3;
		Integer[] myarray = new Integer[max+1];
		for(int i=0;i<=max;i++)
		{//System.out.println("34");
		Double x =Math.random();
		myarray[i]=x.intValue();
		System.out.print(myarray[i]+" ");
		}
		/*  MODIFICAR Y USAR ESTO
		Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 10; ++idx){
	      int randomInt = randomGenerator.nextInt(100);
	      log("Generated : " + randomInt);
	    }
		*/
		
		boolean bo=SortingAndSearching.<Integer>linearSearch(myarray, min, max, target);
		System.out.println(bo);
		//Before sorting
		for(Integer s:myarray){
			System.out.print(s.toString()+" ");
		}System.out.println();
		//Sort with quicksort
		SortingAndSearching.<Integer>quickSort(myarray, min, max);
		//After sorting
		for(Integer i:myarray){
			System.out.print(i.toString()+" ");
		}System.out.println();
	}
}
