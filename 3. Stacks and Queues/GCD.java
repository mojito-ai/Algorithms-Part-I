/**
* Greatest Common Divisor: Recursion + Can use an explicit stack to remove recursion
* 
* Stack uses: 
* <li>Parsing in a compiler
* <li>Java Virtual Machine
* <li>Undo in a Word Processor
* <li>Back Button in a Web Browser
* 
* @author  Mohit Sharma
* @version 1.0
* @since   04-01-2021
*/

public class GCD{
	
	public static int gcd(int p, int q)
	{
		if(q==0)	return p;
		else
			return gcd(q,p%q);
	}
}