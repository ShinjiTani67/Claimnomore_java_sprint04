package fiap.com.br.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;


@Data
@ToString
@Document(collection ="usuario")
public class User {

    @Id
    private String id;

    private String email;

    private String name;

    private String cpf;

    private LocalDate admissiondate;

    private String job;

}