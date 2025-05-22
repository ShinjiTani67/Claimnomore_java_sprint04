package fiap.com.br.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnterpriseDTO {

    private String id;

    private String address;

    private String cnpj;

    private int phone;
}
