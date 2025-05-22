package fiap.com.br.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnterpriseDTO {

    private UUID id;

    private String nome;

    private String cnpj;

    private String email;

    private String telefone;

    private String endereco;
}
