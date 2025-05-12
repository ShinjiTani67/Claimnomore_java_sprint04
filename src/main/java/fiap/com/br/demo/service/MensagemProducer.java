package fiap.com.br.demo.service;

import fiap.com.br.demo.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensagemProducer {

    private final RabbitTemplate rabbitTemplate;

    public void enviarMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, mensagem);
    }
}