public class QuartoLuxo extends Quarto {

    private boolean temJacuzzi;

    public QuartoLuxo(int numero, double precoPorDiaria, boolean disponivel, boolean temJacuzzi) {
        super(numero, precoPorDiaria, disponivel);
        this.temJacuzzi = temJacuzzi;
    }

    public boolean getTemJacuzzi() {
        return temJacuzzi;
    }

    public void setTemJacuzzi(boolean temJacuzzi) {
        this.temJacuzzi = temJacuzzi;
    }

    public String MostraValores() {
        return "Tipo: Luxo\n" + super.MostraValores() + "\nJacuzzi: " + temJacuzzi;
    }
}