package fiap.com.br.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@ToString
@Document(collection = "empresas")
public class Enterprise {

    @Id
    private String id;

    private String adress;

    private String cnpj;

    private int phone;
}