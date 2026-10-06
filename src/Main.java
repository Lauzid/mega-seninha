import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int QTD_NUMEROS = 6;

    // Função de depuração. APAGAR DEPOIS.
    static String vetorParaTexto(int[] vetor){
        return Arrays.toString(vetor);
    }

    // Converte uma linha de texto em vetor de inteiros.
    static int[] converterLinhaParaVetor(String linha){
        int[] vetorInteiros = new int[QTD_NUMEROS];
        String[] partes = linha.split(" ");

        for (int i = 0; i < QTD_NUMEROS; i++){
            // Converte o texto da posição i em número e guarda na mesma posição do vetor
            vetorInteiros[i] = Integer.parseInt(partes[i]);
        }

        return vetorInteiros;
    }

    // Função verificadora da aposta vencedora.
    static boolean verificarVencedor(int[] sorteados, int[] aposta){
        for (int i = 0; i < QTD_NUMEROS; i++) {
            if (sorteados[i] != aposta[i]){
                return false;
            }
        }
        return true;
    }

    static void processarApostas() throws FileNotFoundException{
        File arquivo = new File("APOSTAS.TXT");
        Scanner entrada = new Scanner(arquivo);

        // Define os números sorteados lendo a primeira string do arquivo.
        int[] sorteados = converterLinhaParaVetor(entrada.nextLine());
        System.out.println("Sorteado: "+Arrays.toString(sorteados)); // Depuração. APAGAR DEPOIS.

        // Compara números sorteados com aposta.
        while (entrada.hasNextLine()){
            String cpf = entrada.nextLine();
            int[] aposta = converterLinhaParaVetor(entrada.nextLine());

            boolean ganhou = verificarVencedor(sorteados, aposta);

            // se a aposta ganhou (Parte 2), escrever o CPF formatado (Parte 3) no arquivo de saída.
            if (ganhou) {
                // Parte 3
            }
            System.out.println(cpf+" -> "+ganhou);
        }

        entrada.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        processarApostas();
    }
}