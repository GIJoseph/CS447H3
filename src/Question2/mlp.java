package Question2;

import java.util.Scanner;

public class mlp {
	double[] w = new double[6];
	double w13,w23,w14,w24,w35,w45;
	double t3,t4,t5;
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
		
		
		
		
	}
}
