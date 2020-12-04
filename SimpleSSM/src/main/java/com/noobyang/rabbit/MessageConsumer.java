package com.noobyang.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;


public class MessageConsumer implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger("MessageConsumer");

    @Override
    public void onMessage(Message message) {
        logger.debug("onMessage " + message.toString());
    }


}