package com.adeo.event.driven.sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.adeo.lys.event.cotation.CotationCotedEvent;

@Service
public class SenderIn {

    private static final Logger LOG = LoggerFactory.getLogger(SenderIn.class);

    @Autowired
    private KafkaTemplate<String, CotationCotedEvent> kafkaTemplate;

    @Value("${app.topic.event-driven-topic-in}")
    private String topic;

    public void send(CotationCotedEvent message){
        LOG.info("Sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}