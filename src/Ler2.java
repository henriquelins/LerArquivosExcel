import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Ler2 {

	public static void main(String[] args) throws IOException, BiffException {

		Workbook planilha01 = Workbook.getWorkbook(new File("C:\\Temp\\brisanet\\01.xls"));
		Sheet abaP1 = planilha01.getSheet(0);
		int linhasP1 = abaP1.getRows();
		System.out.println(linhasP1);

		Workbook planilha02 = Workbook.getWorkbook(new File("C:\\Temp\\brisanet\\02.xls"));
		Sheet abaP2 = planilha02.getSheet(0);
		int linhasP2 = abaP2.getRows();
		System.out.println(linhasP2);

		System.out.println("VENDAS FINALIZADAS");
		System.out.println(
				"ID;Nº ORÇAMENTO;DATA DA VENDA;DATA DE INSTALAÇÃO;CANAL;VENDEDOR;REVAN;CIDADE;CLIENTE;CPF;PLANO;VALOR;FINALIZADA");

		// List <String> listaInstalados = new ArrayList<>();

		int index = 1;
		for (int i = 0; i < linhasP1; i++) {

			Cell a1P1 = abaP1.getCell(0, i);
			String NUMERO_ORÇAMENTO = a1P1.getContents();

			Cell a2P1 = abaP1.getCell(4, i);
			String DATA_DE_INSTALAÇÃO = a2P1.getContents();

			Cell a3P1 = abaP1.getCell(13, i);
			String REVAN = a3P1.getContents();

			Cell a4P1 = abaP1.getCell(14, i);
			String CIDADE = a4P1.getContents();

			Cell a5P1 = abaP1.getCell(12, i);
			String CLIENTE = a5P1.getContents();

			for (int j = 0; j < linhasP2; j++) {

				Cell a1P2 = abaP2.getCell(0, j);
				String coluna1P2 = a1P2.getContents();

				Cell a2P2 = abaP2.getCell(1, j);
				String DATA_DA_VENDA = a2P2.getContents();

				Cell a4P2 = abaP2.getCell(3, j);
				String VENDEDOR = a4P2.getContents();

				Cell a5P2 = abaP2.getCell(4, j);
				String CPF = a5P2.getContents();

				Cell a6P2 = abaP2.getCell(6, j);
				String PLANO = a6P2.getContents();

				Cell a7P2 = abaP2.getCell(7, j);
				String VALOR = a7P2.getContents();

				if (NUMERO_ORÇAMENTO.equalsIgnoreCase(coluna1P2)) {
					System.out.println(index + ";" + NUMERO_ORÇAMENTO + ";" + DATA_DA_VENDA + ";" + DATA_DE_INSTALAÇÃO
							+ ";" + VENDEDOR.toUpperCase() + ";" + REVAN + ";" + CIDADE + ";" + CLIENTE + ";" + CPF
							+ ";" + PLANO + ";" + VALOR);
					index++;

					/*
					 * listaInstalados.add(index+";"+NUMERO_ORÇAMENTO+";"+DATA_DA_VENDA+";"+
					 * DATA_DE_INSTALAÇÃO+ ";"+VENDEDOR.toUpperCase()+";"+REVAN+";"+CIDADE+
					 * ";"+CLIENTE+";"+CPF+";"+PLANO+";"+VALOR);
					 */

				}

			}

		}
		planilha01.close();
		planilha02.close();
	}

}
