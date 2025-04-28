package fiap.com.br.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;


@Data
@ToString
@Document(collection ="USUARIO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    @Column(name = "email_user", length = 100, nullable = false)
    private String email;

    @Column(name = "name_user", length = 100, nullable = false)
    private String name;

    @Column(name = "cpf", length = 100, nullable = false)
    private int CPF;

    @DateTimeFormat
    @Column(name = "admission_date", length = 100, nullable = false)
    private int admissiondate;

    @Column(name = "job", length = 100, nullable = false)
    private String job;

}