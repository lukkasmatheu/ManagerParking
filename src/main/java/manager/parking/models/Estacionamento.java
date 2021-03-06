package manager.parking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamento {
    private String data;
    private String vaga;
    private String andar;
    private String horarioEntrada;
    private String horarioSaida;
    private Float valor;
    private boolean pago;
    private boolean open;

}
