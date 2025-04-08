package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;


@Data
@ToString
@Entity
@Table(name = "SINISTRO")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "claim_date", length = 100, nullable = false)
    private ZonedDateTime claimDate;

    @Column(name = "claim_description", length = 100, nullable = false)
    private String description;
}