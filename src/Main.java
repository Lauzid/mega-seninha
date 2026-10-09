import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static final int QTD_NUMEROS = 6;
    static final String ARQUIVO_ENTRADA = "APOSTAS.TXT";
    static final String ARQUIVO_SAIDA = "GANHADORES.TXT";

    // Converte uma linha de texto em vetor de inteiros.
    static int[] converterLinhaParaVetor(String linha){
        int[] vetorInteiros = new int[QTD_NUMEROS];
        String[] partes = linha.split(" ");

        // Converte o texto da posição i em número e guarda na mesma posição do vetor.
        for (int i = 0; i < QTD_NUMEROS; i++){
            vetorInteiros[i] = Integer.parseInt(partes[i]);
        }

        return vetorInteiros;
    }

    // Retorna true se a aposta tem os mesmos números do sorteio.
    static boolean verificarVencedor(int[] sorteados, int[] aposta){
        for (int i = 0; i < QTD_NUMEROS; i++) {
            if (sorteados[i] != aposta[i]){
                return false;
            }
        }
        return true;
    }

    // Formata o CPF separando por pontos e hífen usando regex que agrupa subconjuntos da string de input.
    static String formatarCPF(String cpfCru) {
        return cpfCru.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    // Percorre as apostas do arquivo, uma por vez, e grava no arquivo de saída
    // o CPF formatado de cada apostador que acertou os números sorteados.
    static void processarApostas(Scanner entrada, int[] sorteados, PrintWriter saida) {
        while (entrada.hasNextLine()){
            String cpf = entrada.nextLine();
            int[] aposta = converterLinhaParaVetor(entrada.nextLine());

            if (verificarVencedor(sorteados, aposta)) {
                saida.println(formatarCPF(cpf));
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File(ARQUIVO_ENTRADA));
        PrintWriter saida = new PrintWriter(ARQUIVO_SAIDA);
        int[] sorteados = converterLinhaParaVetor(entrada.nextLine());

        processarApostas(entrada, sorteados, saida);

        entrada.close();
        saida.close();
    }
}