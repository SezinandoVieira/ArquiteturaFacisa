package br.cesed.unifacisa.si.arquitetura.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}
