package fiap.com.br.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private UUID uuid;

    private String email;

    private String name;

    private String cpf;

    private LocalDate admissiondate;

    private String job;
}
