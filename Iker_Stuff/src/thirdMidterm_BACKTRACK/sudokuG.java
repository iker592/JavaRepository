package thirdMidterm_BACKTRACK;


//solution by Jon Garrido 2013

public class sudokuG {

	public static void main(String[] args){

		int sudoku[][] = new int[9][9];     // empty grid
		sudoku = initialise_sudoku();     // fill the sudoku to be solved
		print_sudoku(sudoku);     // print the unsolved sudoku
		backtrack(sudoku, 0);     // solve the sudoku with backtracking

	}

	static int[][] initialise_sudoku(){

		int[][] s = {
				{0,8,0,0,0,0,0,9,0},     // we assume that 0's represent blank squares
				{0,1,2,0,4,0,6,0,0},
				{3,0,0,2,0,0,0,5,4},
				{0,3,0,0,5,6,0,0,0},
				{0,5,0,3,0,2,0,4,0},
				{0,0,0,4,8,0,0,3,0},
				{1,9,0,0,0,4,0,0,8},
				{0,0,3,0,6,0,4,7,0},
				{0,4,0,0,0,0,0,6,0}};

		return s;

	}

	static void print_sudoku(int s[][]){

		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				System.out.print(s[i][j]+",");
			}
			System.out.println();
		}
		System.out.println();

	}

	static void backtrack(int[][] s, int n){     // n is the position were we are

		if(n==81){
			print_sudoku(s);     //print the solution
			System.exit(0);
		}else{
			if(s[n/9][n%9]==0){     // look if the position is empty or not
				int[] a = new int[9];
				int c;
				c = build_candidates(s, n, a);     // look for all the possible numbers to fill in the position
				if(c>0){
					for(int i=0; i<c; i++){     // try with all the candidates with a recursive call to backtrack
						s[n/9][n%9] = a[i];
//						print_sudoku(s);
						backtrack(s, n+1);
					}
					s[n/9][n%9]=0;
				}
			}else{
				backtrack(s, n+1);     // if the position is not empty look for the next position
			}
		}
	}

	static int build_candidates(int[][] s, int n, int[] a){

		boolean valid = true;
		int j = 0;
		int c = 0;
		for(int i=1; i<=9; i++){     // look for all the possible numbers between 0 and 9
			while(valid && j<9){     // look if the number is already in that column
				if(i==s[j][n%9]){
					valid=false;
				}
				j++;
			}
			j=0;
			while(valid && j<9){     // look if this number is already in that row
				if(i==s[n/9][j]){
					valid=false;
				}
				j++;
			}
			j=0;
			int p = (((n/9)/3)*3*9)+(((n%9)/3)*3);     // p is the first position of the 3x3 sub-matrix
			while(valid && j<9){     // look if this number is already in the corresponding 3x3 sub-matrix
				if(i==s[p/9][p%9]){
					valid=false;
				}
				if(p%3==2){
					p+=7;
				}else{
					p++;
				}
				j++;
			}
			if(valid){     // add the valid number to the candidates array
				a[c]=i;
				c++;
			}
			j=0;
			valid=true;
		}
		return c;     // return the number of found candidates

	}

}