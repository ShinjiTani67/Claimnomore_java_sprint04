package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnterpriseDTO {

    private long Id;

    private String adress;

    private String cnpj;

    private int phone;
}
