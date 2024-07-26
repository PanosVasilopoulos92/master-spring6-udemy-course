package org.viators.api_consumer.proxy;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.viators.api_consumer.config.ProjectConfiguration;
import org.viators.api_consumer.model.Contact;

import java.util.List;

@FeignClient(name = "contact", url = "http://localhost:8080/api/contact",
        configuration = ProjectConfiguration.class)
public interface ContactProxy {

    @GetMapping("/getMessagesByStatus")
    @Headers(value = "Content-Type: application-json")
    public List<Contact> getMessagesByStatus(@RequestParam String status);
}
