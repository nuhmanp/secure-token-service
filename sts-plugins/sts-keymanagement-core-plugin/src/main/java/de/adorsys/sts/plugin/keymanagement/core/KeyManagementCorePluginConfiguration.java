package de.adorsys.sts.plugin.keymanagement.core;

import de.adorsys.sts.keymanagement.core.KeyManagementConfigurationProperties;
import de.adorsys.sts.keymanagement.core.KeyManagementCoreConfiguration;
import de.adorsys.sts.keymanagement.service.KeyConversionService;
import de.adorsys.sts.keymanagement.service.KeyPairGenerator;
import de.adorsys.sts.keymanagement.service.KeyStoreGenerator;
import de.adorsys.sts.keymanagement.service.SecretKeyGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.time.Clock;

@Configuration
//@Import(KeyManagementCoreConfiguration.class)
@ComponentScan("de.adorsys.sts.keymanagement.core")
public class KeyManagementCorePluginConfiguration extends Extension {

    @Bean
    KeyConversionService keyConversionService(
            KeyManagementConfigurationProperties keyManagementProperties
    ) {
        return new KeyConversionService(keyManagementProperties.getKeystore().getPassword());
    }

    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    KeyStoreGenerator keyStoreGenerator(
            Clock clock,
            @Qualifier("enc") KeyPairGenerator encKeyPairGenerator,
            @Qualifier("sign") KeyPairGenerator signKeyPairGenerator,
            SecretKeyGenerator secretKeyGenerator,
            KeyManagementConfigurationProperties keyManagementProperties
    ) {
        return new KeyStoreGenerator(
                clock,
                encKeyPairGenerator,
                signKeyPairGenerator,
                secretKeyGenerator,
                keyManagementProperties
        );
    }

    @Bean(name = "enc")
    KeyPairGenerator encKeyPairGenerator(
            KeyManagementConfigurationProperties keyManagementProperties
    ) {
        return new KeyPairGenerator(keyManagementProperties.getKeystore().getKeys().getEncKeyPairs());
    }

    @Bean(name = "sign")
    KeyPairGenerator signKeyPairGenerator(
            KeyManagementConfigurationProperties keyManagementProperties
    ) {
        return new KeyPairGenerator(keyManagementProperties.getKeystore().getKeys().getSignKeyPairs());
    }

    @Bean
    SecretKeyGenerator secretKeyGenerator(
            KeyManagementConfigurationProperties keyManagementProperties
    ) {
        return new SecretKeyGenerator(
                keyManagementProperties.getKeystore().getKeys().getSecretKeys()
        );
    }
}
