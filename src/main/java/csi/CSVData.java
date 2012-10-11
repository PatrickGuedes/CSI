package csi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe para manipular os arquivos CSV.
 *
 * @author Murilo Ito, Janaina Cheim, Alexandre Jimenez e Patrick Guedes.
 */
public class CSVData {
	
	/// Caminho para o arquivo CSV.
	private String arquivo;
	/// Número de colunas que o CSV deve conter para ser válido.
	private int nColunas;
	
	/**
	 * Construtor.
	 * 
	 * @param arquivo Arquivo CSV que será manipulado.
	 * @param nColunas Número de colunas que o CSV deve conter para ser válido.
	 */
	public CSVData(String arquivo, int nColunas) {
		this.arquivo = arquivo;
		this.nColunas = nColunas;
	}
	
	/**
	 * Retorna um registro do arquivo CSV conforme dados informados para busca.
	 * 
	 * @param coluna Índice da coluna desejada para comparar (começando em 0).
	 * @param valor Valor que a coluna deve conter.
	 * 
	 * @return Se não encontrar o registro será retornado 'null'. Caso contrário
	 * será retornado um ArrayList<String> com os dados do registro.
	 */
	public ArrayList<String> getRegitro(int coluna, String valor) {
		ArrayList<String> retorno = null;
		String[] registro;
		String line;
		
		// passou uma coluna invalida
		if (coluna >= nColunas) {
			return null;
		}

		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();
		
			while (line != null) {
				registro = line.trim().split(",");
				
				// achou o registro
				if (registro.length == nColunas && registro[coluna].equals(valor)) {
					retorno = new ArrayList(Arrays.asList(registro));
					break;
				}
				
				line = br.readLine();
			}
			
			br.close();
			fr.close();

		} catch(Exception e) {
			return null;
		}
		
		
		return retorno;
	}
	
	
	/**
	 * Lê e retorna todos os registros do arquivo CSV. Realiza a validação se o
	 * número de colunas está correto.
	 * 
	 * @return ArrayList<ArrayList<String>> representando uma matriz dos dados.
	 */
	public ArrayList<ArrayList<String>> getTodosRegistros() {
		ArrayList<ArrayList<String>> retorno = new ArrayList<ArrayList<String>>();
		String[] registro;
		String line;
		int n = 0;

		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();
			
			while (line != null) {
				registro = line.trim().split(",");
				
				// acho o registro
				if (registro.length == nColunas) {
					retorno.add( new ArrayList(Arrays.asList(registro)) );
				}
				
				line = br.readLine();
			}
			
			br.close();
			fr.close();

		} catch(Exception e) {
			return retorno;
		}
		
		return retorno;
	}
}
