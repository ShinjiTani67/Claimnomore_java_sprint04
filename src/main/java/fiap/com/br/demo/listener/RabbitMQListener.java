package fiap.com.br.demo.listener;

import fiap.com.br.demo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
