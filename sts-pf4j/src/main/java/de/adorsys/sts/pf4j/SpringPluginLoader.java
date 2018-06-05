package de.adorsys.sts.pf4j;

import org.pf4j.*;

import java.nio.file.Path;

public class SpringPluginLoader extends DefaultPluginLoader {

    private final ClassLoader classLoader;

    public SpringPluginLoader(
            PluginManager pluginManager,
            PluginClasspath pluginClasspath,
            ClassLoader classLoader
    ) {
        super(pluginManager, pluginClasspath);
        this.classLoader = classLoader;
    }

    @Override
    protected PluginClassLoader createPluginClassLoader(Path pluginPath, PluginDescriptor pluginDescriptor) {
        return new PluginClassLoader(pluginManager, pluginDescriptor, classLoader);
    }
}
