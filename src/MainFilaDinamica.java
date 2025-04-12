import java.util.Scanner;

public class MainFilaDinamica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaDinamica fila = new FilaDinamica();

        int opcao;

        do {
            System.out.println("1. Inserir elemento");
            System.out.println("2. Inserir sequência");
            System.out.println("3. Remover elemento");
            System.out.println("4. Remover sequência");
            System.out.println("5. Remover primeira ocorrência");
            System.out.println("6. Buscar elemento");
            System.out.println("7. Editar elemento");
            System.out.println("8. Ordenar crescente");
            System.out.println("9. Ordenar decrescente");
            System.out.println("10. Exibir fila");
            System.out.println("11. Mostrar primeiro e último");
            System.out.println("12. Limpar fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento: ");
                    int elem = sc.nextInt();
                    fila.inserirElemento(elem);
                    break;
                case 2:
                    System.out.print("Quantos elementos deseja inserir? ");
                    int n = sc.nextInt();
                    Integer[] sequencia = new Integer[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        sequencia[i] = sc.nextInt();
                    }
                    fila.inserirSequencia(sequencia);
                    break;
                case 3:
                    fila.removerElemento();
                    break;
                case 4:
                    System.out.print("Quantidade de elementos a remover: ");
                    int qtd = sc.nextInt();
                    fila.removerSequencia(qtd);
                    break;
                case 5:
                    System.out.print("Elemento a remover (primeira ocorrência): ");
                    int rem = sc.nextInt();
                    fila.removerTodasOcorrencias(rem);
                    break;
                case 6:
                    System.out.print("Elemento a buscar: ");
                    int busca = sc.nextInt();
                    boolean encontrado = fila.buscarElemento(busca);
                    System.out.println(encontrado ? "Elemento encontrado." : "Elemento não encontrado.");
                    break;
                case 7:
                    System.out.print("Elemento atual: ");
                    int antigo = sc.nextInt();
                    System.out.print("Novo valor: ");
                    int novo = sc.nextInt();
                    fila.editarElemento(antigo, novo);
                    break;
                case 8:
                    fila.ordenarCrescente();
                    break;
                case 9:
                    fila.ordenarDecrescente();
                    break;
                case 10:
                    fila.exibir();
                    break;
                case 11:
                    No primeiro = fila.obterPrimeiroElemento();
                    No ultimo = fila.obterUltimoElemento();
                    System.out.println("Primeiro: " + (primeiro != null ? primeiro.getConteudo() : "null"));
                    System.out.println("Último: " + (ultimo != null ? ultimo.getConteudo() : "null"));
                    break;
                case 12:
                    fila.limpar();
                    System.out.println("Fila limpa.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}