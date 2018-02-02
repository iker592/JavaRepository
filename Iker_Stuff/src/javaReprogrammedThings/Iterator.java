package javaReprogrammedThings;


public interface Iterator<T> {
    boolean hasNext();
    T next();
    void remove();      // optional
}