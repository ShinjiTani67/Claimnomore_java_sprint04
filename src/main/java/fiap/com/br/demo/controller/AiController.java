package fiap.com.br.demo.controller;


import fiap.com.br.demo.service.AiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AiController {

    private final AiService aiService;

    @GetMapping("/responder")
    public String responderPergunta(@RequestParam String pergunta) {
        return aiService.responder(pergunta);
    }
}