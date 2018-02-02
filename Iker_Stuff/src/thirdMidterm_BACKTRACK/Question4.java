package thirdMidterm_BACKTRACK;

import java.util.ArrayList;

public class Question4
{
	static boolean finished = false;
	static final int MAXCANDIDATES = 4;
	static final int NMAX = 4;
    static int solution_count = 0;
	ArrayList<Integer> a;
	
	
	ArrayList<Integer> c;

	static void backtrack(ArrayList<Integer> a, int k, int input)
	{
		ArrayList<Integer> c = new ArrayList<>(MAXCANDIDATES);
		int ncandidates, i;
		
		if (is_a_solution(a,k,input))
			process_solution(a,k,input);
		
		else
		{	
			k++;
			ncandidates = construct_candidates(a,k,input,c);
			for (i=0; i<ncandidates; i++) {
				a.add(k,c.get(i));
				backtrack(a,k,input);
				if (finished) return;
			}		
		}
	}

	static void process_solution(ArrayList<Integer>a,int k, int n)
	{ 	solution_count++;		
		//System.out.println(a);

	}
	static boolean is_a_solution(ArrayList<Integer> a,int k,int n)
	{ return k==n;
	}
	static int construct_candidates(ArrayList<Integer> a,int k,int n, ArrayList<Integer> c)
	{		
		c.add(7);
		c.add(6);
		c.add(9);
		c.add(3);
		//for (int i = 0; i <k; i++) {
			//c.remove(k);		
		//}
		System.out.println(c);
		return n-k;
	}
	
	public static void main(String[] args){
		int r = 2;//esto sería parametro
		ArrayList<Integer> a = new ArrayList<>(r);
		a.add(7);
		a.add(6);
		a.add(9);
		a.add(3);
		backtrack(a,0,4);
		//System.out.println(a);

		
	}


}
