package fiap.com.br.demo.controller;


import fiap.com.br.demo.service.AiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/responder")
    public String responderPergunta(@RequestParam String pergunta) {
        return aiService.responder(pergunta);
    }
}