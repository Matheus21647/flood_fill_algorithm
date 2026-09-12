public class Fila {
    private No inicio;
    private No fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }


    public void enqueue(Ponto ponto) {
        No novoNo = new No(ponto);
        if (estaVazia()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }


    public Ponto dequeue() {
        if (estaVazia()) {
            return null;
        }
        Ponto pontoRemovido = inicio.ponto;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null; // Se a fila ficou vazia, o fim também deve ser nulo
        }
        return pontoRemovido;
    }


    public boolean estaVazia() {
        return inicio == null;
    }
}