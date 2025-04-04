package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ToString
@Entity
@Table(name="DENTISTA")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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