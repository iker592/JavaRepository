/**
 * 
 */
package usefulMethods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Iker
 *	version 0.1
 */
public final class IkerMethod {

	public static final void printf(String s){
		System.out.println(s +" ");
	}
	
	public static final String concatenate(String x, String y){
		System.out.println(x +" "+ y);
		return (x +y);
	}
	
	public static final void printArray(String myArray[]){
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] +" ");
		}System.out.println();
	}
	public static final void echo(){
		while(true){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		try {
			String text = in.readLine();
			System.out.println(text);
		} catch (IOException e1) {
			e1.printStackTrace();
		}}
	}
	
	
	/////////////METODOS UTILES/////////////////
	public static final void Console_Output(){

	System.out.print("Hello "); 
	System.out.println("world");
	
	}
	
	public static final void Console_Input(){
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
	try {
		String text = in.readLine();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	public static final void voidFile_Output(){
	PrintWriter out;
	try {
		out = new PrintWriter(new FileWriter("K:\\location\\outputfile.txt"));
		out.print("Hello "); 
		out.println("world"); 
		out.close();
	} catch (IOException e) {
		e.printStackTrace();
	} 
	}
	
	public static final void File_Input() throws IOException{
	try {
		BufferedReader in;
		in = new BufferedReader(new FileReader("K:\\location\\inputfile.txt"));
		String text = in.readLine(); 
		in.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} 

	}
	public static final void Converting_input_data() throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
	String text  = in.readLine(); 
	int x = Integer.parseInt(text); 
	double y = Double.parseDouble(text);
	}
	
	public static final void Reading_until_EOF() throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String text;
	while (in.ready()) { 
	  text = in.readLine(); 
	  System.out.println(text); 
	}
	}
	
	public static final void Pulling_apart_delimited_items_on_a_line(){

	String text = "Beggars in Spain*Nancy Kress*1992"; 
	StringTokenizer tokenizer = new StringTokenizer(text,"*"); 
	String title = tokenizer.nextToken(); 
	String author = tokenizer.nextToken(); 
	String year = tokenizer.nextToken();
	String letters = "a b c d e f g h i j"; 
	StringTokenizer tokenizer2 = new StringTokenizer(text," "); 
	String[] allText = new String[10]; 
	int pos = 0; 
	while (tokenizer2.hasMoreTokens()) 
	      allText[pos++] = tokenizer.nextToken(); 	
	}
	
	
    public static final void reads_input_interactively() throws IOException {

	// Read input with BufferedReader.
	BufferedReader in = new BufferedReader(
	    new InputStreamReader(System.in));

	while (true) {
	    // Read line and try to call parseInt on it.
	    String line = in.readLine();
	    int result;
	    try {
		result = Integer.parseInt(line);
	    } catch (NumberFormatException exception) {
		result = 0;
	    }

	    // Handle user input in a switch case.
	    switch (result) {
	    default:
		System.out.println("Default");
		break;
	    case 1:
		System.out.println("One");
		break;
	    case 2:
		System.out.println("Two");
		break;
	    }
	   }
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			System.out.print(args[i] +" ");
		}
		
		
		
	}

}
