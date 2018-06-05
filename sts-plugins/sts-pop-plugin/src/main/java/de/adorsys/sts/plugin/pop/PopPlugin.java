package de.adorsys.sts.plugin.pop;

import de.adorsys.sts.pf4j.SpringPlugin;
import org.pf4j.PluginWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PopPlugin extends SpringPlugin {

    public PopPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.setParent(parentApplicationContext);
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(PopPluginConfiguration.class);
        applicationContext.refresh();

        return applicationContext;
    }

    @Override
    public void start() {
        System.out.println("POP plugin started.");
    }

    @Override
    public void stop() {
        System.out.println("POP plugin stopped");
        super.stop();
    }
}
