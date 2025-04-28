package fiap.com.br.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClaimDTO {

    private UUID uuid;

    private ZonedDateTime claimDate;

    private String description;
}
