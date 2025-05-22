package fiap.com.br.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DentistDTO {

    private String id;

    private String name;

    private String cpf;

    private String cro;

    private String address;

    private String phone;

    private String email;

    private LocalDate birthdate;
}
