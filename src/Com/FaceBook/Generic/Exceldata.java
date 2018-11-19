package Com.FaceBook.Generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exceldata 
{
	public static String getData(String Filepath, String SheetName, int rn ,int cn) 
	{
		try
		{
			FileInputStream fis=new FileInputStream(new File(Filepath));
			Workbook wb=WorkbookFactory.create(fis);
		    Cell  c = wb.getSheet(SheetName).getRow(rn).getCell(cn);
		     String data = c.toString();
		     return data;
			}
		catch(Exception e)
		{
			return "";
		}
		
	}	


    public static int getRowCount(String Filepath, String SheetName)
    {

    try
    {
	  FileInputStream fis=new FileInputStream(new File(Filepath));
	  Sheet sh=WorkbookFactory.create(fis).getSheet(SheetName);
    
       int rc= sh.getLastRowNum();
    
         return  rc ;
	 }
    catch(Exception e)
  {
	return 0;
  }
    }
    
    public static int getCellCount(String Filepath, String SheetName, int rn)
    {

    try
    {
	  FileInputStream fis=new FileInputStream(new File(Filepath));
	  Sheet sh=WorkbookFactory.create(fis).getSheet(SheetName);
    
       int cc= sh.getRow(rn).getLastCellNum();
    
         return  cc;
	 }
    catch(Exception e)
  {
	return 0;
  }
    }


	
}




