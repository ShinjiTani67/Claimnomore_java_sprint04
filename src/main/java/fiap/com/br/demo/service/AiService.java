package fiap.com.br.demo.service;


public class AiService {

    private final ChatClient chatClient;

    public String responder(String pergunta) {
        return chatClient.call(pergunta);
    }
}