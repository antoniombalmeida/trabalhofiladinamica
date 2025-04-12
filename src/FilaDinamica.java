public class FilaDinamica implements IEstruturaDinamica {
    private No primeiro;
    private No ultimo;
    private No anterior;
    private int qntdElementos;

    public FilaDinamica() {
        this.primeiro = null;
        this.ultimo = null;
        this.qntdElementos = 0;
    }
    @Override
    public void inserirElemento(Integer elemento) {
        No novoNo = new No (elemento);
        if (estaVazia()) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
            qntdElementos = 1;
        }
        else {
            novoNo.setAnterior(ultimo);
            this.ultimo.setProx(novoNo);
            this.ultimo = novoNo;
            this.qntdElementos++;
        }
    }

    @Override
    public void inserirSequencia(Integer[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            this.inserirElemento(elementos[i]);
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) {
            return false;
        }
        if (this.primeiro == this.ultimo) {
            this.primeiro = null;
            this.ultimo = null;
        } else {
            this.primeiro = this.primeiro.getProx();
            this.primeiro.setAnterior(null);
        }
        this.qntdElementos--;
        return true;
    }


    @Override
    public void removerSequencia(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            this.removerElemento();
        }
    }

    @Override
    public void removerTodasOcorrencias(Integer elemento) {
        No atual = this.primeiro;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                No anterior = atual.getAnterior();
                No proximo = atual.getProx();
                if (anterior != null) {
                    anterior.setProx(proximo);
                } else {
                    this.primeiro = proximo;
                }
                if (proximo != null) {
                    proximo.setAnterior(anterior);
                } else {
                    this.ultimo = anterior;
                }
                this.qntdElementos--;
                break;
            }
            atual = atual.getProx();
        }
    }

    @Override
    public boolean estaCheia() {
        return false;
    }

    @Override
    public boolean estaVazia() {
        if(qntdElementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean buscarElemento(Integer elemento) {
        No aux = this.primeiro;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                return true;
            }
            else {
                aux = aux.getProx();
            }
        }
        return false;
    }

    @Override
    public void ordenarCrescente() {
        if (estaVazia()) {
            System.out.println("Não existem elementos para serem ordenados.");
        } else {
            No atual = this.primeiro;
            while (atual != null) {
                No atual2 = this.primeiro;
                while (atual2 != null && atual2.getProx() != null) {
                    No proximo = atual2.getProx();
                    if (atual2.getConteudo() > proximo.getConteudo()) {
                        Integer aux = atual2.getConteudo();
                        atual2.setConteudo(proximo.getConteudo());
                        proximo.setConteudo(aux);
                    }
                    atual2 = atual2.getProx();
                }
                atual = atual.getProx();
            }
        }
    }

    @Override
    public void ordenarDecrescente() {
        if (estaVazia()) {
            System.out.println("Não existem elementos para serem ordenados.");
            return;
        }
        No atual = this.ultimo;
        while (atual != null) {
            No atual2 = this.ultimo;
            while (atual2 != null && atual2.getAnterior() != null) {
                No anterior = atual2.getAnterior();
                if (anterior.getConteudo() < atual2.getConteudo()) {
                    Integer aux = anterior.getConteudo();
                    anterior.setConteudo(atual2.getConteudo());
                    atual2.setConteudo(aux);
                }
                atual2 = atual2.getAnterior();
            }
            atual = atual.getAnterior();
        }
    }

    @Override
    public int quantidadeElementos() {
        return qntdElementos;
    }

    @Override
    public void editarElemento(Integer elementoAntigo, Integer elementoNovo) {
        No atual = this.primeiro;
        while (atual != null) {
            if (atual.getConteudo().equals(elementoAntigo)) {
                atual.setConteudo(elementoNovo);
                break;
            }
            atual = atual.getProx();
        }
    }

    @Override
    public void limpar() {
        No atual = this.primeiro;
        while (atual != null) {
            No proximo = atual.getProx();
            atual.setProx(null);
            atual.setAnterior(null);
            atual = proximo;
        }
        this.primeiro = null;
        this.ultimo = null;
        this.qntdElementos = 0;
    }

    @Override
    public void exibir() {
        No atual = this.primeiro;
        for(int i = 0; i < qntdElementos; i++) {
            System.out.println(atual.getConteudo());
            atual = atual.getProx();
        }
    }

    @Override
    public No obterPrimeiroElemento() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return null;
        }
        return this.primeiro;
    }

    @Override
    public No obterUltimoElemento() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return null;
        }
        return this.ultimo;
    }
}
