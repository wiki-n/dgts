package crawl.dgts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author phamd
 *
 */
@SpringBootApplication
@ComponentScan({"crawler.configs", "crawler.dgts", "crawler.dgts.repository", "crawler.dgts.controllers", "crawler.dgts.services", "crawler.http.context"})
@EntityScan(basePackages = "crawler.dgts.entity")
@EnableJpaRepositories(basePackages = "crawler.dgts.repository")
@EnableSwagger2
@EnableAspectJAutoProxy
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}