package fiap.com.br.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.ZonedDateTime;
import java.util.UUID;


@Data
@ToString
@Document(collection = "sinistro")
public class Claim {

    @Id
    private UUID uuid;

    private ZonedDateTime claimDate;

    private String description;
}