import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
* <h1>Ball: Represents the hard disk object</h1>
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

public class Ball 
{
	private double rx, ry;		//position
	private double vx, vy;		//velocity
	private final double radius;//radius
	public Ball()
	{
		rx=StdRandom.uniform(1);
		ry=StdRandom.uniform(1);
		vx=StdRandom.uniform(1);
		vy=StdRandom.uniform(1);
		radius=StdRandom.uniform(1);
	}
	
	public void move(double dt)
	{
		if((rx+vx*dt<radius) || (rx+vx*dt>10.0-radius))	{	vx=-vx;	}
		if((ry+vy*dt<radius) || (ry+vy*dt>10.0-radius))	{	vx=-vx;	}
		rx=rx+vx*dt;
		ry=ry+vy*dt;
	}
	
	public void draw()
	{
		StdDraw.filledCircle(rx, ry, radius);
	}

}
