package de.adorsys.sts.keymanagement;

import de.adorsys.sts.keymanagement.persistence.KeyStoreRepository;
import de.adorsys.sts.keymanagement.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.time.Clock;

@Configuration
@ComponentScan(
        basePackages = {"de.adorsys.sts.keymanagement"},
        excludeFilters = {@ComponentScan.Filter(
                pattern = "de.adorsys.sts.keymanagement.bouncycastle.*",
                type = FilterType.REGEX
        ), @ComponentScan.Filter(
                pattern = "de.adorsys.sts.keymanagement.core.*",
                type = FilterType.REGEX
        )}
)
public class KeyManagementConfiguration {

    @Bean
    KeyManagementService keyManagerService(
            KeyStoreRepository keyStoreRepository,
            KeyConversionService keyConversionService
    ) {
        return new KeyManagementService(
                keyStoreRepository,
                keyConversionService
        );
    }

    @Bean
    KeyStoreInitializer keyStoreInitializer(
            KeyStoreRepository keyStoreRepository,
            KeyStoreGenerator keyStoreGenerator
    ) {
        return new KeyStoreInitializer(keyStoreRepository, keyStoreGenerator);
    }
}
