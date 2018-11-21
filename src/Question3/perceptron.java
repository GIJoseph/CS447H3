package Question1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class perceptron {
	int theta = -2;
	double alpha = 0.2;
	double w1 = 1;
	double w2 = -2;
	double bias = 1;
	
	int epoch = 0;
	double[][] apples2;
	double[][] oranges2;
	int[] actual1 = new int[10];
	int[] actual2 = new int[10];
	public perceptron() {
		apples2 = getValues(2);
		oranges2 = getValues(3);
		System.out.println();
		
		for(int k = 0; k < 20; k++) {
			for(int i = 0; i < 10; i++)
			{
					train(apples2, 0, i);
					actual1[i] = findActual(apples2,i);
					train(oranges2, 1, i);
					actual2[i] = findActual(oranges2,i);
			}
			System.out.println("Apples " + Arrays.toString(actual1) + " Oranges " + Arrays.toString(actual2));
		}
		System.out.println();
		
	}
	public int[] getActualOutput(double[][] array, int expected) {
		int[] result = new int[array[0].length];
		for(int i = 0; i < result.length; i++)
		{
			double something = ((w1 * array[0][i]) + (w2 * array[1][i])) - theta;
			result[i] = (something >= 0 ? 1 : 0);
			w1 = w1 + (alpha + array[0][i] * (expected - result[i]));
			w2 = w2 + (alpha + array[1][i] * (expected - result[i]));
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
	public void train(double[][] inputs, int desired, int count)
	{
		int guess = findActual(inputs, count);
		double error = desired - guess;
		w1 += alpha * error * inputs[0][count];
		w2 += alpha * error * inputs[1][count];
		bias += alpha * error;
	}
	public int findActual(double[][] inputs, int count)
	{
		double sum = 0;
		sum += inputs[0][count] * w1;
		sum += inputs[1][count] * w2;
		sum += bias;
		return (sum >= 0? 1: 0);
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
