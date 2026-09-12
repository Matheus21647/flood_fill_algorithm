import java.awt.Color;
import java.io.IOException;

public class FloodFill {

    // Método Flood Fill utilizando PILHA (LIFO)
    public static void executarComPilha(ManipuladorImagem img, int xInicial, int yInicial, Color novaCorObj) {
        int corFundoOriginal = img.getCor(xInicial, yInicial);
        int novaCorInt = novaCorObj.getRGB();

        // Se a cor inicial já for igual à nova cor n faz nada
        if (corFundoOriginal == novaCorInt) {
            return;
        }

        Pilha pilha = new Pilha();
        pilha.push(new Ponto(xInicial, yInicial));

        while (!pilha.estaVazia()) {
            Ponto p = pilha.pop();
            int x = p.getX();
            int y = p.getY();

            //  Verifica se está dentro dos limites da imagem
            //   Verifica se a cor do pixel atual é igual à cor de fundo original
            if (img.coordenadaValida(x, y) && img.getCor(x, y) == corFundoOriginal) {

                // Pinta o pixel
                img.setCor(x, y, novaCorInt);

                // Salva o frame pra  animação
                img.salvarFrameAnimacao(1);

                // Empilha os 4 vizinhos laterais (cima, baixo, esquerda, direita)
                pilha.push(new Ponto(x, y - 1)); // Cima
                pilha.push(new Ponto(x, y + 1)); // Baixo
                pilha.push(new Ponto(x - 1, y)); // Esquerda
                pilha.push(new Ponto(x + 1, y)); // Direita
            }
        }
    }

    // Método Flood Fill utilizando FILA (FIFO)
    public static void executarComFila(ManipuladorImagem img, int xInicial, int yInicial, Color novaCorObj) {
        int corFundoOriginal = img.getCor(xInicial, yInicial);
        int novaCorInt = novaCorObj.getRGB();

        if (corFundoOriginal == novaCorInt) {
            return;
        }

        Fila fila = new Fila();
        fila.enqueue(new Ponto(xInicial, yInicial));

        while (!fila.estaVazia()) {
            Ponto p = fila.dequeue();
            int x = p.getX();
            int y = p.getY();

            //  Verifica limites
            //  Verifica se a cor corresponde ao fundo original
            if (img.coordenadaValida(x, y) && img.getCor(x, y) == corFundoOriginal) {

                // Pinta o pixel
                img.setCor(x, y, novaCorInt);

                // Salva o frame para a animação
                img.salvarFrameAnimacao(10);

                // Enfileira os 4 vizinhos laterais (cima, baixo, esquerda, direita)
                fila.enqueue(new Ponto(x, y - 1)); // Cima
                fila.enqueue(new Ponto(x, y + 1)); // Baixo
                fila.enqueue(new Ponto(x - 1, y)); // Esquerda
                fila.enqueue(new Ponto(x + 1, y)); // Direita
            }
        }
    }
}