package pl.pedyk.todosprongbootthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class TodoListSpringbootThymeleafApplication implements RepositoryRestConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(TodoListSpringbootThymeleafApplication.class, args);
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validate());
        validatingListener.addValidator("beforeSave", validate());
    }

    @Bean
    @Primary
    Validator validate() {
        return new LocalValidatorFactoryBean();
    }
}
