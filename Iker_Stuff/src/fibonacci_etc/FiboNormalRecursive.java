package fibonacci_etc;

import java.io.InputStreamReader;
import java.util.Scanner;

public class FiboNormalRecursive{
	
	 private static Scanner scanner;

	public static int fibo(int n) {
		return FiboRecursive(n,0);
	 }
	 
	 private static int FiboRecursive(int n, int accum){
	  if(n==0){
	   return 0;
	  }
	  if(n==1){
	   return 1;
	  }
	  else{
	  return FiboRecursive(n-1,accum)+FiboRecursive(n-2,accum);
	  }
	 }
	 

	 
	 public static void main(String args[]){
	  int n=0;
	  System.out.println("Introduce the umpteenth term of the Fibonacci sequence that you want know it");
      scanner = new Scanner(new InputStreamReader(System.in));
      n =scanner.nextInt();		 
	  System.out.println("Fibo("+n+")"+ "= " + fibo(n));
	 }
	  
}