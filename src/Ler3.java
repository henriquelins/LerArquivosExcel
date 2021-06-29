import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class Ler3 {

	public static void main(String[] args) throws IOException, BiffException, WriteException {

		Workbook planilha01 = Workbook.getWorkbook(new File("C:\\Temp\\brisanet\\02.xls"));
		Sheet abaP1 = planilha01.getSheet(0);
		int linhasP1 = abaP1.getRows();

		Workbook planilha02 = Workbook.getWorkbook(new File("C:\\Temp\\brisanet\\01.xls"));
		Sheet abaP2 = planilha02.getSheet(0);
		int linhasP2 = abaP2.getRows();
		int index = 1;
		for (int i = 1; i < linhasP1; i++) {
			
			Cell a1P1 = abaP1.getCell(0, i);
			String NUMERO_ORÇAMENTO_P1 = a1P1.getContents();
			
			for (int j = 1; j < linhasP2; j++) {
				
				Cell a1P2 = abaP2.getCell(0, j);
				String NUMERO_ORÇAMENTO_P2 = a1P2.getContents();
				
				if (!NUMERO_ORÇAMENTO_P1.equalsIgnoreCase(NUMERO_ORÇAMENTO_P2)) {
					
			
						
						System.out.println(index + ";" + NUMERO_ORÇAMENTO_P2);
						
			
					
						
					
				
					
					index++;

				}
				
			}

		}

		planilha01.close();
		planilha02.close();

	}

}
