package dsa;

import exceptions.NoEnoughtArgumentException;


public class PostfixEvaluator
{
  /** constant for addition symbol */
  private final char ADD = '+';
  /** constant for subtraction symbol */
  private final char SUBTRACT = '-';
  /** constant for multiplication symbol */
  private final char MULTIPLY = '*';
  /** constant for division symbol */
  private final char DIVIDE = '/';
  /** the stack */
  private GenericArrayStackwithIterator<Integer> stack;

  /**
   * Sets up this evaluator by creating a new stack.
   */
  public PostfixEvaluator()
  {
    stack = new GenericArrayStackwithIterator<Integer>();//here create the object with new
  }

  /**
   * Evaluates the specified postfix expression. If an operand is
   * encountered, it is pushed onto the stack. If an operator is
   * encountered, two operands are popped, the operation is
   * evaluated, and the result is pushed onto the stack.
   * @param expr String representation of a postfix expression
   * @return int value of the given expression
 * @throws NoEnoughtArgumentException 
   */
  public int evaluate (String expr) throws NoEnoughtArgumentException
  {
    int op1, op2, result = 0;
    String[] tokens;
    tokens = expr.split("\\s");
    String token;
    // use token.charAt(0) if you need to access the first char
  //.	.........
    //Clues. 1: Iterate over all tokens
    for (int i = 0; i < tokens.length; i++) {
		token = tokens[i];
		//2. Ask if the token is an operator and proceed accordingly.
		if (!isOperator(token)) {
			stack.push(Integer.parseInt(token));
		} else if (i < 2 && isOperator(token)) {
			throw new NoEnoughtArgumentException("There are not enought arguments");
		} else {
			//4. remember to do the type casting (Integer) when pushing onto or popping out
			//the stack. Otherwise the program throws an error difficult to find.
			//3. pay attention to the fact that the stack is of type integer 
			//and perform the corresponding type casting with (   ).intValue()
			op2 = stack.pop().intValue();
			op1 = stack.pop().intValue();
			result = evalSingleOp(token.charAt(0), op1, op2);
			stack.push(result);
		}
	}
	return (stack.peek().intValue());
  }

  /**
   * Determines if the specified token is an operator.
   * @param token String representing a single token
   * @return boolean true if token is operator
   */
  private boolean isOperator (String token)
  {
    return ( token.equals("+") || token.equals("-") ||
             token.equals("*") || token.equals("/") );
  }

  /**
   * Peforms integer evaluation on a single expression consisting of 
   * the specified operator and operands.
   * @param operation operation to be performed
   * @param op1 the first operand
   * @param op2 the second operand
   * @return int value of the expression
   */
  private int evalSingleOp (char operation, int op1, int op2)
  {
    int result = 0;

    switch (operation)
    {
      case ADD:
        result = op1 + op2;
        break;
      case MULTIPLY:
			result = op1 * op2;
			break;
		case DIVIDE:
			result = op1 / op2;
			break;
		case SUBTRACT:
			result = op1 - op2;
			break;
    }

    return result;
  }
}
