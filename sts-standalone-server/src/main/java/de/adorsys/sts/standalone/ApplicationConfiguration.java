package de.adorsys.sts.standalone;

import de.adorsys.sts.admin.EnableAdmin;
import de.adorsys.sts.encryption.EnableEncryption;
import de.adorsys.sts.keyrotation.EnableKeyRotation;
import de.adorsys.sts.pf4j.SpringPluginManager;
import de.adorsys.sts.pop.EnablePOP;
import de.adorsys.sts.resourceserver.initializer.EnableResourceServerInitialization;
import de.adorsys.sts.resourceserver.persistence.InMemoryResourceServerRepository;
import de.adorsys.sts.resourceserver.persistence.ResourceServerRepository;
import de.adorsys.sts.serverinfo.EnableServerInfo;
import de.adorsys.sts.token.tokenexchange.EnableTokenExchange;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@EnableResourceServerInitialization
@EnableEncryption
@EnablePOP
@EnableKeyRotation
@EnableTokenExchange
@EnableAdmin
@EnableServerInfo
public class ApplicationConfiguration {

    @Value("${plugin-management.plugins-path}")
    private String pluginsPath;

    @Bean
    public PluginManager pluginManager() {
        return new SpringPluginManager(pluginsPath);
    }

    @Bean
    public TaskScheduler taskExecutor() {
        return new ConcurrentTaskScheduler();
    }

    @Bean
    ResourceServerRepository resourceServerRepository() {
        return new InMemoryResourceServerRepository();
    }
}
