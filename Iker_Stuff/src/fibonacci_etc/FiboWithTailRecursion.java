package fibonacci_etc;

import java.io.InputStreamReader;
import java.util.Scanner;

public class FiboWithTailRecursion{
	 private static Scanner scanner;

	 private static int FiboRecursive(int n){
		 int result=0;
	  if(n==0 || n==1){
	   result=n;
	  }else{
	   result=FiboRecursive(n-2)+FiboRecursive(n-1);
	  }
	  return result;
	 }
	 
	 public static int fibo(int n) {
		return FiboRecursive(n);
	}
	 
	 public static void main(String args[]){
		  int n=0;
		  System.out.println("Introduce the umpteenth term of the Fibonacci sequence that you want know it");
	      scanner = new Scanner(new InputStreamReader(System.in));
	      n =scanner.nextInt();		 
		  System.out.println("Fibo("+n+")"+ "= " + fibo(n));
	 }
	 
	 
	 
}