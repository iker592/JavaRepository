package dsa;
// very simple Stack with Array implementation

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayStackOfStrings {
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    public ArrayStackOfStrings(int max) {  a = new String[max];       }
    public boolean isEmpty()            {  return (N == 0);           }
    public void push(String item)       {  a[N++] = item;             }
    public String pop()                 {  return a[--N];             }
    

    public static void main(String[] args) {
        int max = 5; // SET the max size of the Stack here //Integer.parseInt(args[0]);
        ArrayStackOfStrings stack = new ArrayStackOfStrings(max);
        
        // read the file from Scanner
        // write out to Console
        // file processing must be within a try-catch block
        String mypath = "prueba.txt";

        try{
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
  
        // print what's left on the stack
        System.out.print("Left on stack: ");
        while (!stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    } 
} 