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
	/** 
	* How a compiler implements a function?
	* <li> Function call: "push" local environment and return address
	* <li> Return: "pop" return address and local environment
	*/
	public static int gcd(int p, int q)
	{
		if(q==0)	return p;
		else
			return gcd(q,p%q);
	}
}