package parte_1;

public class Elemento {

    private int id;
    private float prioridade;

    public Elemento(int id, float prioridade) {
        this.id = id;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(float prioridade) {
        this.prioridade = prioridade;
    }
}
