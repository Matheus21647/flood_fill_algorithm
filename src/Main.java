import java.awt.Color;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            int xInicial = 10;
            int yInicial = 10;
            int frequenciaFrames = 20; // frequencia que os arquivos de animacao sao gerados (ex: salva um png a cada x pixels pintados)

            //TESTE COM PILHA
            System.out.println("Executando com Pilha...");
            ManipuladorImagem imgPilha = new ManipuladorImagem("entrada.png", "frames_pilha");
            FloodFill.executarComPilha(imgPilha, xInicial, yInicial, Color.GREEN, frequenciaFrames);
            imgPilha.salvarImagemFinal("saida_pilha.png");
            System.out.println("Pilha finalizada! Salvo em saida_pilha.png e pasta 'frames_pilha'.");

            //TESTE COM FILA
            System.out.println("Executando com Fila...");
            ManipuladorImagem imgFila = new ManipuladorImagem("entrada.png", "frames_fila");
            FloodFill.executarComFila(imgFila, xInicial, yInicial, Color.ORANGE, frequenciaFrames);
            imgFila.salvarImagemFinal("saida_fila.png");
            System.out.println("Fila finalizada! Salvo em saida_fila.png e pasta 'frames_fila'.");

        } catch (IOException e) {
            System.out.println("Erro ao processar a imagem: " + e.getMessage());
        }
    }
}