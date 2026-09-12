import java.awt.Color;
import java.io.IOException;

public class FloodFill {

    // Método Flood Fill utilizando PILHA (LIFO)
    public static void executarComPilha(ManipuladorImagem img, int xInicial, int yInicial, Color novaCorObj, int frequencia) {
        int corFundoOriginal = img.getCor(xInicial, yInicial);
        int novaCorInt = novaCorObj.getRGB();

        if (corFundoOriginal == novaCorInt) {
            return;
        }

        Pilha pilha = new Pilha();
        pilha.push(new Ponto(xInicial, yInicial));

        while (!pilha.estaVazia()) {
            Ponto p = pilha.pop();
            int x = p.getX();
            int y = p.getY();

            if (img.coordenadaValida(x, y) && img.getCor(x, y) == corFundoOriginal) {
                img.setCor(x, y, novaCorInt);

                // Usa a frequência que veio do Main para salvar os arquivos para fazer a animacao
                img.salvarFrameAnimacao(frequencia);

                pilha.push(new Ponto(x, y - 1));
                pilha.push(new Ponto(x, y + 1));
                pilha.push(new Ponto(x - 1, y));
                pilha.push(new Ponto(x + 1, y));
            }
        }
    }


    // Método Flood Fill utilizando FILA (FIFO)
    public static void executarComFila(ManipuladorImagem img, int xInicial, int yInicial, Color novaCorObj, int frequencia) {
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
                img.salvarFrameAnimacao(frequencia);

                // Enfileira os 4 vizinhos laterais (cima, baixo, esquerda, direita)
                fila.enqueue(new Ponto(x, y - 1)); // Cima
                fila.enqueue(new Ponto(x, y + 1)); // Baixo
                fila.enqueue(new Ponto(x - 1, y)); // Esquerda
                fila.enqueue(new Ponto(x + 1, y)); // Direita
            }
        }
    }
}