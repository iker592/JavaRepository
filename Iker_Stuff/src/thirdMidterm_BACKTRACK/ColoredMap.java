package thirdMidterm_BACKTRACK;

public class ColoredMap {
	/**
	 * https://github.com/pgardunoc/snippet/commit/
	 * 67febefadd4d72bb2e8566ef4da1c3f4a8ddfa7b*/

	static final int NONE = 0;
	static final int RED = 1;
	static final int YELLOW = 2;
	static final int GREEN = 3;
	static final int BLUE = 4;
	int map[][];

//	int mapColors[] = { NONE, NONE, NONE, NONE, NONE, NONE, NONE };
	
	// this variable is initialized manually -not recommended-
	int mapColors[] = { NONE, NONE, NONE, NONE, NONE, NONE, NONE, NONE, NONE };

	void createMap() {
//		map = new int[7][];
//		map[0] = new int[] { 1, 4, 2, 5 };
//		map[1] = new int[] { 0, 4, 6, 5 };
//		map[2] = new int[] { 0, 4, 3, 6, 5 };
//		map[3] = new int[] { 2, 4, 6 };
//		map[4] = new int[] { 0, 1, 6, 3, 2 };
//		map[5] = new int[] { 2, 6, 1, 0 };
//		map[6] = new int[] { 2, 3, 4, 1, 5 };
		
		/** Grid for the map of 9 European countries */
		map = new int[9][];
		map[0] = new int[] { 1, 2, 3 }; //Poland
		map[1] = new int[] { 0, 2, 4, 5 }; //Germany
		map[2] = new int[] { 0, 1, 3, 5 };//Czech Republic
		map[3] = new int[] { 0, 2, 5, 6 };//Slovakia
		map[4] = new int[] { 1, 5, 7 }; //Switzerland
		map[5] = new int[] { 1, 2, 3, 4, 6, 7, 8 }; //Austria
		map[6] = new int[] { 3, 5, 8 }; //Hungary		
		map[7] = new int[] { 4, 5, 8 }; //Italy
		map[8] = new int[] { 5, 6, 7 }; //Slovenia	
	}

	boolean explore(int country, int color) {
		if (country >= map.length)
			return true;
		if (okToColor(country, color)) {
			mapColors[country] = color;
			                        printMap();
			                        System.out.println("-------------------------------------");
			for (int i = RED; i <= BLUE; i++) {
				if (explore(country + 1, i)) {                                        
					return true;
				}
			}
		}
		return false;
	}

	boolean okToColor(int country, int color) {
		for (int i = 0; i < map[country].length; i++) {
			int ithAdjCountry = map[country][i];
			if (mapColors[ithAdjCountry] == color) {
				return false;
			}
		}
		return true;
	}

	void printMap() {
		for (int i = 0; i < mapColors.length; i++) {
			System.out.print("map[" + i + "] is ");
			switch (mapColors[i]) {
				case NONE:
					System.out.println("none");
					break;
				case RED:
					System.out.println("red");
					break;
				case YELLOW:
					System.out.println("yellow");
					break;
				case GREEN:
					System.out.println("green");
					break;
				case BLUE:
					System.out.println("blue");
					break;
			}
		}
	}


	public static void main(String[] args) {
		ColoredMap m = new ColoredMap();
		m.createMap();
		boolean result = m.explore(0, RED);
		System.out.println(result);
		m.printMap();
	}


}