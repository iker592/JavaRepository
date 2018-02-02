package dsa3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import dsa.*;

public class StacksStringswithiterators {

	public static void main(String[] args) {
		int max = 10; // SET the max size of the Stack here
		//we create two different stacks with the same content
		ArrayStackwithIterator stack = new ArrayStackwithIterator(max);
		GenericLinkedStackwithIterator<String> anotherstack = new GenericLinkedStackwithIterator<String>();

		// read the file from Scanner
		// write out to Console
		// file processing must be within a try-catch block
		try {
			String mypath = "tobelines1.txt"; //choose your file
			Scanner input2program = new Scanner(new File(mypath));
			String stringline = "";
			while (input2program.hasNext()) {
				stringline = input2program.nextLine();
				System.out.println(stringline+"");
				if (!stringline.equals("-")) {
					stack.push(stringline);
					anotherstack.push(stringline);
				} else if (stack.isEmpty()) {
					System.out.println("BAD INPUT");
				} else {
					System.out.println(stack.pop() + " ");
					anotherstack.pop();
				}
			}
			System.out.println("End of File");
			input2program.close(); // close the file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// print what's left on the stack with the For-each ITERATORS
		System.out.print("--> Left on stack: ");
		for (String s : stack) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.print("--> Left on anotherstack: ");
		for (String s : anotherstack) {
			System.out.print(s + " ");
		}
		System.out.println();

		// old way, but valid, use of the iterator
		System.out.println("--> Old way, but valid, of using the iterators: ");
		Iterator<String> myiterator = stack.iterator(); //try   anotherstack.iterator()
		while (myiterator.hasNext()) {
			String s = myiterator.next();
			System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("--> Old way, but valid, of using the iterators: ");
		Iterator<String> myiterator2 = anotherstack.iterator(); //try   anotherstack.iterator()
		while (myiterator2.hasNext()) {
			String s = myiterator2.next();
			System.out.print(s+" ");
		}

	}
}
