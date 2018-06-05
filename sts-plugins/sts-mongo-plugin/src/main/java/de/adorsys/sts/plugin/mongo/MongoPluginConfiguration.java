package de.adorsys.sts.plugin.mongo;

import com.mongodb.MongoClient;
import de.adorsys.lockpersistence.client.LockClient;
import de.adorsys.lockpersistence.client.SimpleLockClient;
import de.adorsys.lockpersistence.service.LockService;
import de.adorsys.sts.persistence.mongo.repository.MongoKeyStoreRepository;
import de.adorysys.lockpersistence.mongo.config.MongoLockPersistenceConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@ComponentScan(basePackages = {
        "de.adorsys.sts.persistence.mongo"
})
@ComponentScan(basePackageClasses = {
        MongoLockPersistenceConfiguration.class,

})
@EnableMongoRepositories(
        basePackageClasses = MongoKeyStoreRepository.class
)
public class MongoPluginConfiguration extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database:sts}")
    private String databaseName;

    @Bean
    LockClient lockClient(LockService lockService) {
        return new SimpleLockClient("sts.lock", lockService);
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }
}