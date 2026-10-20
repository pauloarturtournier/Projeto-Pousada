public class QuartoSimples extends Quarto {

    private boolean temVentilador;

    public QuartoSimples(int numero, double precoPorDiaria, boolean disponivel, boolean temVentilador) {
        super(numero, precoPorDiaria, disponivel);
        this.temVentilador = temVentilador;
    }

    public boolean getTemVentilador() {
        return temVentilador;
    }

    public void setTemVentilador(boolean temVentilador) {
        this.temVentilador = temVentilador;
    }

    public String MostraValores() {
        return "Tipo: Simples\n" + super.MostraValores() + "\nVentilador: " + temVentilador;
    }
}