package manager.parking.models;

import lombok.*;
import manager.parking.models.enumerations.TypesVeiculosEnum;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Veiculos {
    private String marca;
    private String placa;
    private String modelo;
    private TypesVeiculosEnum tipoVeiculo;
}
