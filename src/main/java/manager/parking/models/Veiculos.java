package manager.parking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import manager.parking.models.enumerations.TypesVeiculosEnum;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Veiculos {
    String placa;
    String modelo;
    TypesVeiculosEnum tipoVeiculo;
}
