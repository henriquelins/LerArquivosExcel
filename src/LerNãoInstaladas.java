import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LerNãoInstaladas {

	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		
		List <NaoInstalados> listaNaoInstalados = new ArrayList<>();
		List <NaoInstalados> listaNaoInstalados2 = new ArrayList<>();
		List <String> listaOrcamento = new ArrayList<>();
		
		Workbook planilha01 = Workbook.getWorkbook(new File("C:\\Temp\\brisanet\\02.xls"));
		Sheet abaP1 = planilha01.getSheet(0);
		int linhasP1 = abaP1.getRows();
		
		Workbook planilha02 = Workbook.getWorkbook(new File("C:\\Temp\\brisanet\\OK.xls"));
		Sheet abaP2 = planilha02.getSheet(0);
		int linhasP2 = abaP2.getRows();
		
		int index = 1;
		String NUMERO_ORÇAMENTO_P2="";
		for (int i = 0; i < linhasP1; i++) {
			
			Cell a1P1 = abaP1.getCell(0, i);
			String NUMERO_ORÇAMENTO_P1 = a1P1.getContents();
			
			Cell a2P1 = abaP1.getCell(1, i);
			String DATA_DA_VENDA = a2P1.getContents();
				
			Cell a3P1 = abaP1.getCell(3, i);
			String VENDEDOR = a3P1.getContents();	
			
			Cell a4P1 = abaP1.getCell(5, i);
			String CLIENTE = a4P1.getContents();
			
			Cell a5P1 = abaP1.getCell(4, i);
			String CPF = a5P1.getContents();
			
			Cell a6P1 = abaP1.getCell(6, i);
			String PLANO = a6P1.getContents();
			
			Cell a7P1 = abaP1.getCell(6, i);
			String VALOR = a7P1.getContents();
			
			for (int j = 0; j < linhasP2; j++) {
				
				Cell a1P2 = abaP2.getCell(1, j);
				NUMERO_ORÇAMENTO_P2 = a1P2.getContents();
		
				if (NUMERO_ORÇAMENTO_P1.equalsIgnoreCase(NUMERO_ORÇAMENTO_P2)) {
					
					System.out.println(index + ";" + NUMERO_ORÇAMENTO_P1 + ";" + DATA_DA_VENDA + ";" + VENDEDOR.toUpperCase() + ";" + CLIENTE + ";" + CPF
							+ ";" + PLANO + ";" + VALOR);	
					
					listaNaoInstalados2.add(new NaoInstalados(index,NUMERO_ORÇAMENTO_P1,DATA_DA_VENDA,VENDEDOR,CLIENTE,CPF,PLANO,VALOR));
					
					index++;

				}
			}
			
			listaNaoInstalados.add(new NaoInstalados(i,NUMERO_ORÇAMENTO_P1,DATA_DA_VENDA,VENDEDOR,CLIENTE,CPF,PLANO,VALOR));
			listaOrcamento.add(NUMERO_ORÇAMENTO_P2);
		}
		
		planilha01.close();
		planilha02.close();
		
		System.out.println(listaNaoInstalados.size());
		System.out.println(listaNaoInstalados2.size());
		System.out.println(listaOrcamento.size());
		
		boolean isEqual = listaNaoInstalados.equals(listaNaoInstalados2);      //false
        System.out.println(isEqual);
	
        listaNaoInstalados2.retainAll(listaNaoInstalados);
        
        System.out.println(listaNaoInstalados2);
        
        
        List<NaoInstalados> destino = new ArrayList<>();



        for(NaoInstalados item : listaNaoInstalados){
            for(NaoInstalados array: listaNaoInstalados2){
                if(array.getId() == item.getId()){
                    if(!destino.contains(item)){
                        destino.add(item);
                    }
                }
            }
        }
        
        System.out.println(destino.size());

	}

}
