package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnterpriseDTO {

    private UUID id;

    private String adress;

    private String cnpj;

    private int phone;
}
