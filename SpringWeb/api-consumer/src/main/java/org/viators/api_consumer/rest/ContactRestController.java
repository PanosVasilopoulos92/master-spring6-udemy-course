package org.viators.api_consumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.viators.api_consumer.model.Contact;
import org.viators.api_consumer.model.Response;
import org.viators.api_consumer.proxy.ContactProxy;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ContactRestController {

    @Autowired
    ContactProxy contactProxy;

    @Autowired
    WebClient webClient;

    // An endpoint that when called it will call another endpoint, fetch the results and then provide them to end-user.
    @GetMapping("/getMessages")
    public List<Contact> getMessages(@RequestParam("status") String status) {
        return contactProxy.getMessagesByStatus(status);
    }

    @PostMapping("/saveMessage")
    public Mono<Response> saveMessage(@RequestBody Contact contact){
        String uri = "http://localhost:8080/api/contact/saveMsg";
        return webClient.post().uri(uri)
                .header("invocationFrom", "WebClient")
                .body(Mono.just(contact), Contact.class)
                .retrieve()
                .bodyToMono(Response.class);
    }

}