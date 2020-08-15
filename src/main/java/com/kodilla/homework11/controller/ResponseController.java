package com.kodilla.homework11.controller;

import com.kodilla.homework11.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResponseController {

    @GetMapping(value = "/homework")
    public GetResponse m1(@RequestParam(value = "name",
            defaultValue = "Bot") String name) {
        GetResponse response = new GetResponse();
        response.setId(1);
        response.setMessage("This is your message " + name);
        response.setExtra("This is your Extra text " + name);
        return response;
    }

    @PostMapping(value = "/homework")
    public PostResponse m2(@RequestBody PostRequest inputPayload) {
        PostResponse response = new PostResponse();
        response.setId(inputPayload.getId());
        response.setMessage("Hello this is the message you just put: " + inputPayload.getMessage());
        response.setExtra("This is an Extra text from request: " + inputPayload.getExtra());
        return response;
    }

    @PutMapping(value = "/homework")
    public PutResponse m3(@RequestBody PutRequest inputPayload) {
        PutResponse response = new PutResponse();
        response.setId(inputPayload.getId() * 2);
        response.setMessage("Hello you updated message to: " + inputPayload.getMessage());
        response.setExtra("This is updated Extra text from request: " + inputPayload.getExtra());
        return response;
    }

}