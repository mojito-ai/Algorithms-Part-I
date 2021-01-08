import edu.princeton.cs.algs4.StdDraw;

/**
* <h1>Molecular dynamics simulation of hard discs: Simulate the motion of N moving particles that behave accordingly
* to the laws of elastic collision.</h1>
* 
* <li>Applications
* <li>Maxwell-Boltzmann: Distribution of speeds as a function of temperature.
* <li>Einstein: Explain Brownian motion of pollen grains.
* 
* 
* @author  Mohit Sharma
* @version 1.0
* @since   08-01-2021
* 
*/

public class BouncingBalls {
	
	@SuppressWarnings("deprecation")
	public static void main(String [] args)
	{
		int N=Integer.parseInt("50");
		Ball[] balls=new Ball[N];
		for(int i=0;i<N;i++)
			balls[i]=new Ball();
		
		while(true)
		{
			StdDraw.clear();
			for(int i=0;i<N;i++)
			{
				balls[i].move(0.5);
				balls[i].draw();
			}
			StdDraw.show(1);
		}
	}

}
