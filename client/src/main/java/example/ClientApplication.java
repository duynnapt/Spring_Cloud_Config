package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ClientApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(ClientApplication.class, args);
    }

    /**
     * Output property from cloud-config-server on startup of app,
     *
     * also can be seen at:
     * http://localhost:8080/env/info.foo
     */
    @Bean
    public CommandLineRunner printProperties(
            @Value("${info.foo}") final String fooProperty,
            @Value("${info.someList}") final String info
    )  {
        return args -> {
            LOGGER.info("info.foo is: [{}], {}", fooProperty, info);
        };
    }

}
