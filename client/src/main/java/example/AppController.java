package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@RestController
// This will allow us to reinitialize this controller to get any new config
// values when the /refresh endpoint is POSTed to.
@RefreshScope
public class AppController {

    @Value("${info.foo}")
    private String fooProperty;

    @Autowired
    private Environment env;

    @PostConstruct
    private void init(){
        System.out.println("--------------------------------------------Start");
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
//        String[] arr = env.getDefaultProfiles();
//        System.out.println(arr);
        System.out.println("ddd");
        System.out.println("--------------------------------------------End");
    }
    @RequestMapping("/")
    public String hello() {
        return "Using [" + fooProperty + "] from config server";
    }
}
