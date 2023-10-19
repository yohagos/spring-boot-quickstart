package com.springboot.quickstart.controller;

import com.springboot.quickstart.tickets.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TicketController {
    private static final String template = "Ticket // %s";
    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/ticket")
    public Ticket ticket(@RequestParam(value = "name", defaultValue = "ticket") String name,
                         @RequestParam(value = "comment", defaultValue = "comment") String comment) {
        return new Ticket(counter.incrementAndGet(), String.format(template, name), comment);
    }

}
