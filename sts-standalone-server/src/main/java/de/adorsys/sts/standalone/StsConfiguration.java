package de.adorsys.sts.standalone;

import de.adorsys.sts.admin.EnableAdmin;
import de.adorsys.sts.encryption.EnableEncryption;
import de.adorsys.sts.keymanagement.core.KeyManagementCoreConfiguration;
import de.adorsys.sts.keyrotation.EnableKeyRotation;
import de.adorsys.sts.pop.EnablePOP;
import de.adorsys.sts.resourceserver.initializer.EnableResourceServerInitialization;
import de.adorsys.sts.resourceserver.persistence.InMemoryResourceServerRepository;
import de.adorsys.sts.resourceserver.persistence.ResourceServerRepository;
import de.adorsys.sts.serverinfo.EnableServerInfo;
import de.adorsys.sts.token.tokenexchange.EnableTokenExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

//@Configuration
//@EnableResourceServerInitialization
//@EnableEncryption
//@EnablePOP
//@EnableKeyRotation
//@EnableTokenExchange
//@EnableAdmin
//@EnableServerInfo
//@Import(KeyManagementCoreConfiguration.class)
//@Order(Ordered.LOWEST_PRECEDENCE)
public class StsConfiguration {

    @Bean
    ResourceServerRepository resourceServerRepository() {
        return new InMemoryResourceServerRepository();
    }
}
