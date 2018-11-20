package Question2;

import java.util.Scanner;

public class mlp {
	double[] w = new double[6];
	double w13,w23,w14,w24,w35,w45;
	double cw13,cw23,cw14,cw24,cw35,cw45;
	double t3,t4,t5;
	double y3, y4, y5;
	double error;
	double[] x1 = new double[]{1, 0, 1, 0};
	double[] x2 = new double[]{1, 1, 0, 0};
	double[] desiredOut = new double[]{0, 1, 1, 0};
	int count = 0;
	double delta5;
	double delta3;
	double delta4;
	double alpha = .5;
	double sumOfErrors = 1;
	int epochs = 0;
	
	public mlp() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("weight 13?");
		w13 = scan.nextDouble();
		System.out.println("weight 23?");
		w23 = scan.nextDouble();
		System.out.println("weight 14?");
		w14 = scan.nextDouble();
		System.out.println("weight 24?");
		w24 = scan.nextDouble();
		System.out.println("weight 35?");
		w35 = scan.nextDouble();
		System.out.println("weight 45?");
		w45 = scan.nextDouble();
		System.out.println("theta 3?");
		t3  = scan.nextDouble();
		System.out.println("theta 4?");
		t4 = scan.nextDouble();
		System.out.println("theta 5?");
		t5 = scan.nextDouble();
		
		
//		w13 = .5;
//		w23 = .9;
//		w14 = .4;
//		w24 = 1;
//		w35 = -1.2;
//		w45 = 1.1;
//		t3 = .8;
//		t4 = -.13;
//		t5 = .3;
		
		while(sumOfErrors >.001) {
			sumOfErrors = 0;
			epochs ++;
			for (count = 0; count < 4; count++)
			{
				actualOutput();
				train();
				sumOfErrors += Math.pow(error, 2);
			}
		}
		System.out.println(epochs);
	}
	
	public void actualOutput()
	{
		y3 = (1 / (1 + ( Math.pow(Math.E, (-1 * (x1[count] * w13 + x2[count] * w23 - t3))))));
		//System.out.println(y3);
		y4 = (1 /(1 + ( Math.pow(Math.E, (-1 * (x1[count] *w14 + x2[count] * w24 - t4))))));
		
		//System.out.println(y4);
		
		y5 = (1 / (1 + ( Math.pow(Math.E, (-1 * ((y3 * w35) + (y4 * w45) - t5))))));
		
		//System.out.println(y5);
		
		
		error = (desiredOut[count] - y5);
		//System.out.println(error);
		
	}
	
	public void train()
	{
		delta5 = y5 * (1-y5) * error;
		//System.out.println(delta5);
		
		cw35 = alpha * y3 * delta5;
		cw45 = alpha * y4 * delta5;
		//System.out.println(w35);
		//System.out.println(w45);
		
		
		delta3 = y3 * (1 - y3) * delta5 * w35;
		delta4 = y4 * (1 - y4) * delta5 * w45;
		//System.out.println(delta3);
		//System.out.println(delta4);
		//System.out.println(y3);
		
		
		cw13 = alpha * x1[count] * delta3;
		//System.out.println(cw13);
		cw23 = alpha * x2[count] * delta3;
		//System.out.println(cw23);
		cw14 = alpha * x1[count] * delta4;
		//System.out.println(cw14);
		cw24 = alpha * x2[count] * delta4;
		//System.out.println(cw24);
		
		w13 = w13 + cw13;
		w14 = w14 + cw14;
		w23 = w23 + cw23;
		w24 = w24 + cw24;
		w35 = w35 + cw35;
		w45 = w45 + cw45;
		
	//	System.out.println(w24);
		
	//	System.out.println(w45);
		
		
		
	}
	
	
	
	
	
	
	
	
}
