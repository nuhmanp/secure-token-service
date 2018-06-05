package de.adorsys.sts.standalone;

import de.adorsys.sts.keymanagement.core.KeyManagementCoreConfiguration;
import de.adorsys.sts.resourceserver.persistence.InMemoryResourceServerRepository;
import de.adorsys.sts.resourceserver.persistence.ResourceServerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

//@Configuration
//@Import(KeyManagementCoreConfiguration.class)
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class StsCoreConfiguration {
}
