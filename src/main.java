import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis  = new FileInputStream(new File("data.xlsx"));
			XSSFWorkbook sheet = new XSSFWorkbook(fis);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
