package ua.hildi.petclinicv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
public class PetClinicV2Application {

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(PetClinicV2Application.class);
//        springApplication.addListeners(new ApplicationPidFileWriter(), new EmbeddedServerPortFileWriter());
        springApplication.run(args);
    }
}
