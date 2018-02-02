package dsa3;

import java.util.Iterator;

import dsa.*;

public class sortedList {

	public static void main(String[] args) {
		DoubleOrderedList<CharWithFrequency> list = new DoubleOrderedList<CharWithFrequency>();
		String word = "fantastic";
		char[] charArray = word.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			CharWithFrequency chFr;
			chFr = searchData(list, charArray[i]);
			if (chFr != null) {
				list.remove(chFr);
				chFr.setFrequency(chFr.getFrequency() + 1);
				list.add(chFr);
			} else {
				chFr = new CharWithFrequency(charArray[i]);
				list.add(chFr);
			}
		}
		print(list);
	}

	public static CharWithFrequency searchData(
			DoubleOrderedList<CharWithFrequency> list, char letter) {
		Iterator<CharWithFrequency> iterator = list.iterator();
		while (iterator.hasNext()) {
			CharWithFrequency chFrec;
			chFrec = iterator.next();
			if (chFrec.getChar() == letter) {
				return chFrec;
			}
		}

		return null;
	}

	public static void print(DoubleOrderedList<CharWithFrequency> list) {
		Iterator<CharWithFrequency> iterator = list.iterator();
		while (iterator.hasNext()) {
			CharWithFrequency chFrec;
			chFrec = iterator.next();
			System.out.println(chFrec.toString());
		}

	}
}
