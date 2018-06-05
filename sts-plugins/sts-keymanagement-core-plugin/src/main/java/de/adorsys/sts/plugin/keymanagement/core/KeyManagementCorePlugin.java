package de.adorsys.sts.plugin.keymanagement.core;

import de.adorsys.sts.pf4j.SpringPlugin;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KeyManagementCorePlugin extends SpringPlugin {

    public KeyManagementCorePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.setParent(parentApplicationContext);
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(KeyManagementCorePluginConfiguration.class);
        applicationContext.refresh();

        return applicationContext;
    }
}
