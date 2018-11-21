package Question3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class perceptron {
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
	
	double[] test1 = new double[20];
	double[] test2 = new double[20];
	
	double[][] apples;
	double[][] oranges;
	double actualOutputApples;
	double desiredApple;
	
	public perceptron() {
		
		
		
		apples = getValues(2);
		oranges = getValues(3);
//		w13 = .5;
//		w23 = .9;
//		w14 = .4;
//		w24 = 1;
//		w35 = -1.2;
//		w45 = 1.1;
//		t3 = .8;
//		t4 = -.13;
//		t5 = .3;
		
		while(sumOfErrors > .001) {
			sumOfErrors = 0;
			epochs ++;
			for (count = 0; count < 20; count++)
			{
				actualOutputApples();
				trainApples();
				test1[count] = error * error;
				sumOfErrors += test1[count];
				actualOutputOranges();
				trainOranges();
				test2[count] = error * error;
				sumOfErrors += test2[count];
				//sumOfErrors += Math.pow(error, 2);
			}
			System.out.println(Arrays.toString(test1) + "\n" + Arrays.toString(test2));
			//System.out.print("");
		}
		//System.out.println(epochs);
	}
	
	public void actualOutputApples()
	{
		y3 = (1 / (1 + ( Math.pow(Math.E, (-1 * (apples[0][count] * w13 + apples[1][count] * w23 - t3))))));
		//System.out.println(y3);
		y4 = (1 /(1 + ( Math.pow(Math.E, (-1 * (apples[0][count] * w14 + apples[1][count] * w24 - t4))))));
		
		//System.out.println(y4);
		
		y5 = (1 / (1 + ( Math.pow(Math.E, (-1 * ((y3 * w35) + (y4 * w45) - t5))))));
		
		//System.out.println(y5);
		
		
		error = (desiredApple - y5);
		//System.out.println(error);
		
	}
	public void actualOutputOranges()
	{
		y3 = (1 / (1 + ( Math.pow(Math.E, (-1 * (oranges[0][count] * w13 + oranges[1][count] * w23 - t3))))));
		//System.out.println(y3);
		y4 = (1 /(1 + ( Math.pow(Math.E, (-1 * (oranges[0][count] * w14 + oranges[1][count] * w24 - t4))))));
		
		//System.out.println(y4);
		
		y5 = (1 / (1 + ( Math.pow(Math.E, (-1 * ((y3 * w35) + (y4 * w45) - t5))))));
		
		//System.out.println(y5);
		
		
		error = (desiredApple - y5);
		//System.out.println(error);
		
	}
	
	public void trainApples()
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
		
		
		cw13 = alpha * apples[0][count] * delta3;
		//System.out.println(cw13);
		cw23 = alpha * apples[1][count] * delta3;
		//System.out.println(cw23);
		cw14 = alpha * apples[0][count] * delta4;
		//System.out.println(cw14);
		cw24 = alpha * apples[1][count] * delta4;
		//System.out.println(cw24);
		
		w13 = w13 + cw13;
		w14 = w14 + cw14;
		w23 = w23 + cw23;
		w24 = w24 + cw24;
		w35 = w35 + cw35;
		w45 = w45 + cw45;
	
	}
	public void trainOranges()
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
		
		
		cw13 = alpha * oranges[0][count] * delta3;
		//System.out.println(cw13);
		cw23 = alpha * oranges[1][count] * delta3;
		//System.out.println(cw23);
		cw14 = alpha * oranges[0][count] * delta4;
		//System.out.println(cw14);
		cw24 = alpha * oranges[1][count] * delta4;
		//System.out.println(cw24);
		
		w13 = w13 + cw13;
		w14 = w14 + cw14;
		w23 = w23 + cw23;
		w24 = w24 + cw24;
		w35 = w35 + cw35;
		w45 = w45 + cw45;
	
	}

	public double[][] getValues(int s){

		try {
			ArrayList<ArrayList<Double>> table = new ArrayList<ArrayList<Double>>();
			FileInputStream fis  = new FileInputStream(new File("data.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheetAt(s);
			Iterator<Row> rowIt = sheet.rowIterator();
			
			while(rowIt.hasNext())
			{
				Row row = rowIt.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				ArrayList<Double> tempArrayList = new ArrayList<Double>();
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					tempArrayList.add(Double.parseDouble(cell.toString() + ""));
				}
				table.add(tempArrayList);
			}
			
			double[][] doubleArray = new double[table.size()][table.get(0).size()];
			
			for(int i = 0; i < table.size(); i++)
			{
				for(int k = 0; k < table.get(i).size(); k++)
				{
					doubleArray[i][k] = table.get(i).get(k);
				}
			}
			return doubleArray;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new double[0][0];
	}
	
}
