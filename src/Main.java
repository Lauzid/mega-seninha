import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int QTD_NUMEROS = 6;

    // Função de depuração. APAGAR DEPOIS.
    static String vetorParaTexto(int[] vetor){
        return Arrays.toString(vetor);
    }

    /* [PARTE 01]
    Converte uma linha de texto em vetor de inteiros. */
    static int[] converterLinhaParaVetor(String linha){
        int[] vetorInteiros = new int[QTD_NUMEROS];
        String[] partes = linha.split(" ");

        for (int i = 0; i < QTD_NUMEROS; i++){
            // Converte o texto da posição i em número e guarda na mesma posição do vetor
            vetorInteiros[i] = Integer.parseInt(partes[i]);
        }

        return vetorInteiros;
    }

    /* [PARTE 02]
    Função verificadora da aposta vencedora. */
    static boolean verificarVencedor(int[] sorteados, int[] aposta){
        for (int i = 0; i < QTD_NUMEROS; i++) {
            if (sorteados[i] != aposta[i]){
                return false;
            }
        }
        return true;
    }

    /* [PARTE 03]
    Formatar o CPF. */


    /* [PARTE 04]
    Lê o sorteio (números 'vencedores') e processa apostas. */
    static void processarApostas(Scanner entrada, int[] sorteados) {
        // Compara números sorteados com aposta.
        while (entrada.hasNextLine()){
            String cpf = entrada.nextLine();
            int[] aposta = converterLinhaParaVetor(entrada.nextLine());

            // se a aposta ganhou (Parte 2), escrever o CPF formatado (Parte 3) no arquivo de saída.
            if (verificarVencedor(sorteados, aposta)) {
                // Formatação e gravação do CPF.
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File("APOSTAS.TXT"));
        int[] sorteados = converterLinhaParaVetor(entrada.nextLine());

        processarApostas(entrada, sorteados);

        entrada.close();
    }
}