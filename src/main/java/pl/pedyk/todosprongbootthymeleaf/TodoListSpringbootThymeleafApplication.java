package pl.pedyk.todosprongbootthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class TodoListSpringbootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListSpringbootThymeleafApplication.class, args);
    }

    @Bean
    Validator validate() {
        return new LocalValidatorFactoryBean();
    }
}
