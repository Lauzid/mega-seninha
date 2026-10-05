

public class Main {
    static final int QTD_NUMEROS = 6;

    // Converte uma linha de texto em vetor de inteiros.
    static int[] converterLinhaParaNumeros(String aposta){
        int[] vetorInteiros = new int[QTD_NUMEROS];
        String[] partes = aposta.split(" ");
        String parte;;

        for (int i = 0; i < QTD_NUMEROS; i++){
            parte = partes[i];;

        }

        return vetorInteiros;
    }

    public static void main(String[] args) {
        converterLinhaParaNumeros("04 17 23 38 45 59");
    }
}