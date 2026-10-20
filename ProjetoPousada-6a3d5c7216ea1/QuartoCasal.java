public class QuartoCasal extends Quarto {

    private boolean temVaranda;

    public QuartoCasal(int numero, double precoPorDiaria, boolean disponivel, boolean temVaranda) {
        super(numero, precoPorDiaria, disponivel);
        this.temVaranda = temVaranda;
    }

    public boolean getTemVaranda() {
        return temVaranda;
    }

    public void setTemVaranda(boolean temVaranda) {
        this.temVaranda = temVaranda;
    }

    public String MostraValores() {
        return "Tipo: Casal\n" + super.MostraValores() + "\nVaranda: " + temVaranda;
    }
}