package manager.parking.models;

public class Cars {
    String placa;
    Users proprietario;
    String modelo;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Users getProprietario() {
        return proprietario;
    }

    public void setProprietario(Users proprietario) {
        this.proprietario = proprietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
