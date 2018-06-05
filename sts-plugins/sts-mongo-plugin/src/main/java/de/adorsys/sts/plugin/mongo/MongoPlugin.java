package de.adorsys.sts.plugin.mongo;

import de.adorsys.sts.pf4j.SpringPlugin;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MongoPlugin extends SpringPlugin {

    public MongoPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.setParent(parentApplicationContext);
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(MongoPluginConfiguration.class);
        applicationContext.refresh();

        return applicationContext;
    }

    @Override
    public void start() {
        System.out.println("Mongo plugin started.");
    }

    @Override
    public void stop() {
        System.out.println("Mongo plugin stopped");
        super.stop();
    }
}
