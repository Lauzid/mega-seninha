

public class Main {
    static final int QTD_NUMEROS = 6;

    // Converte uma linha de texto em vetor de inteiros.
    static int[] converterLinhaParaNumeros(String linha){
        int[] vetorInteiros = new int[QTD_NUMEROS];
        String[] partes = linha.split(" ");

        for (int i = 0; i < QTD_NUMEROS; i++){
            // Converte o texto da posição i em número e guarda na mesma posição do vetor
            vetorInteiros[i] = Integer.parseInt(partes[i]);
        }

        return vetorInteiros;
    }

    public static void main(String[] args) {

    }
}