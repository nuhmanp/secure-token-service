package de.adorsys.sts.plugin.pop;

import de.adorsys.sts.pop.PopConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
        PopConfiguration.class
})
@ComponentScan("de.adorsys.sts.plugin.pop")
public class PopPluginConfiguration {
}
