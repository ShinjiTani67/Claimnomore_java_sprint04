package fiap.com.br.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.UUID;


@Data
@ToString
@Document(collection = "SINISTRO")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    @Column(name = "claim_date", length = 100, nullable = false)
    private ZonedDateTime claimDate;

    @Column(name = "claim_description", length = 100, nullable = false)
    private String description;
}