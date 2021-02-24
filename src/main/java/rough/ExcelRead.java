package rough;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelRead {

	public static void main(String[] args) {
		try {
		File file=new File("/home/data.xls");
		FileInputStream ip=new FileInputStream(file);
		HSSFWorkbook wb=new HSSFWorkbook(ip);
		HSSFSheet sheet=wb.getSheetAt(0);
		//Row row=sheet.getRow(0);
		Iterator<Row> rowit=sheet.rowIterator();
		
		while(rowit.hasNext()) {
			Row row=rowit.next();
			
			Iterator<Cell> cellit=row.cellIterator();
			while(cellit.hasNext()) {
				Cell cell=cellit.next();
				switch(cell.getCellType()) {
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.println(cell.getStringCellValue());
				}
			}
		}
		
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
