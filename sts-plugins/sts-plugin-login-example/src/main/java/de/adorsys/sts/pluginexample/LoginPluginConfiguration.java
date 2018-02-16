package de.adorsys.sts.pluginexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = "de.adorsys.sts.pluginexample"
)
public class LoginPluginConfiguration {

    @Bean
    ExampleLoginAdapter examplePluginLoginAdapter() {
        return new ExampleLoginAdapter();
    }
}
