package de.adorsys.sts.standalone;

import de.adorsys.sts.pf4j.SpringPluginManager;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@Import(StsCoreConfiguration.class)
@Order(0)
public class PluginManagerConfiguration {

    @Value("${plugin-management.plugins-path}")
    private String pluginsPath;

    @Autowired
    private ApplicationContext context;

    @Bean
    public PluginManager pluginManager() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        SpringPluginManager pluginManager = new SpringPluginManager(pluginsPath, contextClassLoader);
        pluginManager.setApplicationContext(context);

        return pluginManager;
    }

    @Bean
    public TaskScheduler taskExecutor() {
        return new ConcurrentTaskScheduler();
    }
}
