package fiap.com.br.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Data
@ToString
@Document(collection ="dentistas")
public class Dentist {

    @Id
    private String id;

    private String name;

    private String cpf;

    private String cro;

    private String address;

    private String phone;

    private String email;

    private LocalDate birthdate;
}