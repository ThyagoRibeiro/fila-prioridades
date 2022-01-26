package parte_1;

import java.util.Scanner;

/**
 * Implementação de fila de prioridade utilizando maxheap para a disciplina SIN5013
 * do Mestrado em Sistemas de Informação da EACH-USP
 *
 * @author Thyago Ribeiro dos Santos - nUSP 9377491
 */

public class Main {

    private static int q;

    private static FilaPrioridade filaPrioridade;

    private static Elemento elementoDevolvido;
    private static char resultadoInserscao;

    private static final int OPERACAO_DEVOLVE_MAIOR_PRIORIDADE = 1;
    private static final int OPERACAO_REMOVE_DEVOLVE_MAIOR_PRIORIDADE = 2;
    private static final int OPERACAO_INSERE_ELEMENTO = 3;
    private static final int OPERACAO_IMPRIME = 4;

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {

            q = scan.nextInt();

            if (q == 0)
                break;

            filaPrioridade = new FilaPrioridade(4000);

            for (int i = 0; i < q; i++) {

                switch (scan.nextInt()) {

                    case OPERACAO_DEVOLVE_MAIOR_PRIORIDADE:
                        elementoDevolvido = filaPrioridade.heapMax();
                        System.out.println(elementoDevolvido.getId() + " " + elementoDevolvido.getPrioridade());
                        break;

                    case OPERACAO_REMOVE_DEVOLVE_MAIOR_PRIORIDADE:
                        elementoDevolvido = filaPrioridade.heapExtractMax();
                        System.out.println(elementoDevolvido.getId() + " " + elementoDevolvido.getPrioridade());
                        break;

                    case OPERACAO_INSERE_ELEMENTO:
                        resultadoInserscao = filaPrioridade.heapInsert(new Elemento(scan.nextInt(), scan.nextFloat()));
                        System.out.println(resultadoInserscao);
                        break;

                    case OPERACAO_IMPRIME:
                        filaPrioridade.heapPrint();
                        break;

                }

            }

        }

    }

}