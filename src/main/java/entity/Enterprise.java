package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@Entity
@Table(name = "EMPRESA")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    @Column(name = "adress_dentist", length = 100, nullable = false)
    private String adress;

    @Column(name = "cnpj", length = 100, nullable = false)
    private String cnpj;

    @Column(name = "phone_enterprise", length = 100, nullable = false)
    private int phone;
}