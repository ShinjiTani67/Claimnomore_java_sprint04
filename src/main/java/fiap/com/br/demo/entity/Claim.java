package fiap.com.br.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;


@Data
@ToString
@Document(collection = "sinistros")
public class Claim {

    @Id
    private String id;

    private LocalDate claimDate;

    private String description;
}