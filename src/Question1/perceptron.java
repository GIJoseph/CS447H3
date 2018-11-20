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
	double alpha = -0.2;
	double w1 = 1;
	double w2 = -2;
	
	int epoch = 0;
	double[][] apples1;
	double[][] oranges1;
	public perceptron() {
		apples1 = getValues(0);
		oranges1 = getValues(1);
		System.out.println();
		
		for(int i = 0; i < 30; i++)
		{
				trainApples1();
				trainOranges1();
				if(i == 29)
				{
					System.out.println();
				}
		}
				
		
	}
	public void trainApples1() {
		int[] applesActualOutput = getActualOutput(apples1);
		System.out.println(" Apples " + Arrays.toString(applesActualOutput));
		for(int i = 0; i < apples1.length; i++)
		{
			w1 = w1 + (alpha * apples1[0][i] * (0 - applesActualOutput[i]));
			w2 = w2 + (alpha * apples1[1][i] * (0 - applesActualOutput[i]));
		}
	}
	public void trainOranges1() {
		int[] orangesActualOutput = getActualOutput(oranges1);
		System.out.println("    Oranges " + Arrays.toString(orangesActualOutput));
		for(int i = 0; i < oranges1.length; i++)
		{
			w1 = w1 + (alpha * oranges1[0][i] * (1 - orangesActualOutput[i]));
			w2 = w2 + (alpha * oranges1[1][i] * (1 - orangesActualOutput[i]));
		}
	}
	public int[] getActualOutput(double[][] array) {
		int[] result = new int[array[0].length];
		for(int i = 0; i < result.length; i++)
		{
			double something = ((w1 * array[0][i]) + (w2 * array[1][i])) - theta;
			result[i] = (something >= 0 ? 1 : 0);
		}
		
		return result;
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
