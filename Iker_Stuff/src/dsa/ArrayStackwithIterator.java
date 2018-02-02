package dsa;

import java.util.Iterator;

public class ArrayStackwithIterator implements Iterable<String> {
	private String[] a;  // holds the items
	private int N;       // number of items in stack

	public ArrayStackwithIterator(int max) {  a = new String[max];       }
	public boolean isEmpty()            {  return (N == 0);           }
	public void push(String item)       {  a[N++] = item;             }
	public String pop()                 {  return a[--N];             }
	public Iterator<String> iterator()  { return new ArrayIterator(); }

	public class ArrayIterator implements Iterator<String> {
		private int i = N-1;
		public boolean hasNext() { return i >= 0; }
		public String next()     { return a[i--]; }
		public void remove()     { throw new UnsupportedOperationException(); }
	}
}