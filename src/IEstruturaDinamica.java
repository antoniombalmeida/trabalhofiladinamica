public interface IEstruturaDinamica {
    void inserirElemento(Integer elemento);
    void inserirSequencia(Integer[] elementos);
    boolean removerElemento();
    void removerSequencia(int quantidade);
    void removerTodasOcorrencias(Integer elemento);
    boolean estaCheia();
    boolean estaVazia();
    boolean buscarElemento(Integer elemento);
    void ordenarCrescente();
    void ordenarDecrescente();
    int quantidadeElementos();
    void editarElemento(Integer elementoAntigo, Integer elementoNovo);
    void limpar();
    void exibir();
    No obterPrimeiroElemento();
    No obterUltimoElemento();
}