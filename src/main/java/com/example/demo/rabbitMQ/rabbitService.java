package com.example.demo.rabbitMQ;

import com.example.demo.exception.QueueMessageException;
import com.example.demo.parameter.RC;
import com.example.demo.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

@Service
@Slf4j
public class rabbitService {

    @Value("${queue.rabbitmq.notif.exchange}")
    String notifExchange;

    @Value("${queue.rabbitmq.notif.routingkey}")
    String notifRouteKey;

    @Autowired
    @Qualifier("queueTemplate")
    private RabbitTemplate rabbitTemplate;

    private void send(String exchange, String routingkey, User user) {
        try {
            log.debug("send exchange {}, routingkey {}", exchange, routingkey);
            rabbitTemplate.convertAndSend(exchange, routingkey, user);
        } catch (Exception ex) {
            throw new QueueMessageException(RC.GENERAL_ERROR_CODE, "Error publish queue message!");
        }
    }

    public void publishUser(User user) {
        String tokenBuilder = user.getUsername() + ":"
                + user.getEmail() ;
        String token = Base64.getEncoder().encodeToString(tokenBuilder.getBytes(StandardCharsets.UTF_8));
        send(notifExchange, notifRouteKey, user);
    }

    private long generateExpiredDateTimestamp(String expiredHours) {
        LocalDateTime expirationDateTime = LocalDateTime.now().plusMinutes(Integer.parseInt(expiredHours));
        // Convert the LocalDateTime object to a Date object
        Date expirationDate = Date.from(expirationDateTime.atZone(ZoneId.systemDefault()).toInstant());
        // Get the timestamp value in milliseconds
        return expirationDate.getTime();
    }

    public String generateTokenEmail(String username, String email) {
        return username + ":" + email ;
    }
}
