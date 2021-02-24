package rough;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class WriteIntoExcel {

	public static void main(String[] args) {
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("data.xls");
		LinkedHashMap<Integer,String[]> lhm=new LinkedHashMap<Integer,String[]>();
		lhm.put(1, new String[] {"hi","hello","hola"});
		lhm.put(2, new String[] {"ram","shyam","kana"});
		
		Set<Integer> set=lhm.keySet();
		for(int s:set) {
			String[] str=lhm.get(s);
			int rowid=0;
			Row row=sheet.createRow(rowid++);
			
			for(String ss:str) {
				int cellid=0;
				Cell cell=row.createCell(cellid++);
				cell.setCellValue(ss);
			}
		}
		
		try {
			File file=new File("");
			FileOutputStream op=new FileOutputStream(file);
			wb.write(op);
			op.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
