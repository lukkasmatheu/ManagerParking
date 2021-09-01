package manager.parking.models.enumerations;

public enum TypesVeiculosEnum {
    CARRO("carro"),
    MOTO("moto");

    private String type;

    private TypesVeiculosEnum(String theType) {
        this.type = theType;
    }
}
