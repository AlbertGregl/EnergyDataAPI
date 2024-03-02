package gregl.energydataapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("gregl.energydataapi.model")
@EnableJpaRepositories("gregl.energydataapi.repository")
@ComponentScan(basePackages = {
        "gregl.energydataapi.model",
        "gregl.energydataapi.repository",
        "gregl.energydataapi.controller",
        "gregl.energydataapi.service",
        "gregl.energydataapi.config"
})
public class EnergyDataApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnergyDataApiApplication.class, args);
    }

}
