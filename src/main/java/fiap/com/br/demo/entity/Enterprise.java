package fiap.com.br.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@ToString
@Document(collection = "empresa")
public class Enterprise {

    @Id
    private UUID uuid;

    private String adress;

    private String cnpj;

    private int phone;
}