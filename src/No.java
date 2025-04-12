public class No implements INo {
    private Integer conteudo;
    private No prox;
    private No anter;

    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
        this.anter = null;
    }

    @Override
    public No getProx() {
        return prox;
    }

    @Override
    public void setProx(No primeiro) {
        this.prox = primeiro;
    }

    @Override
    public Integer getConteudo() {
        return this.conteudo;
    }

    @Override
    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public No getAnterior() {
        return this.anter;
    }

    @Override
    public void setAnterior(No anterior) {
        this.anter = anterior;
    }
}
