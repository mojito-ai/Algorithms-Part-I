/**
* <h1>Matrix Multiplication: Multiplying a matrix with a vector</h1>
* 
* <li> Sparse Matrices: Too many 0's present in matrix multiplication.
* 
* @author  Mohit Sharma
* @version 1.0
* @since   12-01-2021
* 
*/

public class MatrixVector {
	/**
	 * Brute force: N^2 running time
	 * @param args
	 */
	
	public static void main(String [] args)
	{
		int N=Integer.parseInt(args[0]);
		double a[][]=new double[N][N];
		double x[]=new double[N];
		double b[]=new double[N];
		
		//initialize
		
		for(int i=0;i<N;i++)	//multiplying
		{
			double sum=0.0;
			for(int j=0;j<N;j++)
				sum+=a[i][j]*x[j];
			b[i]=sum;
		}
	}

}
