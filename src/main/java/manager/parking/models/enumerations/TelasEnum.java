package manager.parking.models.enumerations;

public enum TelasEnum {
    CADASTRO("../telaCadastro.fxml"),
    LOGIN("../telaLogin.fxml"),
    MENU_USER("../menuUser.fxml");

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
