package pl.gatomek.rabbitmq.demo.producer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ProducerConfig {

    public static final String WORK_QUEUE_TOPIC_EXCHANGE_NAME = "work-queue-exchange";
    private final CommonConfig commonConfig;

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(WORK_QUEUE_TOPIC_EXCHANGE_NAME);
    }

    @Bean
    Queue queue() {
        return new Queue(commonConfig.getWorkQueueName());
    }

    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
    }
}
