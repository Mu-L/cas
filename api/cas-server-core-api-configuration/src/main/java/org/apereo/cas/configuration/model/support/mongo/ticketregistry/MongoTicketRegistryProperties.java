package org.apereo.cas.configuration.model.support.mongo.ticketregistry;

import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties;
import org.apereo.cas.configuration.model.support.mongo.BaseMongoDbProperties;
import org.apereo.cas.configuration.support.RequiresModule;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * This is {@link MongoTicketRegistryProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-mongo-ticket-registry")
@Slf4j
public class MongoTicketRegistryProperties extends BaseMongoDbProperties {
    
    private static final long serialVersionUID = 8243690796900311918L;

    /**
     * Whether collections should be dropped on startup and re-created.
     */
    private boolean dropCollection;

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    private EncryptionRandomizedSigningJwtCryptographyProperties crypto = new EncryptionRandomizedSigningJwtCryptographyProperties();

    public MongoTicketRegistryProperties() {
        this.crypto.setEnabled(false);
    }

    public EncryptionRandomizedSigningJwtCryptographyProperties getCrypto() {
        return crypto;
    }

    public void setCrypto(final EncryptionRandomizedSigningJwtCryptographyProperties crypto) {
        this.crypto = crypto;
    }
    
    public boolean isDropCollection() {
        return dropCollection;
    }

    public void setDropCollection(final boolean dropCollection) {
        this.dropCollection = dropCollection;
    }

}
