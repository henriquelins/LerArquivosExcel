import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Ler {

	private static WritableCellFormat tahomaBoldUnderline;
	private static WritableCellFormat tahoma;

	private static void criaLabel(WritableSheet sheet, String vendedor) throws WriteException {
		// Cria o tipo de fonte como TIMES e tamanho
		WritableFont Tahoma10pt = new WritableFont(WritableFont.TAHOMA, 10);

		// Define o formato da célula
		tahoma = new WritableCellFormat(Tahoma10pt);
		tahoma.setAlignment(Alignment.CENTRE);
		tahoma.setBorder(Border.ALL, BorderLineStyle.THIN);

		// Efetua a quebra automática das células
		// times.setWrap(true);

		// Cria a fonte em negrito com underlines
		WritableFont tahoma10ptBoldUnderline = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.BOLD, false);
		// UnderlineStyle.SINGLE);
		tahomaBoldUnderline = new WritableCellFormat(tahoma10ptBoldUnderline);

		// Efetua a quebra automática das células
		// timesBoldUnderline.setWrap(true);
		tahomaBoldUnderline.setAlignment(Alignment.CENTRE);
		tahomaBoldUnderline.setBackground(Colour.GRAY_25);
		tahomaBoldUnderline.setBorder(Border.ALL, BorderLineStyle.THIN);

		CellView cv = new CellView();
		cv.setFormat(tahoma);// Bom pessoal, é isso ai, qualquer dúvida é só avisar.
		cv.setFormat(tahomaBoldUnderline);

		// Escreve os cabeçalhos

		// MESCLAR CÉLULAS: colunaInicial, linhaInicial, colunaFinal, linhaFinal
		sheet.mergeCells(0, 0, 10, 0);

		addCaption(sheet, 0, 0, "LISTA DE INSTALADOS");

		addCaption(sheet, 0, 1, "ID");
		addCaption(sheet, 1, 1, "Nº ORÇAMENTO");
		addCaption(sheet, 2, 1, "DATA DA VENDA");
		addCaption(sheet, 3, 1, "DATA DE INSTALAÇÃO");
		addCaption(sheet, 4, 1, "VENDEDOR");
		addCaption(sheet, 5, 1, "REVAN");
		addCaption(sheet, 6, 1, "CIDADE");
		addCaption(sheet, 7, 1, "CLIENTE");
		addCaption(sheet, 8, 1, "CPF");
		addCaption(sheet, 9, 1, "PLANO");
		addCaption(sheet, 10, 1, "VALOR");

	}

	private static void defineConteudo(WritableSheet sheet, List<Vendas> listaVendas)
			throws WriteException, RowsExceededException {

		int i = 2;
		for (Vendas v : listaVendas) {

			new DecimalFormat("000");

			addLabel(sheet, 0, i, String.valueOf(v.getId()));
			addLabel(sheet, 1, i, v.getOrcamento());
			addLabel(sheet, 2, i, v.getDtVenda());
			addLabel(sheet, 3, i, v.getDtInstalacao());
			addLabel(sheet, 4, i, v.getVendedor().toUpperCase());
			addLabel(sheet, 5, i, v.getRevan());
			addLabel(sheet, 6, i, v.getCidade().toUpperCase());
			addLabel(sheet, 7, i, v.getCliente().toUpperCase());
			addLabel(sheet, 8, i, v.getCpf());
			addLabel(sheet, 9, i, v.getPlano().toUpperCase());
			addLabel(sheet, 10, i, v.getValor());

			i++;
		}

	}

	// Adiciona cabecalho
	private static void addCaption(WritableSheet planilha, int coluna, int linha, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(coluna, linha, s, tahomaBoldUnderline);
		planilha.addCell(label);
	}

	private static void addLabel(WritableSheet planilha, int coluna, int linha, String s)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(coluna, linha, s, tahoma);
		planilha.addCell(label);
	}

	public static void main(String[] args) throws IOException, BiffException, WriteException {

		List<Vendas> listaVendas = new ArrayList<>();

		Workbook planilha01 = Workbook.getWorkbook(new File("C:\\Temp\\brisanet\\01.xls"));
		Sheet abaP1 = planilha01.getSheet(0);
		int linhasP1 = abaP1.getRows();

		Workbook planilha02 = Workbook.getWorkbook(new File("C:\\Temp\\brisanet\\02.xls"));
		Sheet abaP2 = planilha02.getSheet(0);
		int linhasP2 = abaP2.getRows();

		System.out.println("VENDAS FINALIZADAS");
		System.out.println(
				"ID;Nº ORÇAMENTO;DATA DA VENDA;DATA DE INSTALAÇÃO;CANAL;VENDEDOR;REVAN;CIDADE;CLIENTE;CPF;PLANO;VALOR");

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

					listaVendas.add(new Vendas(index, NUMERO_ORÇAMENTO, DATA_DA_VENDA, DATA_DE_INSTALAÇÃO, VENDEDOR,
							REVAN, CIDADE, CLIENTE, CPF, PLANO, VALOR));

					index++;

				}

			}

			List<String> teste = new ArrayList<>();

			for (int h = 0; h < linhasP2; h++) {

				Cell a1P2 = abaP2.getCell(0, h);
				String ORCAMENTO = a1P2.getContents();

				if (listaVendas.contains(ORCAMENTO)) {

					teste.add(ORCAMENTO);

				}

			}

			for (String s : teste) {
				System.out.println("ok");
			}

		}

		planilha01.close();
		planilha02.close();

		String inputArquivo = "C:\\Temp\\brisanet\\OK.xls";

		File arquivo = new File(inputArquivo);
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("pt", "BR"));
		WritableWorkbook workbook = Workbook.createWorkbook(arquivo, wbSettings);

		workbook.createSheet("Lista Instalados", 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		criaLabel(excelSheet, "Vendas Finalizadas");
		defineConteudo(excelSheet, listaVendas);

		workbook.write();
		workbook.close();

		// Runtime.getRuntime().exec("cmd.exe /C start excel.exe " + inputArquivo);

	}

}
