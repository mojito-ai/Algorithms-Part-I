import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stack;

/**
* Arithemetic Infix Expressions
* Two Stack Algorithm [E.W. Dijkstra]
* 
* <li>Value: push onto the value stack
* <li>Operator: push onto the operator stack
* <li>Left Parenthesis: Ignore
* <li>Right Parenthesis: pop operator and two values, push the result of applying that operator onto the operand stack
* 
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/

public class TwoStackAlgorithm {
	
	/**Correctness of Two Stack
	 * <li> When algorithm encounters an operator surrounded by two values within parentheses, it leaves the result on the value stack.
	 * ( 1 + ( ( "2" + "3" ) * ( 4 * 5 ) ) ), as if the original input were:
	 * ( 1 + ( ( 5 * (4 * 5 ) ) )
	 * 
	 * <li> Repeating the argument:( 1 + ( 5 * 20 ) ) --> ( 1 + 100 ) --> 101
	 * 
	 * @summary Extensions. More ops, precedence order, associativity
	 * @param args
	 */
	public static void main(String [] args)
	{
		Stack<Double> vals=new Stack<>();
		Stack<String> ops=new Stack<>();
		while(!StdIn.isEmpty())
		{
			String s=StdIn.readString();
			if(s.equals("(")) {	}//ignore
			else if(s.equals("+")) ops.push(s);
			else if(s.equals("-")) ops.push(s);
			else if(s.equals("*")) ops.push(s);
			else if(s.equals("/")) ops.push(s);
			else if(s.equals(")"))
					{
						String op=ops.pop();
						if(op.equals("+"))	
							vals.push(vals.pop()+vals.pop());
						else if(op.equals("-"))	
							vals.push(vals.pop()-vals.pop());
						else if(op.equals("*"))	
							vals.push(vals.pop()*vals.pop());
						else if(op.equals("/"))	
							vals.push(vals.pop()/vals.pop());
					}
			else vals.push(Double.parseDouble(s));
		}
		System.out.println(vals.pop());
	}
}

/* Stack-based programming languages
 * 
 * Observation 1. Dijkstra's two-stack algorithm computes the same value if the operator occurs after the two values.
 * 				  ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + )
 * 
 * Observation 2. All of the parentheses are redundant!
 * 				  1 2 3 + 4 5 * * +
 * 
 * Bottom line. Postfix or "reverse Polish" notation.
 * Applications. Postscript, Forth, calculators, Java virtual machine
 * 
 */