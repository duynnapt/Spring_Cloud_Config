package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class ClientApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(ClientApplication.class, args);
    }

    /**
     * Output property from cloud-config-server on startup of app,
     * <p>
     * also can be seen at:
     * http://localhost:8080/env/info.foo
     */
    @Bean
    public CommandLineRunner printProperties(
            @Value("${myconfig.database.url}") String url,
            @Value("${myconfig.database.user}") String user,
            @Value("${myconfig.database.password}") String pass,
            @Value("${myconfig.notification.success}") String success
    ) {
        return args -> {
            LOGGER.info("info.foo is: [{}], {}, {}, {}", url, user,pass,success);
        };
    }

}
