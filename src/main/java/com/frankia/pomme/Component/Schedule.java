package com.frankia.pomme.Component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

    @Scheduled(fixedRate = 60000)
    public void task(){
        System.out.println("ai que task boa");
    }
}
