package crawl.dgts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"crawler.dgts"})
@EntityScan(basePackages = "crawler.dgts.service.entity")
@EnableJpaRepositories(basePackages = "crawler.dgts.service.repository")
@EnableSwagger2
@EnableAspectJAutoProxy
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}