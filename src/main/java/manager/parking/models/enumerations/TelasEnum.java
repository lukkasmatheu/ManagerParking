package manager.parking.models.enumerations;

public enum TelasEnum {
    CADASTRO("../telaCadastro.fxml"),
    CADASTRO_VEICULO("../telaCadastroVeiculo.fxml"),
    LOGIN("../telaLogin.fxml"),
    MENU_ADMIN("../telaMenuAdmin.fxml"),
    REGISTRO("../telaRegistros.fxml"),
    BUSCA("../telaBusca.fxml"),
    TICKET_ENTRADA("../telaTicketEntry.fxml"),
    TICKET_SAIDA("../telaTicketOut.fxml"),
    MENU_USER("../telaMenuClient.fxml");

    private final String pathname;


    private TelasEnum(String pathname) {
        this.pathname = pathname;
    }

    public String getPathname() {
        return pathname;
    }

    public static TelasEnum findTela(String pathname) {
        for (TelasEnum telas : values()) {
            if (telas.getPathname().equals(pathname)) {
                return telas;
            }
        }
        return null;
    }
}
