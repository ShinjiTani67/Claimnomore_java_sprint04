package dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DentistDTO {

    private UUID uuid;

    private String email;

    private String name;

    private int CPF;

    private int admissiondate;

    private String job;
}
