public class Quarto {

    private int numero;
    private double precoPorDiaria;
    private boolean disponivel;

    public Quarto(int numero, double precoPorDiaria, boolean disponivel) {
        this.numero = numero;
        this.precoPorDiaria = precoPorDiaria;
        this.disponivel = disponivel;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecoPorDiaria() {
        return precoPorDiaria;
    }

    public void setPrecoPorDiaria(double precoPorDiaria) {
        this.precoPorDiaria = precoPorDiaria;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String MostraValores() {
        return "Numero: " + numero + "\nPreco por Diaria: R$" + precoPorDiaria + "\nDisponivel: " + disponivel;
    }
}