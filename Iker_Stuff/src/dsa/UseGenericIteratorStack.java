package dsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class UseGenericIteratorStack {

	public static void main(String[] args) {
		// 
		int max = 5; // SET the max size of the Stack here //Integer.parseInt(args[0]);
		GenericArrayStackwithIterator<String> stack = new GenericArrayStackwithIterator<String>(max);

		// read the file from Scanner
		// write out to Console
		// file processing must be within a try-catch block

		try{
			String mypath = "/home/dolado3/DocGesDoc/DSA/JavaCode/datafiles/tobelines.txt";
			Scanner input2program = new Scanner (new File( mypath ));
			String stringline = "";
			while ( input2program.hasNext() ){		
				stringline = input2program.nextLine();

				// process the string with a simple ARRAYSTACK
				if (!stringline.equals("-")) {stack.push(stringline);}
				else 
					if (stack.isEmpty())  {System.out.println("BAD INPUT");} 
					else   {System.out.println(stack.pop() + " ");}
			}
			System.out.println("End of File");
			input2program.close(); // close the file
		}
		catch ( FileNotFoundException e ) {
			e.printStackTrace();
		}


		// print what's left on the stack with the ITERATOR
		System.out.println("Left on stack: -->");


//		use as ... myiterator.next 

//		Iterator<String> myiterator = stack.iterator();
//		while (myiterator.hasNext())
//			{
//			String s = myiterator.next();
//			System.out.println(s);
//		}
//		
		for (String s: stack) {System.out.println(s);}
		
//		use when the Generic stack 		
//		while (stack.hasNext())
//		{
//			String s = stack.next();
//			System.out.println(s);
//		}


		System.out.println();

	}

}