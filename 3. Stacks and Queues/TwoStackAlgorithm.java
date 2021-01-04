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
