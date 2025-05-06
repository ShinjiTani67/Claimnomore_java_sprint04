package fiap.com.br.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

@Data
@ToString
@Document(collection ="dentista")
public class Dentist {

    @Id
    private UUID uuid;

    private String name;

    private int CPF;

    private String CRO;

    private String adress;

    private int phone;

    private String email;

    @DateTimeFormat
    private int birthdate;
}