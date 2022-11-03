package ua.hildi.petclinicv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableJpaRepositories
public class PetClinicV2Application {

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(PetClinicV2Application.class);
//        springApplication.addListeners(new ApplicationPidFileWriter(), new EmbeddedServerPortFileWriter());
        springApplication.run(args);
    }
}
