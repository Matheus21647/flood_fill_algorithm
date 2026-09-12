import java.awt.Color;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando o processo de Flood Fill...");

            // Carrega a imagem original (certificar de ter uma imagem chamada entrada.png na raiz)
            ManipuladorImagem imagemPilha = new ManipuladorImagem("entrada.png");

            // Define o ponto de partida e a nova cor
            int xInicial = 10;
            int yInicial = 10;
            Color novaCor = Color.BLUE;

            //Executa usando a PILHA
            System.out.println("Executando com Pilha...");
            FloodFill.executarComPilha(imagemPilha, xInicial, yInicial, novaCor);

            //Salva a imagem final da pilha
            imagemPilha.salvarImagemFinal("saida_pilha.png");
            System.out.println("Processo com Pilha finalizado! Salvo como saida_pilha.png");


            //Teste da fila
            ManipuladorImagem imagemFila = new ManipuladorImagem("entrada.png");
            System.out.println("Executando com Fila...");
            FloodFill.executarComFila(imagemFila, xInicial, yInicial, Color.RED);
            imagemFila.salvarImagemFinal("saida_fila.png");
            System.out.println("Processo com Fila finalizado! Salvo como saida_fila.png");


        } catch (IOException e) {
            System.out.println("Erro ao processar a imagem: " + e.getMessage());
        }
    }
}