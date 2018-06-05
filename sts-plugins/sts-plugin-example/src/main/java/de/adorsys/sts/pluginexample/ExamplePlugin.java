package de.adorsys.sts.pluginexample;

import de.adorsys.sts.pf4j.SpringPlugin;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExamplePlugin extends SpringPlugin {

    public ExamplePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.setParent(parentApplicationContext);
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(ExamplePluginConfiguration.class);
        applicationContext.refresh();

        return applicationContext;
    }

    @Override
    public void start() {
        System.out.println("ExamplePlugin.start()");
    }

    @Override
    public void stop() {
        System.out.println("ExamplePlugin.stop()");
        super.stop(); // to close applicationContext
    }
}
