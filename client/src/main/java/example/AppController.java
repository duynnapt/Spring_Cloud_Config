package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// This will allow us to reinitialize this controller to get any new config
// values when the /refresh endpoint is POSTed to.
@RefreshScope
public class AppController {

    @Value("${myconfig.database.url}")
    String url;
    @Value("${myconfig.database.user}")
    String user;
    @Value("${myconfig.database.password}")
    String pass;
    @Value("${myconfig.notification.success}")
    String success;

    @RequestMapping("/")
    public String hello() {
        return String.format("%s, %s, %s, %s", url, user, pass, success);
    }
}
