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
		rx     = StdRandom.uniform(0.0, 1.0);
        ry     = StdRandom.uniform(0.0, 1.0);
        vx     = StdRandom.uniform(-0.005, 0.005);
        vy     = StdRandom.uniform(-0.005, 0.005);
		radius=0.02;
	}
	
	public void move(double dt)
	{
		if((rx+vx*dt<radius) || (rx+vx*dt>1.0-radius))	{	vx=-vx;	}
		if((ry+vy*dt<radius) || (ry+vy*dt>1.0-radius))	{	vy=-vy;	}
		rx=rx+vx*dt;
		ry=ry+vy*dt;
	}
	
	public void draw()
	{
		StdDraw.filledCircle(rx, ry, radius);
	}

}
