import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class main {

	static int theta = -2;
	static double alpha = 0.2;
	static double w1 = 1;
	static double w2 = -2;
	
	static int epoch = 0;
	static double[][] apples1;
	static double[][] oranges1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		apples1 = getValues(0);
		oranges1 = getValues(1);
		System.out.println();
		
		trainApples1();
		System.out.println();		
		
	}
	public static void trainApples1() {
		int[] applesActualOutput = getActualOutput(apples1);
		for(int i = 0; i < apples1.length; i++)
		{
			w1 = w1 + (alpha * apples1[0][i] * (0 - applesActualOutput[i]));
		}
	}
	public static int[] getActualOutput(double[][] array) {
		int[] result = new int[array[0].length];
		for(int i = 0; i < result.length; i++)
		{
			double something = ((w1 * array[0][i]) + (w2 * array[1][i])) - theta;
			result[i] = (something >= 0 ? 1 : 0);
			System.out.println(i + "\t" + something);
		}
		
		return result;
	}
 	public static double[][] getValues(int s){

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
