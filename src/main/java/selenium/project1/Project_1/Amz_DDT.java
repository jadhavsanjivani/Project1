package selenium.project1.Project_1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;

public class Amz_DDT
{
	static String username;
	static String pass;
	

	public void valid_cred() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\sanji\\eclipse-workspace\\Project_1\\src\\DDT\\LoginQMP.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);
		Sheet s1 = w1.getSheet("Login");
		 username = s1.getRow(6).getCell(0).getStringCellValue();
		 pass = s1.getRow(6).getCell(1).getStringCellValue();
		
			/*Sheet s2 = w1.getSheet("Login2");
			 username = s1.getRow(1).getCell(0).getStringCellValue();
			 pass = s1.getRow(1).getCell(1).getStringCellValue();*/
				
	}
	public void invalid_cred() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\sanji\\eclipse-workspace\\Project_1\\src\\DDT\\LoginQMP.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);
		Sheet s1 = w1.getSheet("Login");
		 username = s1.getRow(8).getCell(0).getStringCellValue();
		 pass = s1.getRow(8).getCell(1).getStringCellValue();
		
	}
}
