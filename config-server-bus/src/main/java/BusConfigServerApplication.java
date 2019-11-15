import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: com.zh.server.ConfigGitApplication
 * @Description: 
 * @Author wanghaili
 * @Date 2019/11/12 14:05
 **/
@SpringBootApplication
@EnableConfigServer
@ComponentScan("com.zh.server")
public class BusConfigServerApplication {
    public static void main(String[] args) {
        System.out.println("staring");
        SpringApplication.run(BusConfigServerApplication.class);
        System.out.println("start end");
    }
}
