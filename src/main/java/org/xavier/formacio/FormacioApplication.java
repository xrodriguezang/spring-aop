package org.xavier.formacio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xavier.formacio.anotacio.LogeigTemps;
import org.xavier.formacio.service.ICursService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class FormacioApplication {

    @Autowired
    ICursService cursService;

    @LogeigTemps(maxTiempo = 1000)  // Perquè he posat el target en method
    public static void main(String[] args) {
        SpringApplication.run(FormacioApplication.class, args);
        log.info("AOP application formation");
    }

    @PostConstruct
    public void init() {
        cursService.metode1();
        cursService.metode2();
        cursService.metode3(3);
        cursService.metode3(4);
        cursService.metode3(3);
        cursService.metode4("En Pepitu");
        cursService.metode4("En Pepitu2");
        cursService.metode4("En Pepitu3");
        cursService.metode4("En Pepitu");
        cursService.metode3(5);
        cursService.metode3(3);
        cursService.metode3(3);
        cursService.metode3(3);
    }

}
