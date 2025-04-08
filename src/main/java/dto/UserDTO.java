package dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private UUID uuid;

    private String email;

    private String name;

    private int CPF;

    private int admissiondate;

    private String job;
}
