package manager.parking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Clients {
    private String name;
    private String phone;
    private String email;
    private String birthdate;
    private String login;
    private String senha;
    private Veiculos veiculo;
    private List<Estacionamento> historicoEstacionamento;
    private boolean userDesative;
    private String cardCode;

}
