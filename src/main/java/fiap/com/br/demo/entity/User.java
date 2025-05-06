package fiap.com.br.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;


@Data
@ToString
@Document(collection ="usuario")
public class User {

    @Id
    private UUID uuid;

    private String email;

    private String name;

    private int CPF;

    @DateTimeFormat
    private int admissiondate;

    private String job;

}