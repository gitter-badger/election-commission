package com.tikalk.fuse.kafka.streams.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tikalk.fuse.kafka.streams.engine.VoteProducer;
import com.tikalk.fuse.kafka.streams.models.Vote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
public class VoteController {

    private final VoteProducer producer;

    @Autowired
    VoteController(VoteProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/vote")
    public void sendMessageToKafkaTopicVote(@RequestBody Vote vote) {
        this.producer.submitVote(vote);
    }

}
