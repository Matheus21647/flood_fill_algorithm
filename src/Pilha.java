public class Pilha {
    private No topo;

    public Pilha() {
        this.topo = null;
    }


    public void push(Ponto ponto) {
        No novoNo = new No(ponto);
        novoNo.proximo = topo;
        topo = novoNo;
    }


    public Ponto pop() {
        if (estaVazia()) {
            return null;
        }
        Ponto pontoRemovido = topo.ponto;
        topo = topo.proximo;
        return pontoRemovido;
    }


    public boolean estaVazia() {
        return topo == null;
    }
}