import java.io.*;
import java.nio.file.*;

import org.apache.commons.collections4.*;
import org.apache.poi.xssf.usermodel.*;
//make sure you set your classpaths to the jars included
//I do this with the command javac -cp .;* WriteExcel.java

public class WriteExcel 
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Path currentPath = Paths.get("");
		String path = currentPath.toAbsolutePath().toString();
		//setting up code to get the path without hardcoding it
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("FirstSheet");
		
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		
		cell.setCellValue("1. Cell");

		FileOutputStream fO = new FileOutputStream("D:\\PlanOfStudyProject\\PlanOfStudyProject\\test.xlsx");
		workbook.write(fO);
		workbook.close();
		
	}
}