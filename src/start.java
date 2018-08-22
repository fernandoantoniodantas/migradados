import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class start {
	
	
	public static String trataData(String x) {
		if (x.equals("antes de 2014")) {
			return "31/12/2013";
		}else {
			return x;
		}
	}
	
	public static String jogaNull(String x) {
		if ((x.length() == 0) || (x.equals("XXXX"))) {
			return null;
		}else {
			return "'"+x+"'";
		}		 
	}

	public static void main(String[] args) throws BiffException, IOException {
					Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\fernando\\eclipse-workspace\\ImportacaoAPAE\\BASE_APAE_JULHO.xls"));
					Sheet sheet = workbook.getSheet(0);
					int linhas = sheet.getRows();
					
					 FileWriter arq = new FileWriter("C:\\Users\\fernando\\eclipse-workspace\\ImportacaoAPAE\\scriptApae.sql");
					 PrintWriter gravarArq = new PrintWriter(arq);
					
					for(int i = 1; i < linhas; i++){
						Cell a1 = sheet.getCell(0, i);
						Cell a2 = sheet.getCell(1, i);
						Cell a3 = sheet.getCell(2, i);
						Cell a4 = sheet.getCell(3, i);
						Cell a5 = sheet.getCell(4, i);
						Cell a6 = sheet.getCell(5, i);
						Cell a7 = sheet.getCell(6, i);
						Cell a8 = sheet.getCell(7, i);
						Cell a9 = sheet.getCell(8, i);
						Cell a10 = sheet.getCell(11, i);
						Cell a11 = sheet.getCell(12, i);						
						Cell a12 = sheet.getCell(13, i);
						Cell a13= sheet.getCell(14, i);
						Cell a14 = sheet.getCell(15, i);
						Cell a15 = sheet.getCell(16, i);
						Cell a16 = sheet.getCell(19, i);
						Cell a17 = sheet.getCell(20, i);
						Cell a18 = sheet.getCell(22, i);
	
						Cell a19 = sheet.getCell(29, i);
						Cell a20 = sheet.getCell(30, i);
						Cell a21 = sheet.getCell(31, i);
						Cell a22 = sheet.getCell(42, i);
									
						
							
						
						
						
						String as1 = a1.getContents();
						String dataCadastro = a2.getContents();
						String codant2 = a3.getContents().trim();
						String nome = a4.getContents().trim();
						String cpf = a5.getContents().trim();
						String rg = a6.getContents().trim();
						String prontuario = a7.getContents().trim();
						String cns = a8.getContents().trim();
						String dtanascimento = a9.getContents().trim();
						String mae = a10.getContents().trim();
						String nomeresp = a11.getContents().trim();						
						String logradouro = a12.getContents().trim();
						String numero = a13.getContents().trim();
						String bairro = a14.getContents().trim();
						String cidade = a15.getContents().trim();
						String cep = a16.getContents().trim();
						String sexo = a17.getContents().trim();
						String codraca = a18.getContents().trim();						
						String tel1 = a19.getContents().trim();
						String tel2 = a20.getContents().trim();
						String tel3 = a21.getContents().trim();
						String cid = a22.getContents().trim();
						
						
						
						

			
						System.out.println("linha->"+i);
						
						//INSERT INTO PACIENTES (, , ESTCIVIL, CONJUGE, , , , PAI, , , COMPLEMENTO, REFERENCIA, , , , OE, DTAEXPEDICAORG,  , , , , , ) VALUES (1, 04541, 'XXXXXXXXXXXXXXX', 'ABIMAEL SILVA DO NASCIMENTO', null, null, 'M', '1989/08/10 00:00:00', 'MARIA NAZARÉ SILVA DO NASCIMENTO', null, 5703933, 228, null, null, 33551868, null, null, 'null', null, null, 1458128474, 206566815720001, 'MACEIÓ', 'RUA AMERICO VASCO', 'RIACHO DOCE', 04, 'F83', 'null'); 
						gravarArq.printf("INSERT INTO PACIENTES (CODPACIENTE, CODANTPACIENTE2, NOME, CPF, RG, CODANTPACIENTE, CNS, DTANASCIMENTO, MAE, NOMERESP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, CEP, SEXO, CODRACA, TELRES, TELCEL, TELTRAB, CID, DTACADASTRO) VALUES ("+i+", '"+codant2+"', '"+nome+"', "+cpf+", "+jogaNull(rg)+", "+jogaNull(prontuario)+", "+jogaNull(cns)+", "+jogaNull(dtanascimento)+", "+jogaNull(mae)+", "+jogaNull(nomeresp)+", "+jogaNull(logradouro)+", "+jogaNull(numero)+", "+jogaNull(bairro)+", "+jogaNull(cidade)+", "+cep+", "+jogaNull(sexo)+", "+codraca+", '"+jogaNull(tel1)+"', '"+jogaNull(tel2)+"', '"+jogaNull(tel3)+"', '"+jogaNull(cid)+"', '"+trataData(dtanascimento)+"' );\n");
					}
					gravarArq.close();
					
					
				

	}

}
