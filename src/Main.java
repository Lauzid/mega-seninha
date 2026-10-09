import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static final int QTD_NUMEROS = 6;

    /* [PARTE 01]
    Converte uma linha de texto em vetor de inteiros. */
    static int[] converterLinhaParaVetor(String linha){
        int[] vetorInteiros = new int[QTD_NUMEROS];
        String[] partes = linha.split(" ");

        // Converte o texto da posição i em número e guarda na mesma posição do vetor.
        for (int i = 0; i < QTD_NUMEROS; i++){
            vetorInteiros[i] = Integer.parseInt(partes[i]);
        }

        return vetorInteiros;
    }

    /* [PARTE 02]
    Compara todas apostas com números sorteados. Retorna true para vencedores e false para os restantes. */
    static boolean verificarVencedor(int[] sorteados, int[] aposta){
        for (int i = 0; i < QTD_NUMEROS; i++) {
            if (sorteados[i] != aposta[i]){
                return false;
            }
        }
        return true;
    }

    /* [PARTE 03]
    Formata o CPF separando por pontos e hífen usando regex que agrupa subconjuntos da string de input. */
    static String formatarCPF(String cpfCru) {
        return cpfCru.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    /* [PARTE 04]
    Analisa o sorteio para processar apostas. */
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
        PrintWriter saida = new PrintWriter("GANHADORES.TXT");
        Scanner entrada = new Scanner(new File("APOSTAS.TXT"));
        int[] sorteados = converterLinhaParaVetor(entrada.nextLine());

        processarApostas(entrada, sorteados, saida);

        entrada.close();
        saida.close();
    }
}