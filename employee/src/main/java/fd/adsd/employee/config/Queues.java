package fd.adsd.employee.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Queues {
    public final static String queueRegister = "register";

    @Bean(queueRegister)
    public Queue queueRegister(){
        return new Queue(queueRegister);
    }
}
