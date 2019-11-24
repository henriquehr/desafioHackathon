package anagrama;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class anagrama {
		
	/*
	 * Passo a passo:
	 * Verifica a entrada da linha de comando
	 * Verifica se a entrada é válida
	 * Limpa a entrada
	 * Ordena a entrada
	 * Carrega o arquivo palavras.txt e lê cada linha
	 * Limpa e ordena cada linha
	 * Compara a entrada com a linha
	 * Imprime a linha se forem iguais
	 * 
	 * Complexidade:
	 * Considere 'p' o número de palavras no arquivo e 'n' o tamanho de cada palavra.
	 * Para cada palavra no arquivo o algoritmo ordena ela uma vez.
	 * Ordenar uma palavra é O(n log n).
	 * Percorrer todas as palavras é O(p).
	 * Logo a complexidade total é: O(p * (n log n))
	 * 
	 */
    public static void main(String[] args) {
    	final String FILE_NAME = "palavras.txt";
    	
    	if (!isArgsValid(args)) {
    		System.exit(-1);
    	}    	
    	
    	String input = args[0];
    	
    	if (!isStringValid(input)) {
    		System.out.println("Entrada inválida.");
    		System.exit(-1);
    	}

    	String inputReady = makeStringReady(input);
    	
    	readFileAndPrintAnagrams(inputReady, FILE_NAME);
    	
    }
    
    /**
     * Verifica se o argumento da linha de comando é válido e imprime o motivo se não for válido, 
     * deve ser exatamente 1 argumento. 
     * @param args o argumento da linha de comando
     * @return <code>true</code> se o argumanto é válido, <code>false</code> caso contrário
     */
    static boolean isArgsValid(String[] args) {
    	if (args.length != 1) {
    		if (args.length == 0) {
    			System.out.println("Parâmetro vazio.");
    		} else if (args.length > 1) {
    			System.out.println("Mais de um parâmetro.");    			
    		}
    		System.out.println("Uso: ./anagrama \"expressão entre aspas\"");
    		return false;
    	}
    	return true;
    }
    
    /**
     * Verifica se a <code>String</code> é válida, não <code>null</code>, não vazia e tem apenas letras ou letras e espaços.
     * @param input uma <code>String</code>
     * @return <code>true</code> se a intrada for válida, <code>false</code> caso contrário.
     */
	static boolean isStringValid(String input) {
		if (input == null || 
			input.isBlank() ||
			!input.matches("^[a-zA-Z\\s]+$")) {
			return false;
		}
		return true;
	}
    
	/**
	 * Limpa ({@link #cleanString}) e ordena ({@link #sortString}) uma <code>String</code>
	 * @param input uma <code>String</code>
	 * @return <code>String</code> limpa e ordenada
	 */
	static String makeStringReady(String input) {
		if (input == null) {
			return "";
		}
    	
    	String result = cleanString(input);
    	result = sortString(result);
    	return result;
	}
	
    /**
     * Transforma a entrada para letras maiúsculas e remove espaços em branco.  
     * @param input uma <code>String</code>
     * @return A <code>String</code> em letras maiúsculas e sem espaços em branco
     *  ou "" se a <code>String</code> for <code>null</code>
     */
	static String cleanString(String input) {
		if (input == null) {
			return "";
		}
		
		String result = input.replaceAll("\\s", "");
		result = result.toUpperCase();
    	return result;
	}
	
	/**
	 * Ordena a <code>String</code> em ordem crescente.
	 * @param input uma <code>String</code>
	 * @return A <code>String</code> ordenada, "" se o <code>String</code> for <code>null</code>
	 */
	static String sortString(String input) {
		if (input == null) {
			return "";
		}
		
		char[] sorted = input.toCharArray();
		Arrays.sort(sorted);
		return new String(sorted);
	}
	
	/**
	 * Lê cada linha do arquivo e compara com a entrada, se elas forem anagramas, imprime a linha.
	 * @param input uma <code>String</code>
	 * @param fileName o arquivo de texto contendo todas as palavras
	 */
	static void readFileAndPrintAnagrams(String inputReady, String fileName) {
		if (inputReady == null || fileName == null) {
			return;
		}
		FileReader fileReader = null;
		BufferedReader fileBuffer = null;
		try {
			fileReader = new FileReader(fileName);
			fileBuffer = new BufferedReader(fileReader);

			String line;
			while ((line = fileBuffer.readLine()) != null) {
				
				String lineReady = makeStringReady(line);
				
				boolean isAnagram = lineReady.equals(inputReady);
				
				if (isAnagram) {
					System.out.println(line);
				}
				
			}
		
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo " + fileName);
			System.exit(-1);
		} finally {
			try {
				fileBuffer.close();
				fileReader.close();			
			} catch (IOException e) {
				System.exit(-1);
			}
		}
	}

}
