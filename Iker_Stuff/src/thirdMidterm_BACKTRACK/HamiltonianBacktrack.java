package thirdMidterm_BACKTRACK;

/** http://www.academic.marist.edu/~jzbv/algorithms/Backtracking.htm*/

public class HamiltonianBacktrack {
	private int [ ][ ] M;             //adjacency matrix representation of the graph
	private int [ ] path;
	private int N;                                 //number of vertices in the graph

	public HamiltonianBacktrack(int [ ][ ] G) {
		M = G;
		N = M.length;
		path = new int[N + 1];
	}
	private void hamiltonian(int index) {
		if (promising(index) ) {
			if (index == N -1) {
				//print out the result
				path[index+1] = path[0];   //first add the start vertex to the end                                                                                           //of the cycle
				System.out.print("A solution is: ");
				for (int i = 0; i <= N; i++)
					System.out.print("  " + path[i]);
				System.out.println( );
			}
			else
				for (int j = 0; j < N; j++) {    //try all vertices as the next one
					path[index+1] = j;
					hamiltonian(index+1);
				}
		}
	}
	private boolean promising(int index) {
		if (index == 0) return true;
		if (index == N -1 && M[path[index]][path[0]] == 0)
			return false;
		if (index > 0 && M[path[index-1]][path[index]] == 0)
			return false;
		int j = 0;
		while (j < index && path[index] != path[j]){
			j++;
		}
		return (j == index);
	}

	public void hamiltonianPath(int startVertex) {
		path[0] = startVertex;
		hamiltonian(0);
	}

	public static void main (String[] args) {

		//		int [][] AM = 
		//			{
		//			{0, 1, 1, 1, 0, 0, 0, 0, 0 }, //Poland 0
		//			{1, 0, 1, 0, 1, 1, 0, 0, 0 }, //Germany 1
		//			{1, 1, 0, 1, 0, 1, 0, 0, 0 }, //Czech Republic 2
		//			{1, 0, 1, 0, 0, 1, 1, 0, 0 }, //Slovakia	3
		//			{0, 1, 0, 0, 0, 1, 0, 1, 0 }, //Switzerland 4
		//			{0, 1, 1, 1, 1, 0, 1, 1, 1 }, //Austria 5
		//			{0, 0, 0, 1, 0, 1, 0, 0, 1 }, //Hungary 6
		//			{0, 0, 0, 0, 1, 1, 0, 0, 1 }, //Italy 7
		//			{0, 0, 0, 0, 0, 1, 1, 1, 0 }, //Slovenia 8
		//			};

		int [][] AM = 
			{
				{0, 1, 1, 0 }, // 0
				{0, 0, 1, 0 }, // 1
				{1, 0, 0, 1 }, // 2
				{1, 1, 0, 0 }, // 3
			};


		HamiltonianBacktrack ham1 = new HamiltonianBacktrack(AM);
		ham1.hamiltonianPath(2);

	}
}