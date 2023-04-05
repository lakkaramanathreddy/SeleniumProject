package generalLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExecelUtility {
	/*
	 * this class contain reusable methods with respect to excel
	 * @author SATURN
	 */
    private Workbook wb;
    /*
     * this method is used to initialize excel file
     * @param excelPath
     */
    public void excelInitialization(String excelPath) {
    	FileInputStream fis=null;
    	try {
    		fis=new FileInputStream(excelPath);
    	}catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	try {
    		wb=WorkbookFactory.create(fis);
    	}catch(EncryptedDocumentException | IOException e) {
    		e.printStackTrace();
    		
    	}
    }

    /*
     * this method is used to read single data from excel
     * @param SheetName
     * @param rownum
     * @param cellNum
     * @return
     */
    public Map<String, String> readData(String sheetName,int rowNum,int cellNUm) {
    	Map<String,String>map=new HashMap<>();
    	Sheet sh=wb.getSheet(sheetName);
    	for(int i=0;i<=sh.getLastRowNum();i++)
    	{
    		Cell cell0=sh.getRow(i).getCell(0);
    		Cell cell1=sh.getRow(i).getCell(1);
    		String key=cell0.getStringCellValue();
    		String value=cell1.getStringCellValue();
    		map.put(key, value);
    		}
		return map;
    	 }
    /*
     * this method is used to close the workbook
     */
    public void closeWorkbook() {
    	try {
    		wb.close();
    		}catch(IOException e) {
    			e.printStackTrace();
    			}
    }
}
    
