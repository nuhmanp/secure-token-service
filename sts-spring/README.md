# sts-spring

This provides annotations and configuration to integrate the functionality of secure-token-service into your spring-application.

## How to integrate

### Maven dependency

You can easily use this libraries in your spring boot app via maven dependency:

```
    <dependency>
        <groupId>de.adorsys.sts</groupId>
        <artifactId>sts-spring</artifactId>
        <version>${version}</version>
    </dependency>
```

### Annotations

You can easily use features by adding following annotations to your spring `@Configuration` class:

| Annotation | Description |
|------------|-------------|
| `@EnablePOP` | Enables the Proof-Of-Possession endpoint |
| `@EnableResourceServerInitialization` | Enables the initialization of the resource server configuration read from the spring properties |
| `@EnableEncryption` | Enables the encryption service bean |
| `@EnableDecryption` | Enables the decryption service bean |
| `@EnableKeyRotation` | Enables the key-rotation for the key-management |
| `@EnableServerInfo` | Enables the server-info endpoint |
| `@EnableTokenAuthentication` | Enables token-authentication-service bean |

