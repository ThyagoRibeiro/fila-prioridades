package parte_1;

public class FilaPrioridade {

    private Elemento[] elementos; // vetor A
    private int maxElementos;
    private int m;

    public final char ELEMENTO_INSERIDO = 'T';
    public final char ELEMENTO_NAO_INSERIDO = 'F';

    public final Elemento ELEMENTO_NAO_EXISTENTE = new Elemento(-1, -1.0f);

    public FilaPrioridade(int maxElementos) {
        this.maxElementos = maxElementos;
        elementos = new Elemento[maxElementos];
        m = 0;
    }

    /*
     * Devolve o elemento que possui a maior prioridade do vetor A que contem m elementos.
     * Se não existem elementos na fila de prioridade, devolve -1, -1,0.
     * Consumo de O(1).
     */
    public Elemento heapMax() {

        if(m == 0)
            return ELEMENTO_NAO_EXISTENTE;

        return elementos[0];

    }

    /*
     * Remove e devolve o elemento que possui a maior prioridade do vetor A e que contem m elementos.
     * Se não existem elementos na fila de prioridade, devolve -1, -1,0.
     * Consumo de O(lg m).
     */
    public Elemento heapExtractMax() {

        if(m == 0)
            return ELEMENTO_NAO_EXISTENTE;

        Elemento elemento = elementos[0];

        m--;
        elementos[0] = elementos[m];
        elementos[m] = null;

        maxHeapify(0); // O(lg m)

        return elemento;

    }

    /*
     * Insere o elemento no vetor A que contém m elementos.
     * Se é possível inserir o elemento, o método retorna T, senão retorna F.
     * Consumo de O(lg m).
     */
    public char heapInsert(Elemento elemento) {

        if(elemento.getPrioridade() > 900000)
            return ELEMENTO_NAO_INSERIDO;

        if(m == maxElementos)
            return ELEMENTO_NAO_INSERIDO;

        elementos[m] = elemento;

        heapIncreaseKey(m);
        m++;

        return ELEMENTO_INSERIDO;

    }

    /*
     * Imprime o vetor A que contem m elementos.
     */
    public void heapPrint() { // O(i^2)

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < m; i++) { // O(m)

            if(i > 0) // O(m)
                stringBuilder.append(" ");

            stringBuilder.append(elementos[i].getId());
            stringBuilder.append(" ");
            stringBuilder.append(elementos[i].getPrioridade());
        }

        System.out.println(stringBuilder.toString());

    }

    /*
     * Converte um quase maxHeap enraizado em i em um maxHeap.
     * Utilizado como método auxiliar do heapExtractMax.
     */
    private void maxHeapify(int i) {

        int indiceFilhoEsq = (i * 2) + 1;
        int indiceFilhoDir = (i * 2) + 2;

        int indiceMaiorPrioridade = i;

        // verifica se filho esquerdo tem maior prioridade
        if(indiceFilhoEsq <= m && indiceFilhoEsq > 0 && elementos[indiceFilhoEsq] != null)
            if(elementos[indiceFilhoEsq].getPrioridade() > elementos[indiceMaiorPrioridade].getPrioridade())
                indiceMaiorPrioridade = indiceFilhoEsq;

        // verifica se filho direito tem maior prioridade
        if(indiceFilhoDir <= m && indiceFilhoDir > 0 && elementos[indiceFilhoDir] != null)
            if(elementos[indiceFilhoDir].getPrioridade() > elementos[indiceMaiorPrioridade].getPrioridade())
                indiceMaiorPrioridade = indiceFilhoDir;

        // troca filho com maior prioridade com o indice i
        if(indiceMaiorPrioridade != i) {
            Elemento temp = elementos[i];
            elementos[i] = elementos[indiceMaiorPrioridade];
            elementos[indiceMaiorPrioridade] = temp;
            maxHeapify(indiceMaiorPrioridade); // O(lg m)
        }

    }

    /*
     * Aumenta o valor da prioridade para prior do elemento que está na posição i do vetor A.
     * Realoca o elemento na posição certa no heap, caso necessário.
     * Utilizado como método auxiliar no heapInsert.
     * Consumo de O(lg m).
     */
    private void heapIncreaseKey(int i) {

        while(i > 0 && elementos[(i - 1)/2].getPrioridade() < elementos[i].getPrioridade()) { // O(lg m)

            Elemento temp = elementos[(i - 1)/2];
            elementos[(i - 1)/2] = elementos[i];
            elementos[i] = temp;
            i = (i - 1)/2;

        }

    }

    public Elemento[] getElementos() {
        return elementos;
    }

    public int getM() {
        return m;
    }

}
