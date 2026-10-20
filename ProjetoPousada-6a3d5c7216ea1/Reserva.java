public class Reserva {

    private Hospede hospede;
    private Quarto quarto;
    private String dataEntrada;
    private String dataSaida;
    private String status;

    public Reserva(Hospede hospede, Quarto quarto, String dataEntrada, String dataSaida) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.status = "Ativa";
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String MostraValores() {
        return "Hospede: " + hospede.getNome() + "\nQuarto: " + quarto.getNumero() + "\nEntrada: " + dataEntrada + "\nSaida: " + dataSaida + "\nStatus: " + status;
    }
}