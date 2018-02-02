package dsa;

/**
 * @author Lewis and Chase
 *
 *  Demonstrates a simulation of recursion using a stack.
 */

public class MazeSearch
{
  /**
   * Creates a new maze, prints its original form, attempts to
   * solve it, and prints out its final form.
   * @param args array of Strings
   */
  public static void main (String[] args)
  {
    Maze labyrinth = new Maze();
    
    System.out.println (labyrinth);
    
    if (labyrinth.traverse ())
      System.out.println ("The maze was successfully traversed!");
    else
      System.out.println ("There is no possible path.");
    
    System.out.println (labyrinth);
   }/*
  private static final char[] SYMBOLS = {' ', '#', '.', '*' };

  private static void print(){
    for(int row = 0; row < maze.length; ++row) {
      for(int col = 0; col < maze[row].length; ++col) {
        System.out.print(SYMBOLS[maze[row][col]]);
      }
      System.out.println();
    }
  }*/
}