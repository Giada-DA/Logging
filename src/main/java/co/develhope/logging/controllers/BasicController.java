package co.develhope.logging.controllers;

import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    Environment environment;

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String hello(){
        logger.info("Ti diamo il benvenuto");
        return "Benvenuto";
    }

    @GetMapping("/exp")
    public int esponente(){
        logger.info("Eleviamo a potenza il 2");
        int num = Integer.parseInt(environment.getProperty("customEnvs.n1"));
        int num2 = Integer.parseInt(environment.getProperty("customEnvs.n2"));
        logger.info("Risultato dell'elevazione a potenza");
        int tot = (int) Math.pow(num, num2);
        logger.info("Fine del calcolo");
        return tot;


    }

    @GetMapping("/get-errors")
    public void errore(){
        logger.info("Generiamo un errore personalizzato");
        throw new RuntimeException("Eh ci tocca");
    }
}