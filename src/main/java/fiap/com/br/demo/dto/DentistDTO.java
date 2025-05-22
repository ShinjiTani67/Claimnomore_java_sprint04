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

    private UUID uuid;

    private String name;

    private int cpf;

    private String cro;

    private String address;

    private int phone;

    private String email;

    private LocalDate birthdate;
}
