package usefulMethods;

import java.io.IOException;

public class Tester {

		public static void main(String args[]) throws IOException{
			String s = "hello madafaka";
			String x="~$Nigga$~";
			String y="@@@Feel da Flow@@@";
			String myArray[]={"C","O","O","L"};
			IkerMethod.printf(s);
			IkerMethod.concatenate(x, y);
			IkerMethod.printArray(myArray);
			IkerMethod.main(myArray);
			IkerMethod.echo();
			//IkerMethod.reads_input_interactively(); // NOT available at the same time of echo 
		}
}
