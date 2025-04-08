package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

@Data
@ToString
@Document(collection ="DENTISTA")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    @Column(name = "name_dentist", length = 100, nullable = false)
    private String name;

    @Column(name = "cpf_dentist", length = 100, nullable = false)
    private int CPF;

    @Column(name = "cro_dentist", length = 100, nullable = false)
    private String CRO;

    @Column(name = "adress_dentist", length = 100, nullable = false)
    private String adress;

    @Column(name = "phone_dentist", length = 100, nullable = false)
    private int phone;

    @Column(name = "email_dentist", length = 100, nullable = false)
    private String email;

    @DateTimeFormat
    private int birthdate;
}